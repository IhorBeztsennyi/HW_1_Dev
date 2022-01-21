package ua.goit.repository;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import ua.goit.model.Product;

import java.util.HashMap;
import java.util.Map;

public class StorageTest {

    @Test
    public void testGetMyStorage() {
        Storage storage = new Storage();
        Assert.assertNotNull(storage.getMyStorage());
    }
    @Test
    public void testGetProduct() {
        Storage storage = new Storage();
        Product A = new Product('A',1.25,3,3.00);
        storage.putIntoStorage(A);
        Map<Character, Product> myStorage = new HashMap<>();
        Assert.assertTrue("Product.class", storage.getProduct('A')instanceof Product);

    }
}