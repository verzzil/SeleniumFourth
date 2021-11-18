package ru.itis.selenium.tests;

import org.junit.Before;
import ru.itis.selenium.ApplicationManager;
import ru.itis.selenium.model.AccountData;
import ru.itis.selenium.model.PersonalData;

public class TestBase {

    public ApplicationManager app;

    protected AccountData user = new AccountData("xannanov.albert@mail.ru", "qwerty007");
    protected PersonalData changedUserData = new PersonalData(null, "Андроид-разработчик", null, "Россия", "Татарстан", "Казань", null, null);

    @Before
    public void setUp() throws Exception {
        app = ApplicationManager.getInstance();
    }
}
