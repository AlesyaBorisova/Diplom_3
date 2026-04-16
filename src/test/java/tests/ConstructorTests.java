package tests;

import drivers.FactoryDriver;
import org.junit.Rule;
import org.junit.Test;
import pages.MainPage;

import static org.junit.Assert.assertTrue;


public class ConstructorTests {

    @Rule
    public FactoryDriver factory = new FactoryDriver();

    @Test
    public void checkConstructorTabs() {
        MainPage page = new MainPage(factory.getDriver());
        page.openPage();

        page.navigateToFillings();
        assertTrue(page.isTabActive("Начинки"));

        page.navigateToSauces();
        assertTrue(page.isTabActive("Соусы"));

        page.navigateToBuns();
        assertTrue(page.isTabActive("Булки"));


    }
}
