package ru.yandex.praktikum.page_object;

import org.junit.Assert;
import org.junit.Test;

public class OrderTest extends BaseTest{


    @Test
    public void orderNotFoundShouldBeVisiable() {
        MainPage mainPage = new MainPage(webDriver);
        mainPage.openPage();
        mainPage.clickOrderStatusButton();
        mainPage.enterOrderNumber("1234");
        mainPage.clickGoButton();

        OrderPage orderPage = new OrderPage(webDriver);
        boolean notFoundImageDisplayed = orderPage.isNotFoundImageDisplyed();
        Assert.assertTrue(notFoundImageDisplayed);

    }


}
