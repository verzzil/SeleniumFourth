package ru.itis.selenium.json.model;

public class EditProfileData {

    private String specialization;
    private String country;
    private String region;
    private String city;

    public EditProfileData() { }

    public EditProfileData(String specialization, String region, String city) {
        this.specialization = specialization;
        this.country = "Россия";
        this.city = city;
        this.region = region;
    }

    @Override
    public String toString() {
        return "EditProfileData{" +
                "specialization='" + specialization + '\'' +
                ", country='" + country + '\'' +
                ", region='" + region + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    public String getSpecialization() {
        return specialization;
    }

    public String getCountry() {
        return country;
    }

    public String getRegion() {
        return region;
    }

    public String getCity() {
        return city;
    }
}
