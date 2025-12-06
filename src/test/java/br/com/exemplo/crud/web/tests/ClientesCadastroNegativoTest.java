package br.com.exemplo.crud.web.tests;

import br.com.exemplo.crud.web.base.BaseWebTest;
import br.com.exemplo.crud.web.pages.ClienteFormPage;
import br.com.exemplo.crud.web.pages.ClientesListaPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ClientesCadastroNegativoTest extends BaseWebTest {

    @Test
    void naoDeveCadastrarClienteComEmailInvalido() {
        ClientesListaPage listaPage = new ClientesListaPage(driver);
        listaPage.abrir(baseUrl);

        listaPage.clicarNovoCliente();
        ClienteFormPage formPage = new ClienteFormPage(driver);

        formPage.preencherNome("Teste Email Inválido");
        formPage.preencherEmail("email-invalido");
        formPage.salvar();

        assertTrue(formPage.possuiErrosValidacao());
    }
}
