package ru.yandex.praktikum.page_component;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public abstract class BaseTest {
    protected WebDriver webDriver;

    @Before
    public void setup() {
        WebDriverManager.firefoxdriver().setup(); // layer between the code and the Web Browser, so we are not directly speaking from code with browser
        /*Rest client via the driver can manage the browser*/
        webDriver = new FirefoxDriver();
    }

    @After
    public void tearDown() {
        webDriver.quit();
    }
}
