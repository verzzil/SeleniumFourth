package ru.itis.selenium.helpers;

import ru.itis.selenium.ApplicationManager;
import ru.itis.selenium.model.*;


public class DataHelper extends HelperBase {

    private final AccountData expectedAccountData = new AccountData("xannanov.albert@mail.ru", "qwerty007");
    private final PersonalData expectedPersonalData = new PersonalData();
    private final WebSiteData expectedWebSiteData = new WebSiteData();
    private final SalaryData expectedSalaryData = new SalaryData("1000000", Currency.EURO);

    public DataHelper(ApplicationManager manager) {
        super(manager);
    }

    public PersonalData getExpectedPersonalData() {
        return expectedPersonalData;
    }

    public WebSiteData getExpectedWebSiteData() {
        return expectedWebSiteData;
    }

    public AccountData getExpectedAccountData() {
        return expectedAccountData;
    }

    public SalaryData getExpectedSalaryData() {
        return expectedSalaryData;
    }
}
