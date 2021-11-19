package ru.itis.selenium.helpers;

import ru.itis.selenium.ApplicationManager;

public class DataHelper extends HelperBase {

    private String specialization;
    private String country;
    private String region;
    private String city;

    public DataHelper(ApplicationManager manager) {
        super(manager);
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
