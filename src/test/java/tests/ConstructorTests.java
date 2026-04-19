package tests;

import drivers.FactoryDriver;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Rule;
import org.junit.Test;
import pages.MainPage;

import static org.junit.Assert.assertTrue;


public class ConstructorTests {

    @Rule
    public FactoryDriver factory = new FactoryDriver();

    @Test
    @DisplayName("Проверка вкладки Начинки")
    @Description("Проверяет переключение на вкладку Начинки")
    public void shouldOpenFillingsTabs() {
        MainPage page = new MainPage(factory.getDriver());
        page.openPage();

        page.navigateToFillings();
        assertTrue(page.isTabActive("Начинки"));
    }

    @Test
    @DisplayName("Проверка вкладки Соусы")
    @Description("Проверяет переключение на вкладку Соусы")
    public void shouldOpenSaucesTabs() {
        MainPage page = new MainPage(factory.getDriver());
        page.openPage();

        page.navigateToSauces();
        assertTrue(page.isTabActive("Соусы"));
    }

    @Test
    @DisplayName("Проверка вкладки Булки")
    @Description("Проверяет переключение на вкладку Булки")
    public void shouldOpenBunsTabs() {
        MainPage page = new MainPage(factory.getDriver());
        page.openPage();

        page.navigateToSauces();
        page.navigateToBuns();
        assertTrue(page.isTabActive("Булки"));


    }
}
