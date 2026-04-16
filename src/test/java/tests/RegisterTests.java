package tests;

import drivers.FactoryDriver;
import model.User;
import org.junit.Rule;
import org.junit.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.RegisterPage;
import utils.UserGenerator;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RegisterTests {

    @Rule
    public FactoryDriver factory = new FactoryDriver();

    @Test
    public void successRegisterTest() {
        MainPage mainPage = new MainPage(factory.getDriver());
        mainPage.openPage();

        mainPage.clickPersonalAccountButton();

        LoginPage loginPage = new LoginPage(factory.getDriver());
        loginPage.waitForUrlContains("login");

        loginPage.clickRegisterButton();

        RegisterPage registerPage = new RegisterPage(factory.getDriver());
        registerPage.waitForUrlContains("register");

        User user = UserGenerator.randomUser();

        registerPage.register(user.getName(), user.getEmail(), user.getPassword());

        registerPage.waitForUrlContains("login");

        assertTrue(factory.getDriver().getCurrentUrl().contains("login"));
    }

    @Test
    public void errorIncorrectPassword() {
        MainPage mainPage = new MainPage(factory.getDriver());
        mainPage.openPage();

        mainPage.clickPersonalAccountButton();

        LoginPage loginPage = new LoginPage(factory.getDriver());
        loginPage.waitForUrlContains("login");

        loginPage.clickRegisterButton();

        RegisterPage registerPage = new RegisterPage(factory.getDriver());
        registerPage.waitForUrlContains("register");

        User user = UserGenerator.randomUser();

        registerPage.setName(user.getName());
        registerPage.setEmail(user.getEmail());
        registerPage.setPassword("123");
        registerPage.clickRegisterButton();

        assertEquals("Некорректный пароль", registerPage.getErrorText());


    }
}
