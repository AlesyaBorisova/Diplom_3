package drivers;

import org.junit.rules.ExternalResource;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import java.time.Duration;

public class FactoryDriver extends ExternalResource {

    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }


    @Override
    protected void before() {
        initDriver();
        driver.manage().window().maximize();

    }

    @Override
    protected void after() {
        driver.quit();
    }

    public void initDriver() {
        String browser = System.getProperty("browser", "chrome");

        if ("yandex".equals(browser)) {
            startYandex();
        } else {
            startChrome();

        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    private void startYandex() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:/Program Files/Yandex/YandexBrowser/Application/browser.exe");
        driver = new ChromeDriver(options);

    }

    private void startChrome() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

    }
}
