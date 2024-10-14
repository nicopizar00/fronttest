package fronttest.definitions;

import fronttest.util.Helper;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hook {
    @Before
    public static void setUp(){
        Helper.setUpDriver();
    }

    @After
    public static void tearDown(){
        Helper.tearDown();
    }
}
