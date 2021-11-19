package ru.itis.selenium.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import ru.itis.selenium.ApplicationManager;
import ru.itis.selenium.model.PersonalData;

public class ContactHelper extends HelperBase {

    public ContactHelper(ApplicationManager manager) {
        super(manager);
    }

    public void editDataFields(PersonalData person) {
        driver.findElement(By.name("speciality")).click();
        driver.findElement(By.name("speciality")).clear();
        driver.findElement(By.name("speciality")).sendKeys(person.getSpecialization());
        manager.getData().setSpecialization(driver.findElement(By.name("speciality")).getAttribute("value"));
        driver.findElement(By.xpath("//div[@id='app']/div/div[2]/main/div/div/div/div/div/div[3]/div/form/div")).click();

        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Местоположение'])[1]/following::*[name()='svg'][2]")).click();
        driver.findElement(By.name("locationCountryId")).click();
        Select countrySelect = new Select(driver.findElement(By.name("locationCountryId")));
        countrySelect.selectByVisibleText(person.getCountry());
        manager.getData().setCountry(countrySelect.getFirstSelectedOption().getText());

        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Местоположение'])[1]/following::*[name()='svg'][2]")).click();
        driver.findElement(By.name("locationRegionId")).click();
        Select regionSelect = new Select(driver.findElement(By.name("locationRegionId")));
        regionSelect.selectByVisibleText(person.getRegion());
        manager.getData().setRegion(regionSelect.getFirstSelectedOption().getText());


        driver.findElement(By.name("locationCityId")).click();
        Select citySelect = new Select(driver.findElement(By.name("locationCityId")));
        citySelect.selectByVisibleText(person.getCity());
        manager.getData().setCity(citySelect.getFirstSelectedOption().getText());

        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }
}
