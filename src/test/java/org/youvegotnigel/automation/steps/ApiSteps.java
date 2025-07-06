package org.youvegotnigel.automation.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import org.youvegotnigel.automation.context.ApiTestContext;
import org.youvegotnigel.automation.pojo.CreateOrder;
import org.youvegotnigel.automation.pojo.LoginRequest;
import org.youvegotnigel.automation.pojo.LoginResponse;
import org.youvegotnigel.automation.pojo.OrderDetail;
import org.youvegotnigel.automation.routes.Routes;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class ApiSteps {

    private final ApiTestContext context = new ApiTestContext();

    @Given("^I login successfully as \"(.+)\" user$")
    public void authenticate_user(String userEmail) {

        RequestSpecification reqSpec = new RequestSpecBuilder()
                .setBaseUri(Routes.BASE_URL)
                .setContentType(ContentType.JSON)
                .build();

        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUserEmail(userEmail);
        loginRequest.setUserPassword("Qwer1234");

        RequestSpecification reqLogin = given().log().all().spec(reqSpec).body(loginRequest);

        LoginResponse loginResponse = reqLogin.when().post(Routes.LOGIN_PATH)
                .then().log().all().extract().response().as(LoginResponse.class);

        context.setToken(loginResponse.getToken());
        context.setUserId(loginResponse.getUserId());
    }


    @And("^I add a watch product with below information:$")
    public void add_product(DataTable dataTable) {

        RequestSpecification addProductReqSpec = new RequestSpecBuilder().setBaseUri(Routes.BASE_URL)
                .addHeader("Authorization", context.getToken()).build();

        Map<String, String> formValues = dataTable.transpose().asMap();

        RequestSpecification reqAddProduct =
                given().spec(addProductReqSpec).log().all()
                        .formParams(formValues)
                        .param("productAddedBy", context.getUserId())
                        .multiPart("productImage", new File(Routes.WATCH_IMAGE_PATH));

        String addProductResponse = reqAddProduct.when().post(Routes.ADD_PRODUCT_PATH).then().log().all().extract().response().asString();
        context.setProductId(new JsonPath(addProductResponse).getString("productId"));
    }


    @And("^I create a order form \"(.+)\"$")
    public void create_order(String country) {

        RequestSpecification createOrderReqSpec = new RequestSpecBuilder().setBaseUri(Routes.BASE_URL)
                .setContentType(ContentType.JSON)
                .addHeader("Authorization", context.getToken()).build();

        List<OrderDetail> orderDetails = new ArrayList<>();

        OrderDetail order1 = new OrderDetail();
        order1.setCountry(country);
        order1.setProductOrderedId(context.getProductId());

        orderDetails.add(order1);

        CreateOrder createOrder = new CreateOrder();
        createOrder.setOrders(orderDetails);

        RequestSpecification reqCreateOrder = given().spec(createOrderReqSpec).log().all()
                        .body(createOrder);

        String resCreateOrder = reqCreateOrder.when().post(Routes.CREATE_ORDER_PATH)
                .then().log().all().extract().response().asString();

        context.setOrderId(new JsonPath(resCreateOrder).getString("orders[0]"));
    }

    
    @Then("^the order details should be displayed as below:$")
    public void verify_order_details(DataTable dataTable) {

        RequestSpecification getOrderDetailsReqSpec = new RequestSpecBuilder().setBaseUri(Routes.BASE_URL)
                .addHeader("Authorization", context.getToken()).build();

        // NOTE: Use case of query parameters
        RequestSpecification reqGetOrder =
                given().spec(getOrderDetailsReqSpec).log().all().param("id", context.getOrderId());

        reqGetOrder.when().get(Routes.ORDER_DETAILS_PATH).then().log().all().extract().response().asString();

    }


}
