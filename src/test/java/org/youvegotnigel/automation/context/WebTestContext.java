package org.youvegotnigel.automation.context;

public class WebTestContext {

    private String productPrice;
    private String productName;

    public String getProductName() {
        return productName;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }
}
