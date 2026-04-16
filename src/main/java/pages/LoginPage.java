package pages;

import drivers.Base;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage extends Base {

    private final By registerButton = By.xpath("//a[text()='Зарегистрироваться']"); // Кнопка "Зарегистрироваться
    private final By inputEmail = By.xpath("//input[@type='text' or contains(@name,'email')]"); // Поле "Email"
    private final By inputPassword = By.xpath("//input[@type='password']"); // Поле "Пароль"
    private final By loginButton = By.xpath("//button[contains(text(),'Войти')]"); // Кнопка "Войти"
    private final By passwordRecoveryButton = By.xpath("//a[contains(text(),'Восстановить')]"); // Кнопка "Восстановить пароль"

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Ввод email")
    public void setEmail(String email) {
        type(inputEmail, email);
    }

    @Step("Ввод пароля")
    public void setPassword(String password) {
        type(inputPassword, password);
    }

    @Step("Клик по кнопке 'Зарегистрироваться'")
    public void clickRegisterButton() {
        click(registerButton);
    }

    @Step("Клик по кнопке 'Войти'")
    public void clickLoginButton() {
        click(loginButton);
    }

    @Step("Клик по кнопке 'Восстановить пароль'")
    public void clickPasswordRecoveryButton() {
        click(passwordRecoveryButton);
    }

    @Step("Логин пользователя {email}")
    public void login(String email, String password) {
        setEmail(email);
        setPassword(password);
        clickLoginButton();
    }

}
