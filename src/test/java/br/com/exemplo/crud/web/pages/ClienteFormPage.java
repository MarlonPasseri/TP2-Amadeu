package br.com.exemplo.crud.web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ClienteFormPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By campoNome = By.id("nome");
    private final By campoEmail = By.id("email");
    private final By btnSalvar = By.id("btnSalvar");
    private final By msgErro = By.cssSelector(".invalid-feedback");

    public ClienteFormPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void preencherNome(String nome) {
        WebElement inputNome = wait.until(
                ExpectedConditions.visibilityOfElementLocated(campoNome)
        );
        inputNome.clear();
        inputNome.sendKeys(nome);
    }

    public void preencherEmail(String email) {
        WebElement inputEmail = wait.until(
                ExpectedConditions.visibilityOfElementLocated(campoEmail)
        );
        inputEmail.clear();
        inputEmail.sendKeys(email);
    }

    public void salvar() {
        WebElement botaoSalvar = wait.until(
                ExpectedConditions.elementToBeClickable(btnSalvar)
        );
        botaoSalvar.click();
    }

    public boolean possuiErrosValidacao() {
        return !driver.findElements(msgErro).isEmpty();
    }
}
