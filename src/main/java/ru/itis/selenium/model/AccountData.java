package ru.itis.selenium.model;

public class AccountData {

    private String email;
    private String password;

    public AccountData() {  }

    public AccountData(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "AccountData{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
