package br.com.exemplo.crud.web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ClientesListaPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By btnNovoCliente = By.id("btnNovoCliente");
    private final By tabelaClientes = By.id("tabelaClientes");
    private final By linhasTabela = By.cssSelector("#tabelaClientes tbody tr");
    private final By msgSucesso = By.id("msgSucesso");

    public ClientesListaPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void abrir(String baseUrl) {
        driver.get(baseUrl + "/clientes");
        wait.until(ExpectedConditions.visibilityOfElementLocated(tabelaClientes));
    }

    public void clicarNovoCliente() {
        wait.until(ExpectedConditions.elementToBeClickable(btnNovoCliente)).click();
    }

    public int contarLinhas() {
        List<WebElement> linhas = driver.findElements(linhasTabela);
        return linhas.size();
    }

    public boolean possuiMensagemSucesso() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(msgSucesso));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public void clicarEditarPrimeiro() {
        List<WebElement> linhas = driver.findElements(linhasTabela);
        if (linhas.isEmpty()) {
            throw new IllegalStateException("Não há clientes na tabela para editar.");
        }
        WebElement primeiraLinha = linhas.get(0);
        primeiraLinha.findElement(By.cssSelector(".btnEditar")).click();
    }

    public void clicarExcluirPrimeiro() {
        List<WebElement> linhas = driver.findElements(linhasTabela);
        if (linhas.isEmpty()) {
            throw new IllegalStateException("Não há clientes na tabela para excluir.");
        }
        WebElement primeiraLinha = linhas.get(0);
        primeiraLinha.findElement(By.cssSelector(".btnExcluir")).click();
        driver.switchTo().alert().accept();
    }
}
