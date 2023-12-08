package ru.yandex.praktikum.page_object;

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

    public MainPage openPage() {
        webDriver.get("https://qa-scooter.praktikum-services.ru/");
        return this;
    }

    public MainPage clickOrderStatusButton() {
        WebElement orderStatusButton = webDriver.findElement(orderStatusButtonLocator);
        orderStatusButton.click();
        return this;
    }

    public MainPage enterOrderNumber(String orderNumber) {
        WebElement searchField = webDriver.findElement(orderNumberFieldLocator);
        searchField.sendKeys("1234");
    return this;
    }

    public OrderPage clickGoButton() {
        WebElement goButton = webDriver.findElement(goButtonLocator);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(goButton));
        goButton.click();
        return new OrderPage(webDriver);
    }
}
