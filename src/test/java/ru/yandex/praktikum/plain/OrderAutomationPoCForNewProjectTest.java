package ru.yandex.praktikum.plain;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
@RunWith(Parameterized.class)
public class OrderAutomationPoCForNewProjectTest {
    @Parameterized.Parameter
    public String browserType;
    private WebDriver webDriver;

    //solution for multi-browser tests
    @Parameterized.Parameters
    public static Object[][] browsers() {
        return new Object[][]{
                {"chrome"},
                {"firefox"}

        };
    }

    @Before
    public void setup() {
        // solution for singleBrowser test
        //String browser = System.getProperty("browser");
        if (browserType.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            webDriver = new ChromeDriver();
        } else if (browserType.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup(); // layer between the code and the Web Browser, so we are not directly speaking from code with browser
            /*Rest client via the driver can manage the browser*/
            webDriver = new FirefoxDriver();
        }

    }

    @Test
    public void orderNotFoundShouldBeVisiable() {

        webDriver.get("https://qa-scooter.praktikum-services.ru/");
        WebElement orderStatusButton = webDriver.findElement(By.xpath("//button[text()='Статус заказа']"));
        orderStatusButton.click();
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, 30);

        WebElement searchField = webDriver.findElement(By.xpath(".//input[@placeholder='Введите номер заказа']"));
        searchField.sendKeys("1234");
        WebElement goButton = webDriver.findElement(By.xpath("//button[text()='Go!']"));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(searchField));
        goButton.click();
        WebElement notFoundImage = webDriver.findElement(By.xpath("//img[@alt='Not found']"));
        boolean displayed = notFoundImage.isDisplayed();
        Assert.assertTrue(displayed);

    }

    @After
    public void tearDown() {
        webDriver.quit();
    }
}
