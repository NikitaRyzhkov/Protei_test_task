package positive;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.FormPage;

import java.util.ArrayList;

import static com.codeborne.selenide.Condition.visible;

public class FormTest extends positive.LogInTest {

    @Description("Отправляет минимальный набор данных для отправки записи. Ожидание - сообщение о создании записи")
    @Test
    public void validFillMsg(){
        FormPage formPage = new FormPage();
        formPage.setEmail("test@test.com");
        formPage.setName("name");
        formPage.clickAddBtn();
        formPage.dataAddedMsg.shouldBe(visible);
    }
    @Description("Отправляет набор с максимальным количеством заполненных полей. Ожидание - заполненные поля в таблице")
    @Test
    public void validFillData(){

        ArrayList<String> form = new ArrayList<>();
        form.add("test@test.com");
        form.add("Test name");
        form.add("Женский");
        form.add("1.1, 1.2");
        form.add("2.1");

        FormPage formPage = new FormPage();
        formPage.setEmail(form.get(0));
        formPage.setName(form.get(1));
        formPage.clickFemaleOption();
        formPage.checkVariant11();
        formPage.checkVariant12();
        formPage.checkSelect21();
        formPage.clickAddBtn();
        formPage.clickOkBtn();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(formPage.tableCells.texts().containsAll(form));
        softAssert.assertAll();


    }
    @Description("Проверка соответствия фактического количества созданных строк заданному")
    @Test
    public void rowsNumber(){
        FormPage formPage = new FormPage();
        int rows = 3;
        for (int i=0;i!=rows;i++){
            validFillData();
        }
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(formPage.tableRows.size(),rows);
        softAssert.assertAll();
    }

}
