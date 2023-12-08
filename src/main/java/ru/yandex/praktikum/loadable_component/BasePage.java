package ru.yandex.praktikum.loadable_component;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.SlowLoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Clock;

public abstract class BasePage extends SlowLoadableComponent {
    protected final WebDriver webDriver;
    protected final WebDriverWait webDriverWait;
    protected BasePage(WebDriver webDriver) {
        super(Clock.systemUTC(),10); // to wait for 10 seconds
        this.webDriver = webDriver;
        this.webDriverWait = new WebDriverWait(webDriver, 3);
    }

}
