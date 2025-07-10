package org.youvegotnigel.automation.context;

import java.util.HashMap;
import java.util.Map;

public class ApiTestContext {

    private final Map<String, Object> context = new HashMap<>();
    private String token;
    private String userId;
    private String productId;
    private String orderId;

    public void setContext(String key, Object value) {
        context.put(key, value);
    }

    @SuppressWarnings("unchecked")
    public <T> T getContext(String key) {
        return (T) context.get(key);
    }

    public boolean containsKey(String key) {
        return context.containsKey(key);
    }

    public void clearContext() {
        context.clear();
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

}
