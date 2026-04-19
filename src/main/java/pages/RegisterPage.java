package pages;

import drivers.Base;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends Base {

    private final By inputName = By.xpath("//label[contains(text(), 'Имя')]/following-sibling::input"); // Поле "Имя"
    private final By inputEmail = By.xpath("//label[contains(text(), 'Email')]/following-sibling::input");// Поле "Email"
    private final By inputPassword = By.xpath("//input[@type='password']");// Поле "Пароль"
    private final By loginButton = By.className("Auth_link__1fOlj"); // Кнопка "Войти"
    private final By registerButton = By.xpath("//button[contains(text(),'Зарегистрироваться')]"); // Кнопка "Зарегистрироваться"
    private final By errorText = By.className("input__error"); // Ошибка при неправильном пароле


    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    @Step("Ввод имени")
    public void setName(String name) {
        type(inputName, name);
    }

    @Step("Ввод email")
    public void setEmail(String email) {
        type(inputEmail, email);
    }

    @Step("Ввод пароля")
    public void setPassword(String password) {
        type(inputPassword, password);
    }

    @Step("Нажать кнопку 'Зарегистрироваться'")
    public void clickRegisterButton() {
        click(registerButton);
    }

    @Step("Получить текст ошибки")
    public String getErrorText() {
        waitForElementVisible(errorText);
        return driver.findElement(errorText).getText();
    }


    @Step("Нажать на кнопку 'Войти'")
    public void clickLoginButton() {
        click(loginButton);
    }

    @Step("Регистрация пользователя {email}")
    public void register(String name, String email, String password){
        setName(name);
        setEmail(email);
        setPassword(password);
        clickRegisterButton();
    }
}
