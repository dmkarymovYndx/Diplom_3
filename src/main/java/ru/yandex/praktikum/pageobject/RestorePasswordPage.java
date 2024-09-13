package ru.yandex.praktikum.pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RestorePasswordPage {

    private WebDriver driver;

    // Конструктор
    public RestorePasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    // Кнопка "Войти"
    private By loginButton = new By.ByXPath(".//a[@class='Auth_link__1fOlj' and @href='/login']");

    // Клик по кнопке "Войти"
    @Step
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

}
