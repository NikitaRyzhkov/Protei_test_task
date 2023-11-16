package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LogInPage extends BasePage {

    public final String PATH = "C:/Users/Admin/IdeaProjects/Protei_test_task/src/test_data/qa-test.html";
    public LogInPage(){open(PATH);}
    private final SelenideElement loginField = $("input#loginEmail"),
                                  passwordField = $("input#loginPassword"),
                                  logInBtn =$("button#authButton"),
                                  closeMsgBtn = $("a.uk-close");
    public final SelenideElement emailFormatMsg = $(byText("Неверный формат E-Mail")),
                                 wrongEmailPasswdMsg = $(byText("Неверный E-Mail или пароль"));
    @Step
    public void setLogin(String login){
        waitAndSet(loginField, login);
    }
    @Step
    public void setPassword(String password){
        waitAndSet(passwordField, password);
    }
    @Step
    public void clickLogInBtn(){
        waitAndClick(logInBtn);
    }
    public void clickCloseMsgBtn(){
        waitAndClick(closeMsgBtn);
    }

}
