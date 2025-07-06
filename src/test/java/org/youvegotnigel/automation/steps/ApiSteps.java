package org.youvegotnigel.automation.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import org.youvegotnigel.automation.context.ApiTestContext;
import org.youvegotnigel.automation.pojo.LoginRequest;
import org.youvegotnigel.automation.pojo.LoginResponse;
import org.youvegotnigel.automation.routes.Routes;

import java.io.File;
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

        LoginResponse loginResponse = reqLogin
                                        .when().post(Routes.LOGIN_PATH)
                                        .then().log().all().extract().response().as(LoginResponse.class);

        context.setToken(loginResponse.getToken());
        context.setUserId(loginResponse.getUserId());
    }


    @And("^I add a watch product with below information:$")
    public void add_product(DataTable dataTable) {

        Map<String, String> formValues = dataTable.transpose().asMap();

        RequestSpecification addProductReqSpec = new RequestSpecBuilder().setBaseUri(Routes.BASE_URL)
                .addHeader("Authorization", context.getToken()).build();

        RequestSpecification reqAddProduct =
                given().spec(addProductReqSpec).log().all()
                        .formParams(formValues)
                        .multiPart("productImage", new File(Routes.WATCH_IMAGE_PATH));

        String addProductResponse = reqAddProduct.when().post(Routes.ADD_PRODUCT_PATH).then().log().all().extract().response().asString();
        context.setProductId(new JsonPath(addProductResponse).getString("productId"));
    }


}
