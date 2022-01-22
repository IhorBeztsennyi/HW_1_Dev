package ua.goit.repository;

// always delete unused imports

import org.junit.Assert;
import org.junit.Test;
import ua.goit.model.Product;

public class StorageTest {

    @Test
    public void testGetMyStorage() {
        Storage storage = new Storage();
        Assert.assertNotNull(storage.getMyStorage());
    }

    @Test
    public void testGetProductIsNotNull() {
        Storage storage = new Storage();
        Product A = new Product('A', 1.25, 3, 3.00);
        storage.putIntoStorage(A);
        Assert.assertNotNull("Product.class", storage.getProduct('A'));
    }
}