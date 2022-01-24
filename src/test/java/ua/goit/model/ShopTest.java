package ua.goit.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ua.goit.repository.Storage;

public class ShopTest {

    // here we go with "Step 2" ;)
    // The general idea of unit testing - isolation, so we shouldn't use any dependency
    // instead we use Mockito library.
    // You have to create in init method Map what you want get from Storage and mock the response instead of putting objects in real object
    Storage storage = new Storage();
    Shop shop = new Shop(storage);

    @Before
    public void init() {
        Product A = new Product('A', 1.25, 3, 3.00);
        Product B = new Product('B', 4.25, 0, 0.00);
        Product C = new Product('C', 1.00, 6, 5.00);
        Product D = new Product('D', 0.75, 0, 0.00);
        storage.putIntoStorage(A);
        storage.putIntoStorage(B);
        storage.putIntoStorage(C);
        storage.putIntoStorage(D);
    }

    @Test
    public void testAnswerIsDouble() {
        String productSet = "ABCDABA";
        Assert.assertTrue("Double", shop.getFinalPrice(productSet) instanceof Double);
    }

    @Test
    public void testAnswerEquals_3A_2B_1C_1D() {
        String productSet = "ABCDABA";
        Assert.assertEquals(13.25, shop.getFinalPrice(productSet), 0.00001);
    }

    @Test
    public void testAnswerEquals_5A_3B_3C_3D() {
        // if you want to be sure that products will be always with upper case create a private method for it
        String productSet = "AAAAABBBCCCDDD";
        Assert.assertEquals(23.5, shop.getFinalPrice(productSet), 0.00001);
    }

    @Test
    public void testIsToUpperCase() {
        String productSet = "abCdAbA";
        Assert.assertEquals(13.25, shop.getFinalPrice(productSet), 0.00001);
    }


    @Test
    public void testAnswerIsNotNull() {
        String productSet = " ";
        Assert.assertNotNull(shop.getFinalPrice(productSet));
    }

    @Test
    public void testAnswerIgnoreUnknownProducts() {
        String productSet = "ABCDABA ERTHYUIOP45fsvgsevzfffvfvf";
        Assert.assertEquals(13.25, shop.getFinalPrice(productSet), 0.00001);
    }
}