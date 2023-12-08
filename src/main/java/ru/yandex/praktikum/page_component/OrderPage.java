package ru.yandex.praktikum.page_component;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderPage extends BasePage {

    private final By notFoundImageLocator = By.xpath("//img[@alt='Not found']");

    public OrderPage(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean isNotFoundImageDisplyed(){
        WebElement notFoundImage = webDriver.findElement(notFoundImageLocator);
        return notFoundImage.isDisplayed();
    }
}
