package pages;

import drivers.Base;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class RecoveryPasswordPage extends Base {

    private final By loginButton = By.className("Auth_link__1fOlj"); // Кнопка "Войти"

    public RecoveryPasswordPage(WebDriver driver) {

        super(driver);
    }

    @Step("Клик по кнопке 'Войти'")
    public void clickLoginButton() {
        click(loginButton);
    }


}
