package ru.itis.selenium.tests;

import org.junit.Before;
import ru.itis.selenium.ApplicationManager;

public class TestBase {

    public ApplicationManager app;

    @Before
    public void setUp() {
        app = ApplicationManager.getInstance();
    }
}
