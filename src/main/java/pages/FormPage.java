package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FormPage extends BasePage {
    public final SelenideElement emailField = $("input#dataEmail"),
                                 nameField = $("input#dataName"),
                                 dataAddedMsg = $(byText("Данные добавлены.")),
                                 emailFormatMsg = $(byText("Неверный формат E-Mail")),
                                 emptyNameMsg = $(byText("Поле имя не может быть пустым"));
    public final ElementsCollection  tableCells = $$x("//td"),
                                     tableRows = $$x("//tbody/tr");
    private final SelenideElement variant11 = $("input#dataCheck11"),
                                  variant12 = $("input#dataCheck12"),
                                  select21 = $("input#dataSelect21"),
                                  select22 = $("input#dataSelect22"),
                                  select23 = $("input#dataSelect23"),
                                  addBtn = $("button#dataSend"),
                                  okBtn = $(byText("Ok")),
                                  closeMsgBtn = $(".uk-close"),
                                  genderSelect = $("select#dataGender"),
                                  maleOption = $x("//option[normalize-space(.)='Мужской']"),
                                  femaleOption = $x("//option[normalize-space(.)='Женский']");

    private void clickGenderSelect(){ waitAndClick(genderSelect); }
    public void clickMaleOption(){
        clickGenderSelect();
        waitAndClick(maleOption);
    }
    public void clickFemaleOption(){
        clickGenderSelect();
        waitAndClick(femaleOption);
    }
    public void clickCloseMsgBtn(){ waitAndClick(closeMsgBtn); }
    public void clickAddBtn(){
        waitAndClick(addBtn);
    }
    public void clickOkBtn(){ waitAndClick(okBtn);}
    public void checkVariant11(){
        waitAndClick(variant11);
    }
    public void checkVariant12(){
        waitAndClick(variant12);
    }
    public void checkSelect21(){
        waitAndClick(select21);
    }
    public void checkSelect22(){
        waitAndClick(select22);
    }
    public void checkSelect23(){
        waitAndClick(select23);
    }
    public void setEmail(String email){
        waitAndSet(emailField,email);
    }
    public void setName(String name){
        waitAndSet(nameField,name);
    }
}
