package ru.yandex.praktikum.page_component.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class BaseComponent {
    protected final WebElement root; // parent element
    protected final WebDriver webDriver;

    public BaseComponent(WebElement root, WebDriver webDriver) {
        this.root = root;
        this.webDriver = webDriver;
    }
}
