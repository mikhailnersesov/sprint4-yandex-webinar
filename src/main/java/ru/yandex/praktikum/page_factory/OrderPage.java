package ru.yandex.praktikum.page_factory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderPage extends BasePage {
    @FindBy(xpath = "//img[@alt='Not found']")
    private WebElement notFoundImage;

    public OrderPage(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean isNotFoundImageDisplyed() {
        return notFoundImage.isDisplayed();
    }
}
