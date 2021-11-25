package ru.itis.selenium;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import ru.itis.selenium.json.JSONParser;
import ru.itis.selenium.json.model.LoginData;
import ru.itis.selenium.model.AccountData;
import ru.itis.selenium.model.PersonalData;
import ru.itis.selenium.tests.TestBase;

public class AuthorizationTestCase extends TestBase {

    private final JSONParser jsonParser = new JSONParser();

    @After
    public void logout() {
        app.getAuth().logout();
    }

    @Test
    public void authorizationTestCaseWithValidData() throws InterruptedException {
        LoginData data = jsonParser.parseLoginJson();

        app.getNavigation().openHomePage();
        app.getNavigation().openGroupPage();
        app.getAuth().login(data);

        Thread.sleep(5000);
        if (app.getAuth().checkLogin())
            Assert.assertTrue(true);
        else
            Assert.fail();
    }

    @Test
    public void authorizationTestCaseWithNotValidData() {
        LoginData data = new LoginData("xan@mail.ru", "qwerty008");

        app.getNavigation().openHomePage();
        app.getNavigation().openGroupPage();
        app.getAuth().login(data);

        if (!app.getAuth().checkLogin())
            Assert.assertTrue(true);
        else
            Assert.fail();
    }

}
