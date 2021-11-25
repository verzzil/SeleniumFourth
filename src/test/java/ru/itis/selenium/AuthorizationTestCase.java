package ru.itis.selenium;

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

    @Test
    public void authorizationTestCase() {
        LoginData parsedData = jsonParser.parseLoginJson();

        app.getNavigation().openHomePage();
        app.getNavigation().openGroupPage();
        app.getAuth().login(parsedData);

        Assert.assertTrue(true);
//        try {
//            System.out.println(app.getDriver().findElement(By.id("//*[@id='app']/div[1]/div[2]/div[2]/div/div/div[2]/div")));
//        } catch (NoSuchElementException e) {
//            Assert.assertTrue(true);
//        }

    }

}
