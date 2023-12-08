package ru.yandex.praktikum.page_factory;

import org.junit.Assert;
import org.junit.Test;
import ru.yandex.praktikum.page_factory.MainPage;
import ru.yandex.praktikum.page_factory.OrderPage;

public class OrderTest extends BaseTest {


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
