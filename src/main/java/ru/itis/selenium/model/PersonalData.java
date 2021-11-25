package ru.itis.selenium.model;

public class PersonalData {

    private String specialization;
    private String country;
    private String region;
    private String city;

    public PersonalData() { }

    public PersonalData(String specialization, String country, String region, String city) {
        this.specialization = specialization;
        this.country = country;
        this.region = region;
        this.city = city;
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
