package drivers;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Base {

    private final By modalOverlay = By.className("Modal_modal_overlay__x2ZCr"); // Модальный оверлей

    public final WebDriver driver;
    private final WebDriverWait wait;

    public Base(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Step("Открытие главной страницы")
    public void openPage() {

        driver.get("https://stellarburgers.education-services.ru/");
    }

    @Step("Ожидание видимости элемента")
    public WebElement waitForElementVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

    }

    @Step("Клик по элементу")
    public void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();

    }

    @Step("Ввод текста")
    public void type(By locator, String text) {
        WebElement element = waitForElementVisible(locator);
        element.clear();
        element.sendKeys(text);

    }

    @Step("Ожидание URL")
    public void waitForUrlContains(String part) {

        wait.until(ExpectedConditions.urlContains(part));
    }


    @Step("Стабильный клик")
    public void safeClick(By locator) {

        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    @Step("Ожидание исчезновения модального оверлея")
    public void waitForOverlayToDisappear(WebDriver driver) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.invisibilityOfElementLocated(modalOverlay));
    }

}

