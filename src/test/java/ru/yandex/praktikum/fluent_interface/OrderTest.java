package ru.yandex.praktikum.fluent_interface;

import org.junit.Assert;
import org.junit.Test;
import ru.yandex.praktikum.page_object.MainPage;

public class OrderTest extends BaseTest {


    @Test
    public void orderNotFoundShouldBeVisiable() {
        boolean notFoundImageDisplayed = new MainPage(webDriver)
                .openPage()
                .clickOrderStatusButton()
                .enterOrderNumber("1234")
                .clickGoButton()
                .isNotFoundImageDisplyed();
        Assert.assertTrue(notFoundImageDisplayed);
    }


}
