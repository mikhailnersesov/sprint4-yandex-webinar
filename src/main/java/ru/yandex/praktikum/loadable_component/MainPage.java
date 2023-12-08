package ru.yandex.praktikum.loadable_component;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends BasePage {
    private final By orderStatusButtonLocator = By.xpath("//button[text()='Статус заказа']");
    private final By orderNumberFieldLocator = By.xpath(".//input[@placeholder='Введите номер заказа']");
    private final By goButtonLocator = By.xpath("//button[text()='Go!']");
    private final By lastElementInDomLocator = By.id("accordion__heading-7");
    //WebElement lastElementInDom = webDriver.findElement(lastElementInDomLocator);

    public MainPage(WebDriver webDriver) {
        super(webDriver);
        //TODO priority #1
        //webDriverWait.until(ExpectedConditions.titleIs("Main page")); // to check each time that you are on the right page
        /* or */
        //TODO priority #2
        //webDriverWait.until(ExpectedConditions.visibilityOf(lastElementInDom)); // to check that the last element in DOM was loaded
    }

    public boolean isLastElementInDomAvaliable() {
        try {
            WebElement lastElementInDom = webDriver.findElement(lastElementInDomLocator);
            lastElementInDom.isDisplayed();
            return true;
        } catch (NoSuchElementException noSuchElementException) {
            return false;
        }

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
/*    public MainPage openPage() {
        webDriver.get("https://qa-scooter.praktikum-services.ru/");
        return this;
    }*/

    //TODO priority #3

    // doing inside some action which will open the website to test: for example: .get();
    // substitutes MainPage openPage() method
    @Override
    protected void load() {
        webDriver.get("https://qa-scooter.praktikum-services.ru/");
    }

    // verifyin that the page is opened. Returns Error instead of Expetion. Therefore can not use typical webDriverWait.until - while will response with Exception and method will think that page is loaded.
    // if Error - will try to load new. best practice to add Assert
    @Override
    protected void isLoaded() throws Error {
        Assert.assertTrue(isLastElementInDomAvaliable());
        /* or */
//        String currentUrl = webDriver.getCurrentUrl();
//        Assert.assertTrue(currentUrl.contains("qa-scooter"));
    }
}
