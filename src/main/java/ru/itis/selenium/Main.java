package ru.itis.selenium;

import ru.itis.selenium.json.JSONGenerator;
import ru.itis.selenium.json.JSONParser;
import ru.itis.selenium.json.model.EditProfileData;
import ru.itis.selenium.json.model.LoginData;

import java.util.Scanner;

public class Main {

    private static Scanner scan;
    private static final JSONGenerator jsonGenerator = new JSONGenerator();
    private static final JSONParser jsonParser = new JSONParser();

    private static final String[] regions = new String[]{"Башкортостан(Башкирия)", "Татарстан"};
    private static final String[] bashkortList = new String[]{"Агидель", "Аксаково", "Амзя", "Архангелькое", "Аскарово", "Аскино", "Баймак", "Бакалы", "Белебей", "Белорецк", "Бижбуляк", "Бирск", "Благовещенск", "Большеустьикинское", "Бураево", "Верхнеяркеево", "Верхние", "Верхние", "Верхний", "Давлеканово", "Дуван", "Дюртюли", "Ермекеево", "Ермолаево", "Зилаир", "Зирган", "Иглино", "Инзер", "Исянгулово", "Ишимбай", "Калтасы", "Кананикольское", "Кандры", "Караидель", "Караидельский", "Киргиз", "Красноусольский", "Кумертау", "Кушнаренково", "Малояз", "Межгорье", "Мелеуз", "Месягутово", "Мраково", "Нефтекамск", "Октябрьский", "Приютово", "Раевский", "Салават", "Сибай", "Старобалтачево", "Старосубхангулово", "Стерлибашево", "Стерлитамак", "Туймазы", "Уфа", "Учалы", "Федоровка", "Чекмагуш", "Чишмы", "Шаран", "Янаул"};
    private static final String[] tatarstanList = new String[]{"Агрыз", "Азнакаево", "Аксубаево", "Актаныш", "Актюбинский", "Алексеевское", "Альметьевск", "Апастово", "Арск", "Бавлы", "Базарные", "Балтаси", "Богатые", "Брежнев", "Бугульма", "Буинск", "Васильево", "Верхний", "Высокая", "Дербешкинский", "Елабуга", "Заинск", "Зеленодольск", "Иннополис", "Казань", "Камское", "Карабаш", "Куйбышев", "Кукмод", "Кукмор", "Лаишево", "Лениногорск", "Мамадыш", "Менделеевск", "Мензелинск", "Муслюмово", "Набережные", "Нижнекамск", "Новошешминск", "Нурлат", "Пестрецы", "Рыбная", "Сарманово", "Старое", "Тетюши", "Черемшан", "Чистополь"};

    public static void main(String[] args) {

        scan = new Scanner(System.in);
        System.out.println("Введите логин и пароль");
        generateLoginData(scan.nextLine(), scan.nextLine());

        System.out.println("Напишите свою профессию");
        String specialization = scan.nextLine();

        System.out.println("Выберете свой регион");
        String region = defineData(regions);

        System.out.println("Выберете город");
        String city = "";
        if (region.equals(regions[0])) {
            city = defineData(bashkortList);
        } else {
            city = defineData(tatarstanList);
        }

        generateEditProfileData(specialization, region, city);

        System.out.println(jsonParser.parseLoginJson());
        System.out.println(jsonParser.parseEditProfileJson());
    }

    private static String defineData(String[] array) {
        while (true) {
            for (int i = 0; i < array.length; i++) {
                System.out.print(i+1 + ". " + array[i] + "\t");
            }
            System.out.println();
            int defineNumber = scan.nextInt();
            if (defineNumber < 1 || defineNumber > array.length) {
                continue;
            }
            return array[defineNumber - 1];
        }
    }

    private static void generateLoginData(String login, String password) {
        jsonGenerator.generateLoginData(new LoginData(login, password));
    }

    private static void generateEditProfileData(String specialization, String city, String region) {
        jsonGenerator.generateEditProfileData(new EditProfileData(specialization, city, region));
    }
}
