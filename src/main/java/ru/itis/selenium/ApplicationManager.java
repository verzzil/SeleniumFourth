package ru.itis.selenium;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.itis.selenium.helpers.EditDataHelper;
import ru.itis.selenium.helpers.DataHelper;
import ru.itis.selenium.helpers.LoginHelper;
import ru.itis.selenium.helpers.NavigationHelper;

import java.util.concurrent.TimeUnit;
import static org.junit.Assert.fail;

public class ApplicationManager {

    private final WebDriver driver;
    private final StringBuffer verificationErrors;
    JavascriptExecutor js;
    private boolean acceptNextAlert = true;

    private final NavigationHelper navigation;
    private final LoginHelper auth;
    private final EditDataHelper editData;
    private final DataHelper data;

    private static ThreadLocal<ApplicationManager> app = null;

    public static final String LOGIN_DATA_PATH = "D:\\Another\\Univercity\\Тесты\\SeleniumSecond\\src\\main\\java\\ru\\itis\\selenium\\login.json";
    public static final String EDIT_PROFILE_DATA_PATH = "D:\\Another\\Univercity\\Тесты\\SeleniumSecond\\src\\main\\java\\ru\\itis\\selenium\\editprofile.json";

    public static ApplicationManager getInstance() {
        if (app == null) {
            app = new ThreadLocal<>();
            ApplicationManager newInstance = new ApplicationManager();
            newInstance.navigation.openHomePage();
            app.set(newInstance);
        }
        return app.get();
    }

    public ApplicationManager() {
        System.setProperty("webdriver.chrome.driver", "D:\\Another\\Univercity\\Тесты\\SeleniumSecond\\chromedriver.exe");
        driver = new ChromeDriver();
        String baseUrl = "https://www.google.com/";
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        verificationErrors = new StringBuffer();
        js = (JavascriptExecutor) driver;
        navigation = new NavigationHelper(this, baseUrl);
        auth = new LoginHelper(this);
        editData = new EditDataHelper(this);
        data = new DataHelper(this);
    }

    public void stop() {
        driver.close();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    public WebDriver getDriver() {
        return driver;
    }

    public NavigationHelper getNavigation() {
        return navigation;
    }

    public LoginHelper getAuth() {
        return auth;
    }

    public EditDataHelper getEditData() {
        return editData;
    }

    public DataHelper getData() {
        return data;
    }
}
