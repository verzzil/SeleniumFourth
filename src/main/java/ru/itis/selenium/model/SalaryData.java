package ru.itis.selenium.model;

public class SalaryData {

    private String quantity;
    private Currency currency;

    public SalaryData(String quantity, Currency currency) {
        this.quantity = quantity;
        this.currency = currency;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getCurrency() {
        return currency.getCode();
    }
}
