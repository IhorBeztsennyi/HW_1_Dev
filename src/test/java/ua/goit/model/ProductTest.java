package ua.goit.model;

// always delete unused imports
import org.junit.Assert;
import org.junit.Test;

// If we test always the same input data we can do all asserts in one test
public class ProductTest {

    @Test
    public void testGetProductsParameters() {
        Product product = new Product('A', 1.25, 3, 3.00);
        Assert.assertEquals('A', product.getName());
        Assert.assertEquals(1.25, product.getPricePerOne(), 0.00001);
        Assert.assertEquals(3, product.getPromotionAmount());
        Assert.assertEquals(3.0, product.getPromotionPrice(), 0.00001);
    }
}