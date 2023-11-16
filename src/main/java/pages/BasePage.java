package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;

public class BasePage {
    /**
     * Задает неявное ожидание перед нажатием
     */
    protected void waitAndClick(SelenideElement element){
        element.shouldBe(visible);
        element.click();
    }
    /**
     * Задает неявное ожидание перед вводом значения
     */
    protected void waitAndSet(SelenideElement element, String value){
        element.shouldBe(visible);
        element.setValue(value);
    }

}
