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

    //what do the method?
    @Before
    public void init() {
        Product A = new Product('A', 1.25, 3, 3.00);

    }

    @Test
    public void testPutIntoStorage() {
        // what do we test? the name testPutIntoStorage but we don't put anything only mock
        // we need some action to test it.
        // I'm not sure that we should test main class without any logic
        Map<Character, Product> myStorage = new HashMap<>();
        Mockito.when(storage.getMyStorage()).thenReturn(myStorage);
    }

}



