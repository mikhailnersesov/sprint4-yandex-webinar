package ru.yandex.praktikum.page_component.components;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FaqComponent extends BaseComponent {
    private final By question = By.xpath(".//div[contains(@id,'accordion__heading')]");
    private final By answer = By.xpath(".//div[contains(@id,'accordion__panel')]/p");

    public FaqComponent(WebElement root, WebDriver webDriver) {
        super(root, webDriver);
    }

    public String getQuestion() {
        // findElement is not from webDriver, but from root
        return root.findElement(question).getText();
    }

    public String getAnswer() {
        return root.findElement(answer).getText();
    }

    public void open() {
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, 10);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(this.question));
        WebElement questionElement = root.findElement(question);
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", questionElement);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(questionElement));
        questionElement.click();
    }
}
