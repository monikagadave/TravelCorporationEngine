package model;

import java.math.BigDecimal;

/**
 * Created by GVGADAVE on 20/09/2016.
 */
public enum ProductCost {

    Butter(0.8),
    Milk(1.15),
    Bread(1.0);

    Double cost;

    ProductCost(Double cost){
        this.cost = cost;
    }

    public Double cost(){
        return cost;
    }
}
