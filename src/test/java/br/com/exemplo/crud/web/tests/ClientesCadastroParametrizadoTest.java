package br.com.exemplo.crud.web.tests;

import br.com.exemplo.crud.web.base.BaseWebTest;
import br.com.exemplo.crud.web.pages.ClienteFormPage;
import br.com.exemplo.crud.web.pages.ClientesListaPage;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ClientesCadastroParametrizadoTest extends BaseWebTest {

    @ParameterizedTest
    @CsvSource({
            "Maria, maria@example.com",
            "José, jose@example.com",
            "Ana, ana@example.com"
    })
    void deveCadastrarVariosClientes(String nome, String email) {
        ClientesListaPage listaPage = new ClientesListaPage(driver);
        listaPage.abrir(baseUrl);

        int qtdAntes = listaPage.contarLinhas();

        listaPage.clicarNovoCliente();
        ClienteFormPage formPage = new ClienteFormPage(driver);

        formPage.preencherNome(nome);
        formPage.preencherEmail(email);
        formPage.salvar();

        assertTrue(listaPage.possuiMensagemSucesso());
        assertEquals(qtdAntes + 1, listaPage.contarLinhas());
    }
}
