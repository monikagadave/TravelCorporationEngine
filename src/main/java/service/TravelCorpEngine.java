package service;

import model.Product;
import model.ProductCost;

import java.util.List;
import java.util.Optional;

/**
 * Created by GVGADAVE on 20/09/2016.
 */
public class TravelCorpEngine {


    public static final String BUTTER = "Butter";
    public static final String MILK = "Milk";
    public static final String BREAD = "Bread";

    public Double calculateTotal(List<Product> products) {
        Double total = 0.0;

        for(Product product : products){
            String productName = product.getProductName();
            Double cost  = ProductCost.valueOf(productName).cost();
            Integer quantity = product.getQuantity();

            if(BREAD.equalsIgnoreCase(productName)){
                total += getTotalAfterDiscountOnBread(products, cost, quantity);
            }
            else if(MILK.equalsIgnoreCase(productName)){
                total += getTotalAfterDiscountOnMilk(cost, quantity);
            }
            else{
                total += cost * quantity;
            }
        }
        return total;
    }

    private Double getTotalAfterDiscountOnMilk(Double cost, Integer quantity) {
        int quantityToBePaid = quantity - (quantity / 4);
        return cost * quantityToBePaid;
    }

    private Double getTotalAfterDiscountOnBread(List<Product> products, Double cost, Integer quantity) {
        Double total = 0.0;
        Optional<Product> butterProduct = products.stream().filter(p -> BUTTER.equalsIgnoreCase(p.getProductName())).findAny();
        int discountBreadQuantity = butterProduct.isPresent() ? butterProduct.get().getQuantity() / 2 : 0;

        discountBreadQuantity = discountBreadQuantity > quantity ? quantity : discountBreadQuantity;
        total += (discountBreadQuantity * cost * 0.5);

        int nonDiscountBreadQuantity = quantity - discountBreadQuantity;
        if(nonDiscountBreadQuantity > 0){
            total += cost * nonDiscountBreadQuantity;
        }
        return total;
    }
}
