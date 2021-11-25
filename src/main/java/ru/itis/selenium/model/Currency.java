package ru.itis.selenium.model;

public enum Currency {
    EURO("€"), RUB("₽"), GRIVN("₴"), DOLLAR("$"), TENGE("₸");
    private String code;
    Currency(String code){
        this.code = code;
    }
    public String getCode(){ return code;}
}