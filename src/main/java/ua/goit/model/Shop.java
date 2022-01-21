package ua.goit.model;

import ua.goit.repository.Storage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Shop {

    private Storage storage;

    public Shop(Storage storage) {
        this.storage = storage;
    }


    public Double getFinalPrice(String request) {
        Double result = 0.0;
        HashMap<Character, Integer> productsWithQuantity = quantityOfProducts(request);
        for (Character name : productsWithQuantity.keySet()) {
            Product product = storage.getProduct(name);
            if (product.getPromotionAmount()>0 && product.getPromotionPrice()>0.0){
                int i = productsWithQuantity.get(name);
                while (i>0){
                    if ((i-product.getPromotionAmount()>=0)){
                        result += product.getPromotionPrice();
                        i-= product.getPromotionAmount();
                    } else {
                        result += product.getPricePerOne();
                        i--;
                    }
                }
            } else {
                result += product.getPricePerOne()*productsWithQuantity.get(name);
            }
        }
        return result;
    }

    private HashMap<Character, Integer> quantityOfProducts(String request) {
        HashMap<Character, Integer> productsWithQuantity = new HashMap<>();
        ArrayList<Character> chars = new ArrayList<>(
                request.chars()
                        .mapToObj(e -> (char) e)
                        .collect(Collectors.toList()));

        for (Character name : chars) {
            if (productsWithQuantity.keySet().contains(name)) {
                productsWithQuantity.put(name, productsWithQuantity.get(name) + 1);
            } else if (storage.getMyStorage().containsKey(name)){
                productsWithQuantity.put(name, 1);
            }
        }
        return productsWithQuantity;
    }


}
