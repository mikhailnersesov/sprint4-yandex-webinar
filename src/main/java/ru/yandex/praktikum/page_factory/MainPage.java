package ru.yandex.praktikum.page_factory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends BasePage {
    @FindBy(xpath = "//button[text()='Статус заказа']")
    private WebElement orderStatusButton;
    @FindBy(xpath = "//button[text()='Статус заказа']")
    private WebElement orderNumberField;
    @FindBy(xpath = "//button[text()='Go!']")
    private WebElement goButton;

    public MainPage(WebDriver webDriver) {
        super(webDriver);
    }

    public MainPage openPage() {
        webDriver.get("https://qa-scooter.praktikum-services.ru/");
        return this;
    }

    public MainPage clickOrderStatusButton() {
        orderStatusButton.click();
        return this;
    }

    public MainPage enterOrderNumber(String orderNumber) {
        orderNumberField.sendKeys("1234");
    return this;
    }

    public OrderPage clickGoButton() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(goButton));
        goButton.click();
        return new OrderPage(webDriver);
    }
}
