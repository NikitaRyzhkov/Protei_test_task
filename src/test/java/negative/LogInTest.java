package negative;

import org.testng.annotations.Test;
import pages.FormPage;
import pages.LogInPage;
import utils.User;

import java.io.IOException;

import static com.codeborne.selenide.Condition.visible;

public class LogInTest extends BaseTest {

    @Test
    public void wrongEmailFormat(){
        LogInPage logInPage = new LogInPage();
        FormPage formPage = new FormPage();

        logInPage.setLogin("abc");
        logInPage.setPassword("");
        logInPage.clickLogInBtn();
        logInPage.emailFormatMsg.shouldBe(visible);
        formPage.nameField.shouldNotBe(visible);
    }
    @Test
    public void wrongPasswd() throws IOException {
        LogInPage logInPage = new LogInPage();
        FormPage formPage = new FormPage();
        User user = new User();

        logInPage.setLogin(user.getLogin());
        logInPage.setPassword("");
        logInPage.clickLogInBtn();
        logInPage.wrongEmailPasswdMsg.shouldBe(visible);
        formPage.emailField.shouldNotBe(visible);
    }
    @Test
    public void closeMsg(){
        LogInPage logInPage = new LogInPage();

        logInPage.setLogin("");
        logInPage.setPassword("");
        logInPage.clickLogInBtn();
        logInPage.clickCloseMsgBtn();
        logInPage.emailFormatMsg.shouldNotBe(visible);

    }
}
