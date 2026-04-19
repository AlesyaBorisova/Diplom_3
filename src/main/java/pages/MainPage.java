package pages;

import drivers.Base;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class MainPage extends Base {


    private final By personalAccountButton = By.xpath("//p[text()='Личный Кабинет']"); // Кнопка "Личный кабинет"
    private final By loginButton = By.xpath("//button[contains(text(),'Войти')]"); // Кнопка "Войти в аккаунт"
    private final By saucesTab = By.xpath("//span[text()='Соусы']/ancestor::div[contains(@class,'tab_tab')]"); //  Переход на вкладку "Соусы"
    private final By bunsTab = By.xpath("//span[text()='Булки']/ancestor::div[contains(@class,'tab_tab')]"); //  Переход на вкладку "Булки"
    private final By fillingsTab = By.xpath("//span[text()='Начинки']/ancestor::div[contains(@class,'tab_tab')]");  // Переход на вкладку "Начинки"
    private final By mainTitle = By.xpath("//h1[text()='Соберите бургер']"); // Элемент "Соберите бургер" на главной странице

    public MainPage(WebDriver driver) {
        super(driver);

    }


    @Step("Нажать на кнопку 'Личный кабинет'")
    public void clickPersonalAccountButton() {

        click(personalAccountButton);
    }


    @Step("Нажимаем на кнопку 'Войти в аккаунт'")
    public void clickLoginButton() {

        click(loginButton);
    }


    @Step("Открыть 'Соусы'")
    public void navigateToSauces() {
        waitForOverlayToDisappear(driver);
        safeClick(saucesTab);

    }

    @Step("Открыть 'Начинки'")
    public void navigateToFillings() {
        waitForOverlayToDisappear(driver);
        safeClick(fillingsTab);
    }

    @Step("Открыть 'Булки'")
    public void navigateToBuns() {
         click(bunsTab);
    }


    @Step("Проверка активности вкладки")
    public boolean isTabActive(String tabName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'tab_tab_type_current')]//span[text()='" + tabName + "']")))
                .isDisplayed();
    }

    @Step("Проверка отображения главной страницы конструктора")
    public boolean isMainPageOpened() {
        return waitForElementVisible(mainTitle).isDisplayed();
    }

}
