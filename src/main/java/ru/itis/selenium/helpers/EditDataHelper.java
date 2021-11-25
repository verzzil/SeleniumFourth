package ru.itis.selenium.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import ru.itis.selenium.ApplicationManager;
import ru.itis.selenium.json.model.EditProfileData;
import ru.itis.selenium.model.PersonalData;
import ru.itis.selenium.model.SalaryData;
import ru.itis.selenium.model.WebSiteData;

public class EditDataHelper extends HelperBase {

    public EditDataHelper(ApplicationManager manager) {
        super(manager);
    }

    public void editDataFields(EditProfileData person) {
        driver.findElement(By.name("speciality")).click();
        driver.findElement(By.name("speciality")).clear();
        driver.findElement(By.name("speciality")).sendKeys(person.getSpecialization());
        manager.getData().getExpectedPersonalData().setSpecialization(driver.findElement(By.name("speciality")).getAttribute("value"));
        driver.findElement(By.xpath("//div[@id='app']/div/div[2]/main/div/div/div/div/div/div[3]/div/form/div")).click();

        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Местоположение'])[1]/following::*[name()='svg'][2]")).click();
        driver.findElement(By.name("locationCountryId")).click();
        Select countrySelect = new Select(driver.findElement(By.name("locationCountryId")));
        countrySelect.selectByVisibleText(person.getCountry());
        manager.getData().getExpectedPersonalData().setCountry(countrySelect.getFirstSelectedOption().getText());

        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Местоположение'])[1]/following::*[name()='svg'][2]")).click();
        driver.findElement(By.name("locationRegionId")).click();
        Select regionSelect = new Select(driver.findElement(By.name("locationRegionId")));
        regionSelect.selectByVisibleText(person.getRegion());
        manager.getData().getExpectedPersonalData().setRegion(regionSelect.getFirstSelectedOption().getText());


        driver.findElement(By.name("locationCityId")).click();
        Select citySelect = new Select(driver.findElement(By.name("locationCityId")));
        citySelect.selectByVisibleText(person.getCity());
        manager.getData().getExpectedPersonalData().setCity(citySelect.getFirstSelectedOption().getText());

        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    public void addWebSite(WebSiteData webSiteData) {
        driver.get("https://habr.com/ru/all/");
        driver.findElement(By.xpath("//div[@id='app']/div/div[2]/div[2]/div")).click();
        driver.findElement(By.xpath("//div[@id='app']/div/div[2]/div[2]/div")).click();
        driver.findElement(By.xpath("//div[@id='app']/div/div[2]/div[2]/div/div/div[2]/div[3]/div/div/div/img")).click();
        driver.findElement(By.xpath("//div[@id='app']/div/div[2]/div[2]/div/div/div[2]/div[3]/div/div[2]/div/div[5]/a/span")).click();
        driver.findElement(By.xpath("//button[@type='button']")).click();
        driver.findElement(By.name("contactValue")).click();
        driver.findElement(By.name("contactValue")).clear();
        driver.findElement(By.name("contactValue")).sendKeys(webSiteData.getUrl());
        manager.getData().getExpectedWebSiteData().setUrl(driver.findElement(By.name("contactValue")).getAttribute("value"));
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    public void changeDesiredSalary(SalaryData salaryData) {
        driver.get("https://habr.com/ru/all/");
        driver.findElement(By.xpath("//div[@id='app']/div/div[2]/div[2]/div/div/div[2]/div[3]/div/div/div/img")).click();
        driver.findElement(By.xpath("//div[@id='app']/div/div[2]/div[2]/div/div/div[2]/div[3]/div/div[2]/div/div[5]/a/span")).click();
        driver.findElement(By.linkText("Специализация")).click(); // todo сделать навигацию на страницу по url
        driver.findElement(By.name("salary")).click();
        driver.findElement(By.name("salary")).clear();
        driver.findElement(By.name("salary")).sendKeys(salaryData.getQuantity());
        driver.findElement(By.name("currency")).click();
        new Select(driver.findElement(By.name("currency"))).selectByVisibleText(salaryData.getCurrency());
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }
}
