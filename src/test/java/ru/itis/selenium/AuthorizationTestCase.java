package ru.itis.selenium;

import org.junit.Test;
import ru.itis.selenium.model.AccountData;
import ru.itis.selenium.model.PersonalData;
import ru.itis.selenium.tests.TestBase;

public class AuthorizationTestCase extends TestBase {

    @Test
    public void authorizationTestCase() {
        app.getNavigation().openHomePage();
        app.getNavigation().openGroupPage();
        app.getAuth().login(user);
    }

}

