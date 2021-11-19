package ru.itis.selenium;

import org.junit.Assert;
import org.junit.Test;
import ru.itis.selenium.tests.TestBase;

public class EditDataTestCase extends TestBase {

    @Test
    public void editData() {
        app.getNavigation().goToAccount();
        app.getContact().editDataFields(changedUserData);

        Assert.assertEquals(app.getData().getSpecialization(), changedUserData.getSpecialization());
        Assert.assertEquals(app.getData().getCountry(), changedUserData.getCountry());
        Assert.assertEquals(app.getData().getCity(), changedUserData.getCity());
        Assert.assertEquals(app.getData().getRegion(), changedUserData.getRegion());
    }
}

