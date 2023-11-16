package negative;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import pages.FormPage;

import static com.codeborne.selenide.Condition.visible;

public class FormTest extends positive.LogInTest {
    @Description("Отправка формы с невалидным значением поля email. Ожидание - сообщение об ошибке")
    @Test
    public void wrongEmail(){
        FormPage formPage = new FormPage();
        formPage.setEmail("abc");
        formPage.setName("Random name");
        formPage.clickAddBtn();
        formPage.emailFormatMsg.shouldBe(visible);
    }
    @Description("Отправка формы с незаполненным полем name. Ожидание - сообщение об ошибке")
    @Test
    public void emptyName(){
        FormPage formPage = new FormPage();
        formPage.setEmail("test@test.com");
        formPage.clickAddBtn();
        formPage.emptyNameMsg.shouldBe(visible);
    }
    @Description("Проверка кнопки закрытия сообщения об ошибке")
    @Test
    public void closeMsg(){
        FormPage formPage = new FormPage();
        emptyName();
        formPage.clickCloseMsgBtn();
        formPage.emptyNameMsg.shouldNotBe(visible);
    }

}
