package ua.goit;

import ua.goit.model.Product;
import ua.goit.model.Shop;
import ua.goit.repository.Storage;

import java.util.Locale;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){

        Storage storage = new Storage();
        Product A = new Product('A',1.25,3,3.00);
        Product B = new Product('B',4.25,0,0.00);
        Product C = new Product('C',1.00,6,5.00);
        Product D = new Product('D',0.75,0,0.00);
        storage.putIntoStorage(A);
        storage.putIntoStorage(B);
        storage.putIntoStorage(C);
        storage.putIntoStorage(D);

        Shop shop = new Shop(storage);
        String productSet = "AAAA".toUpperCase();
        System.out.println("Final price = " + shop.getFinalPrice(productSet));
    }
}
