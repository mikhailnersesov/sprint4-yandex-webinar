package ru.yandex.praktikum.page_component;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.yandex.praktikum.page_component.components.FaqComponent;
import ru.yandex.praktikum.page_object.OrderPage;

@RunWith(Parameterized.class)
public class FaqTest extends BaseTest {

    @Parameterized.Parameter
    public int index;

    @Parameterized.Parameter(1)
    public String expectedQuestion;

    @Parameterized.Parameter(2)
    public String expectedAnswer;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {0,"Сколько это стоит? И как оплатить?","Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {1,"Хочу сразу несколько самокатов! Так можно?","Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."}

        };
    }

    @Test
    public void faqTest() {
        MainPage mainPage = new MainPage(webDriver);
        mainPage.openPage();
        //FaqComponent has overall ID in MainPage and then splitts into compoenents inside itself
        // we can separate several parts. so that language and logic is more readable (not MainPage Question, while can be many, but FaqBlock question)
        FaqComponent faqComponent = mainPage.getFaqComponent(index);
        faqComponent.open();
        Assert.assertEquals(expectedQuestion,faqComponent.getQuestion());
        Assert.assertEquals(expectedAnswer,faqComponent.getAnswer());
    }


}
