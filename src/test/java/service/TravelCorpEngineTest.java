package service;

import model.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by GVGADAVE on 20/09/2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class TravelCorpEngineTest {

    TravelCorpEngine travelCorpEngine = new TravelCorpEngine();

    @Test
    public void testCalculateTotalForAllSingleItems(){
        List< Product> productList = new ArrayList();
        productList.add(new Product("Butter", 1));
        productList.add(new Product("Bread", 1));
        productList.add(new Product("Milk", 1));
        assertEquals(2.95,travelCorpEngine.calculateTotal(productList), 0.001);
    }

    @Test
    public void testCalculateTotalWithDiscountOnBread(){
        List< Product> productList = new ArrayList();
        productList.add(new Product("Butter", 2));
        productList.add(new Product("Bread", 2));
        assertEquals(3.1,travelCorpEngine.calculateTotal(productList), 0.001);
    }

    @Test
    public void testCalculateTotalWithDiscountOnSomeBread(){
        List< Product> productList = new ArrayList();
        productList.add(new Product("Butter", 3));
        productList.add(new Product("Bread", 1));
        assertEquals(2.9,travelCorpEngine.calculateTotal(productList), 0.001);
    }

    @Test
    public void testCalculateTotalWithDiscountOnMultipleBreads(){
        List< Product> productList = new ArrayList();
        productList.add(new Product("Butter", 7));
        productList.add(new Product("Bread", 2));
        productList.add(new Product("Milk", 2));
        assertEquals(8.9,travelCorpEngine.calculateTotal(productList), 0.001);
    }

    @Test
    public void testCalculateTotalWithDiscountOnMilk(){
        List< Product> productList = new ArrayList();
        productList.add(new Product("Milk", 4));
        assertEquals(3.45,travelCorpEngine.calculateTotal(productList), 0.001);
    }

    @Test
    public void testCalculateTotalWhenBothDiscounts(){
        List< Product> productList = new ArrayList();
        productList.add(new Product("Butter", 2));
        productList.add(new Product("Bread", 1));
        productList.add(new Product("Milk", 8));
        assertEquals(9.0,travelCorpEngine.calculateTotal(productList), 0.001);
    }
}