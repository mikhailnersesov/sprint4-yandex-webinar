package ru.yandex.praktikum.fluent_interface;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends BasePage {
    private final By orderStatusButtonLocator = By.xpath("//button[text()='Статус заказа']");
    private final By orderNumberFieldLocator = By.xpath(".//input[@placeholder='Введите номер заказа']");
    private final By goButtonLocator = By.xpath("//button[text()='Go!']");

    public MainPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void openPage() {
        webDriver.get("https://qa-scooter.praktikum-services.ru/");
    }

    public void clickOrderStatusButton() {
        WebElement orderStatusButton = webDriver.findElement(orderStatusButtonLocator);
        orderStatusButton.click();
    }

    public void enterOrderNumber(String orderNumber) {
        WebElement searchField = webDriver.findElement(orderNumberFieldLocator);
        searchField.sendKeys("1234");
    }

    public void clickGoButton() {
        WebElement goButton = webDriver.findElement(goButtonLocator);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(goButton));
        goButton.click();
    }
}
