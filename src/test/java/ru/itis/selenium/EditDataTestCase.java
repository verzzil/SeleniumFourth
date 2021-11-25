package ru.itis.selenium;

import org.junit.Assert;
import org.junit.Test;
import ru.itis.selenium.json.JSONParser;
import ru.itis.selenium.json.model.EditProfileData;
import ru.itis.selenium.model.PersonalData;
import ru.itis.selenium.tests.AuthBase;
import ru.itis.selenium.tests.TestBase;

public class EditDataTestCase extends AuthBase {

    private final JSONParser jsonParser = new JSONParser();

    @Test
    public void editData() {
        app.getNavigation().goToAccount();
        EditProfileData parsedData = jsonParser.parseEditProfileJson();
        if (!isLogged)
        app.getEditData().editDataFields(parsedData);

        Assert.assertEquals(app.getData().getExpectedPersonalData().getSpecialization(), parsedData.getSpecialization());
        Assert.assertEquals(app.getData().getExpectedPersonalData().getCountry(), parsedData.getCountry());
        Assert.assertEquals(app.getData().getExpectedPersonalData().getCity(), parsedData.getCity());
        Assert.assertEquals(app.getData().getExpectedPersonalData().getRegion(), parsedData.getRegion());
    }
}

