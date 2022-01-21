package ua.goit.model;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ProductTest {

    @Before
    public void productCreating() {
        Product product = new Product('A', 1.25, 3, 3.00);
    }

    @Test
    public void testTestGetName() {
        Product product = new Product('A', 1.25, 3, 3.00);
        Assert.assertEquals('A', product.getName());
    }

    @Test
    public void testGetPricePerOne() {
        Product product = new Product('A', 1.25, 3, 3.00);
        Assert.assertEquals(1.25, product.getPricePerOne(), 0.00001);
    }

    @Test
    public void testGetPromotionAmount() {
        Product product = new Product('A', 1.25, 3, 3.00);
        Assert.assertEquals(3, product.getPromotionAmount());
    }

    @Test
    public void testGetPromotionPrice() {
        Product product = new Product('A', 1.25, 3, 3.00);
        Assert.assertEquals(3.0, product.getPromotionPrice(), 0.00001);
    }
}