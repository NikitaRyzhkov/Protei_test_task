package positive;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Description;
import org.testng.annotations.*;
import pages.FormPage;
import pages.LogInPage;
import utils.User;

import java.io.IOException;

import static com.codeborne.selenide.Condition.visible;

public class LogInTest {

    @BeforeMethod
    public void login() throws IOException {
        LogInPage logInPage = new LogInPage();
        User user = new User();
        logInPage.setLogin(user.getLogin());
        logInPage.setPassword(user.getPassword());
        logInPage.clickLogInBtn();
    }
    @AfterMethod
    public void tearDrop(){
        Selenide.closeWindow();}
    @Description("Проверка открытия формы после успешной авторизации")
    @Test
    public void inputsAfterLogin(){
        FormPage formPage = new FormPage();
        formPage.emailField.shouldBe(visible);
        formPage.nameField.shouldBe(visible);
    }
}
