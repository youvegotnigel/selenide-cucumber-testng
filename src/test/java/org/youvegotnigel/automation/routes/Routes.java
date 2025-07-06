package org.youvegotnigel.automation.routes;

public class Routes {

    public static final String BASE_URL = "https://rahulshettyacademy.com";
    public static final String LOGIN_PATH = "api/ecom/auth/login";
    public static final String ADD_PRODUCT_PATH = "api/ecom/product/add-product";
    public static final String CREATE_ORDER_PATH = "api/ecom/order/create-order";
    public static final String ORDER_DETAILS_PATH = "api/ecom/order/get-orders-details";
    public static final String DELETE_ORDER_PATH = "api/ecom/order/delete-order/{orderId}";
    public static final String DELETE_PRODUCT_PATH = "api/ecom/product/delete-product/{productId}";

    public static final String WATCH_IMAGE_PATH = System.getProperty("user.dir") + "/images/watch.png";
    public static final String SHOE_IMAGE_PATH = System.getProperty("user.dir") + "/images/shoe.png";
    public static final String BULB_IMAGE_PATH = System.getProperty("user.dir") + "/images/bulb.png";

}
