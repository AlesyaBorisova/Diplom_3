package base;


import io.restassured.RestAssured;
import org.junit.Before;
import org.openqa.selenium.WebDriver;


public class BaseTest {

    protected WebDriver driver;

    @Before
    public void setUp() {
        RestAssured.baseURI = "https://stellarburgers.education-services.ru";

    }
}