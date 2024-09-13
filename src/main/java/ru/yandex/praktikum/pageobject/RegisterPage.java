package ru.yandex.praktikum.pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class RegisterPage {

    private WebDriver driver;

    // Конструктор
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    // Поле "Имя"
    private By nameField = new By.ByXPath(".//form[@class='Auth_form__3qKeq mb-20']/fieldset[1]/div/div/input");

    // Поле "Email"
    private By emailField = new By.ByXPath(".//form[@class='Auth_form__3qKeq mb-20']/fieldset[2]/div/div/input");

    // Поле "Пароль"
    private By passwordField = new By.ByXPath(".//input[@name='Пароль']");

    // Сообщение "Некорректный пароль"
    private By incorrectPasswordMessage = new By.ByXPath(".//p[text()='Некорректный пароль']");

    // Кнопка "Зарегистрироваться"
    private By registerButton = new By.ByXPath(".//button[text()='Зарегистрироваться']");

    // Кнопка "Войти"
    private By loginButton = new By.ByXPath(".//a[@href='/login']");

    // Заполнение поля "Имя"
    @Step
    public void enterName(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

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

    // Снятие выделения с поля "Пароль" нажатием Tab
    @Step
    public void pressTabInPasswordField() {
        driver.findElement(passwordField).sendKeys(Keys.TAB);
    }

    // Клик по кнопке "Зарегистрироваться"
    @Step
    public void clickRegisterButton() {
        driver.findElement(registerButton).click();
    }

    // Клик по кнопке "Войти"
    @Step
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    // Заполнение формы регистрации целиком и вход
    @Step
    public void fillRegisterFormAndEnter(String email, String password, String name) {
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(registerButton).click();
    }

    // Проверка, есть ли на странице сообщение о некорректном пароле
    public boolean isIncorrectPasswordMessagePresent() {
        return !driver.findElements(incorrectPasswordMessage).isEmpty();
    }

    // Проверка, видно ли сообщение о некорректном пароле
    public boolean isIncorrectPasswordMessageDisplayed() {
        return isIncorrectPasswordMessagePresent() ? driver.findElement(incorrectPasswordMessage).isDisplayed() : isIncorrectPasswordMessagePresent();
    }

}
