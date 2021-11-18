package ru.itis.selenium;

import org.junit.Assert;
import org.junit.Test;
import ru.itis.selenium.tests.TestBase;

public class EditDataTestCase extends TestBase {

    @Test
    public void editData() {
        app.getNavigation().goToAccount();
        app.getContact().editDataFields(changedUserData);

        Assert.assertEquals(app.getContact().specialization, changedUserData.getSpecialization());
        Assert.assertEquals(app.getContact().country, changedUserData.getCountry());
        Assert.assertEquals(app.getContact().city, changedUserData.getCity());
        Assert.assertEquals(app.getContact().region, changedUserData.getRegion());
    }
}

