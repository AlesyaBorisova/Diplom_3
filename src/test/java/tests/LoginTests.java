package tests;

import base.BaseTest;
import drivers.FactoryDriver;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import model.User;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.RecoveryPasswordPage;
import pages.RegisterPage;
import services.UserClient;
import utils.UserGenerator;


import static org.junit.Assert.assertTrue;

public class LoginTests extends BaseTest {

    @Rule
    public FactoryDriver factory = new FactoryDriver();

    private User user;
    private UserClient userClient;

    @Before
    public void setUpUser() {
        user = UserGenerator.randomUser();
        userClient = new UserClient();

        userClient.createUser(user);
    }


    @Test
    @DisplayName("Логин через кнопку на главной странице")
    @Description("Проверяет вход пользователя через кнопку'Войти' на главной странице")
    public void testLoginButtonOnMainPage() {
        MainPage mainPage = new MainPage(factory.getDriver());
        mainPage.openPage();
        mainPage.clickLoginButton();

        LoginPage loginPage = new LoginPage(factory.getDriver());

        loginPage.login(user.getEmail(), user.getPassword());

        assertTrue(mainPage.isMainPageOpened());


    }

    @Test
    @DisplayName("Логин через кнопку 'Личный кабинет'")
    @Description("Проверяет вход пользователя через кнопку 'Личный кабинет'")
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
    @DisplayName("Логин через форму регистрации")
    @Description("Проверяет вход пользователя через форму регистрации")
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
    @DisplayName("Логин через форму восстановления пароля")
    @Description("Проверяет вход пользователя после перехода через восстановление пароля")
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
