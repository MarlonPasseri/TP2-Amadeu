package br.com.exemplo.crud.web.tests;

import br.com.exemplo.crud.web.base.BaseWebTest;
import br.com.exemplo.crud.web.pages.ClienteFormPage;
import br.com.exemplo.crud.web.pages.ClientesListaPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ClientesCrudTest extends BaseWebTest {

    @Test
    void deveCadastrarClienteComSucesso() {
        ClientesListaPage listaPage = new ClientesListaPage(driver);
        listaPage.abrir(baseUrl);

        int qtdAntes = listaPage.contarLinhas();

        listaPage.clicarNovoCliente();

        ClienteFormPage formPage = new ClienteFormPage(driver);
        formPage.preencherNome("João da Silva");
        formPage.preencherEmail("joao.silva@example.com");
        formPage.salvar();

        assertTrue(listaPage.possuiMensagemSucesso());
        assertEquals(qtdAntes + 1, listaPage.contarLinhas());
    }

    @Test
    void deveEditarClienteComSucesso() {
        ClientesListaPage listaPage = new ClientesListaPage(driver);
        listaPage.abrir(baseUrl);

        if (listaPage.contarLinhas() == 0) {
            listaPage.clicarNovoCliente();
            ClienteFormPage formPage = new ClienteFormPage(driver);
            formPage.preencherNome("Cliente Inicial");
            formPage.preencherEmail("cliente.inicial@example.com");
            formPage.salvar();
            assertTrue(listaPage.possuiMensagemSucesso());
        }

        listaPage.clicarEditarPrimeiro();
        ClienteFormPage formPage = new ClienteFormPage(driver);
        formPage.preencherNome("Cliente Editado");
        formPage.preencherEmail("cliente.editado@example.com");
        formPage.salvar();

        assertTrue(listaPage.possuiMensagemSucesso());
    }

    @Test
    void deveExcluirClienteComSucesso() {
        ClientesListaPage listaPage = new ClientesListaPage(driver);
        listaPage.abrir(baseUrl);

        if (listaPage.contarLinhas() == 0) {
            listaPage.clicarNovoCliente();
            ClienteFormPage formPage = new ClienteFormPage(driver);
            formPage.preencherNome("Cliente a Excluir");
            formPage.preencherEmail("cliente.excluir@example.com");
            formPage.salvar();
            assertTrue(listaPage.possuiMensagemSucesso());
        }

        int qtdAntes = listaPage.contarLinhas();
        listaPage.clicarExcluirPrimeiro();

        assertTrue(listaPage.possuiMensagemSucesso());
        assertEquals(qtdAntes - 1, listaPage.contarLinhas());
    }
}
