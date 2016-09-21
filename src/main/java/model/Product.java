package model;

import java.math.BigDecimal;

/**
 * Created by GVGADAVE on 20/09/2016.
 */
public class Product {

    private String productName;
    private Double cost;
    private Integer quantity;

    public Product(String productName){
        this.productName = productName;
    }

    public Product(String productName, Integer quantity){
        this.productName = productName;
        this.quantity = quantity;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}