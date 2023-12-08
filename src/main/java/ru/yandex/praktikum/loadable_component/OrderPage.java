package ru.yandex.praktikum.loadable_component;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderPage extends BasePage {

    private final By notFoundImageLocator = By.xpath("//img[@alt='Not found']");
    private final By lastElementInDomLocator = By.id("has-qtest-add-on");

    public OrderPage(WebDriver webDriver) {
        super(webDriver);
    }
    public boolean isLastElementInDomAvaliable(){
        WebElement lastElementInDom = webDriver.findElement(lastElementInDomLocator);
        lastElementInDom.isDisplayed();
        return true;
    }

    public boolean isNotFoundImageDisplyed(){
        WebElement notFoundImage = webDriver.findElement(notFoundImageLocator);
        return notFoundImage.isDisplayed();
    }
    @Override
    protected void load() {
        webDriver.get("https://qa-scooter.praktikum-services.ru/");
    }

    @Override
    protected void isLoaded() throws Error {
        Assert.assertTrue(isLastElementInDomAvaliable());
    }
}
