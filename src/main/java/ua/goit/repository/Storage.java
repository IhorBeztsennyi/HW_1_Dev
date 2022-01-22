package ua.goit.repository;

import ua.goit.model.Product;

import java.util.HashMap;
import java.util.Map;

public class Storage {

    // please separate fields and methods. Following convention fields should be on the top
    private final Map<Character, Product> myStorage = new HashMap<>();

    public Map<Character, Product> getMyStorage() {
        return myStorage;
    }

    public void putIntoStorage(Product product) {
        myStorage.put(product.getName(), product);
    }

    public Product getProduct(Character name) {
        return myStorage.get(name);
    }
}
