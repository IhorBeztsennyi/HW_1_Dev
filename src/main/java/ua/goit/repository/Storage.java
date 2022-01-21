package ua.goit.repository;

import ua.goit.model.Product;

import java.util.HashMap;
import java.util.Map;

public class Storage {

    public Map<Character, Product> getMyStorage() {
        return myStorage;
    }

    private final Map<Character, Product> myStorage = new HashMap<>();

    public void putIntoStorage(Product product){
        myStorage.put(product.getName(), product);
    }

    public Product getProduct(Character name){
        return myStorage.get(name);
}




}
