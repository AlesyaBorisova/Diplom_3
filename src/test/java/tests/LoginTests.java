package tests;

import drivers.FactoryDriver;
import model.User;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.RecoveryPasswordPage;
import pages.RegisterPage;
import utils.UserGenerator;


import static org.junit.Assert.assertTrue;

public class LoginTests {

    @Rule
    public FactoryDriver factory = new FactoryDriver();

    private User user;

    @Before
    public void setUpUser() {
        user = UserGenerator.randomUser();

        MainPage mainPage = new MainPage(factory.getDriver());
        mainPage.openPage();

        mainPage.clickPersonalAccountButton();

        LoginPage loginPage = new LoginPage(factory.getDriver());
        loginPage.waitForUrlContains("login");

        loginPage.clickRegisterButton();

        RegisterPage registerPage = new RegisterPage(factory.getDriver());
        registerPage.waitForUrlContains("register");

        registerPage.register(user.getName(), user.getEmail(), user.getPassword());

        registerPage.waitForUrlContains("login");

    }

    @Test
    public void testLoginButtonOnMainPage() {
        MainPage mainPage = new MainPage(factory.getDriver());
        mainPage.openPage();
        mainPage.clickLoginButton();

        LoginPage loginPage = new LoginPage(factory.getDriver());

        loginPage.login(user.getEmail(), user.getPassword());

        assertTrue(mainPage.isMainPageOpened());


    }

    @Test
    public void testLoginPersonalAccountButton() {
        MainPage mainPage = new MainPage(factory.getDriver());
        mainPage.openPage();
        mainPage.clickPersonalAccountButton();

        LoginPage loginPage = new LoginPage(factory.getDriver());
        loginPage.waitForUrlContains("login");

        loginPage.login(user.getEmail(), user.getPassword());

        assertTrue(mainPage.isMainPageOpened());
    }

    @Test
    public void testLoginWithinRegistrationForm() {
        MainPage mainPage = new MainPage(factory.getDriver());
        mainPage.openPage();

        mainPage.clickPersonalAccountButton();

        LoginPage loginPage = new LoginPage(factory.getDriver());
        loginPage.waitForUrlContains("login");

        loginPage.clickRegisterButton();

        RegisterPage registerPage = new RegisterPage(factory.getDriver());
        registerPage.waitForUrlContains("register");

        registerPage.clickLoginButton();

        loginPage.waitForUrlContains("login");

        loginPage.login(user.getEmail(), user.getPassword());

        assertTrue(mainPage.isMainPageOpened());

    }

    @Test
    public void testLoginPasswordRecoveryButton() {
        MainPage mainPage = new MainPage(factory.getDriver());
        mainPage.openPage();
        mainPage.clickLoginButton();

        LoginPage loginPage = new LoginPage(factory.getDriver());
        loginPage.waitForUrlContains("login");

        loginPage.clickPasswordRecoveryButton();

        RecoveryPasswordPage recovery = new RecoveryPasswordPage(factory.getDriver());
        recovery.clickLoginButton();

        loginPage.waitForUrlContains("login");

        loginPage.login(user.getEmail(), user.getPassword());

        assertTrue(mainPage.isMainPageOpened());
    }

}
