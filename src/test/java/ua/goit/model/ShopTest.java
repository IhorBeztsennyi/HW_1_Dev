package ua.goit.model;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ua.goit.repository.Storage;

public class ShopTest {

    Storage storage = new Storage();
    Shop shop = new Shop(storage);

    @Before
    public void init(){
        Product A = new Product('A',1.25,3,3.00);
        Product B = new Product('B',4.25,0,0.00);
        Product C = new Product('C',1.00,6,5.00);
        Product D = new Product('D',0.75,0,0.00);
        storage.putIntoStorage(A);
        storage.putIntoStorage(B);
        storage.putIntoStorage(C);
        storage.putIntoStorage(D);
    }


    @Test
    public void testAnswerIsDouble(){
        String productSet = "ABCDABA".toUpperCase();
        Assert.assertTrue("Double", shop.getFinalPrice(productSet)instanceof Double );
    }

    @Test
    public void testAnswerEquals_3A_2B_1C_1D(){
        String productSet = "ABCDABA".toUpperCase();
        Assert.assertEquals(13.25, shop.getFinalPrice(productSet), 0.00001);
    }
    @Test
    public void testAnswerEquals_5A_3B_3C_3D(){
        // if you want be sure that products will be always with upper case create a private method for it
        String productSet = "AAAAABBBCCCDDD".toUpperCase();
        Assert.assertEquals(23.5, shop.getFinalPrice(productSet), 0.00001);
    }

    @Test
    // actually here we test the same method as in previous
    public void testAnswerEquals_6A_6B_6C_6D(){
        String productSet = "AAAAAABBBBBBCCCCCCDDDDDD".toUpperCase();
        Assert.assertEquals(41.0, shop.getFinalPrice(productSet), 0.00001);
    }

    @Test
    public void testAnswerIsNotNull(){
        String productSet = " ".toUpperCase();
        Assert.assertNotNull(shop.getFinalPrice(productSet));
    }

    @Test
    public void testAnswerIgnoreUnknownProducts(){
        String productSet = "ABCDABA ERTHYUIOP45fsvgsevzfffvfvf".toUpperCase();
        Assert.assertEquals(13.25, shop.getFinalPrice(productSet), 0.00001);
    }
}