package ua.goit;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import ua.goit.model.Product;
import ua.goit.repository.Storage;

import java.util.HashMap;
import java.util.Map;


public class AppTest {

    Storage storage = Mockito.mock(Storage.class);

    @Before
    public void init() {
        Product A = new Product('A', 1.25, 3, 3.00);

    }

    @Test
    public void testPutIntoStorage() {
        Map<Character, Product> myStorage = new HashMap<>();
        Mockito.when(storage.getMyStorage()).thenReturn(myStorage);
    }

}



