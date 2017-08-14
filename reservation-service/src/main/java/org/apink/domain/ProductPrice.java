package org.apink.domain;

public class ProductPrice {

    private int price;
    private int discountRate;
    private String productPriceType;
    private String description;

    @Override
    public String toString() {
        return "ProductPrice{" +
                "price=" + price +
                ", discountRate=" + discountRate +
                ", productPriceType=" + productPriceType +
                ", description='" + description + '\'' +
                '}';
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(int discountRate) {
        this.discountRate = discountRate;
    }

    public String getProductPriceType() {
        return productPriceType;
    }

    public void setProductPriceType(String productPriceType) {
        this.productPriceType = productPriceType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
