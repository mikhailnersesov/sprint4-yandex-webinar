package ru.yandex.praktikum.loadable_component;

import org.junit.Assert;
import org.junit.Test;

public class OrderTest extends BaseTest {


    @Test
    public void orderNotFoundShouldBeVisiable() {
        MainPage mainPage = new MainPage(webDriver);
        // we exchange the mainPage.openPage() with mainPage.get() which will not only open, but verify too
        mainPage.get();
        mainPage.clickOrderStatusButton();
        mainPage.enterOrderNumber("1234");
        mainPage.clickGoButton();

        OrderPage orderPage = new OrderPage(webDriver);
        boolean notFoundImageDisplayed = orderPage.isNotFoundImageDisplyed();
        Assert.assertTrue(notFoundImageDisplayed);

    }


}
