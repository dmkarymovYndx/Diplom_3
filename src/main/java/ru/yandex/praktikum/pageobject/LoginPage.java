package ru.yandex.praktikum.pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    // Конструктор
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Заголовок "Вход"
    private By pageTitle = new By.ByXPath(".//div[@class='Auth_login__3hAey']/h2");

    // Поле "Email"
    private By emailField = new By.ByXPath(".//input[@name='name']");

    // Поле "Пароль"
    private By passwordField = new By.ByXPath(".//input[@name='Пароль']");

    // Кнопка "Войти"
    private By enterButton = new By.ByXPath(".//button[text()='Войти']");

    // Кнопка "Зарегистрироваться"
    private By registerButton = new By.ByXPath(".//a[@href='/register']");

    // Кнопка "Восстановить пароль"
    private By forgotPasswordButton = new By.ByXPath(".//a[text()='Восстановить пароль']");

    // Заполнение поля "Email"
    @Step
    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    // Заполнение поля "Пароль"
    @Step
    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    // Клик по кнопке "Войти"
    @Step
    public void clickEnterButton() {
        driver.findElement(enterButton).click();
    }

    // Заполнение формы логина целиком и вход
    @Step
    public void fillLoginFormAndEnter(String email, String password) {
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(enterButton).click();
    }

    // Клик по кнопке "Зарегистрироваться"
    @Step
    public void clickRegisterButton() {
        driver.findElement(registerButton).click();
    }

    // Клик по кнопке "Восстановить пароль"
    @Step
    public void clickForgotPasswordButton() {
        driver.findElement(forgotPasswordButton).click();
    }

    // Проверка того, что на странице есть заголовок "Вход"
    public boolean isPageTitlePresent() {
        return !driver.findElements(pageTitle).isEmpty();
    }

}
