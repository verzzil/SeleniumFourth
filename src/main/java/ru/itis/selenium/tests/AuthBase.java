package ru.itis.selenium.tests;

import org.junit.Assert;
import org.junit.Before;
import ru.itis.selenium.json.JSONParser;

public class AuthBase extends TestBase {

    private final JSONParser jsonParser = new JSONParser();

    public static boolean isLogged = false;

    @Before
    public void setUp() {
        super.setUp();

        if (!isLogged) {
            app.getAuth().login(jsonParser.parseLoginJson());
            isLogged = app.getAuth().checkLogin();
        } else
            Assert.fail();
    }
}
