package application.service;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertThat;

class ConfiguracaoTest {

    @DisplayName("Vericar se foi carregado")
    @Test
    void testeCarregarArquivo() {
        assertThat(Configuracao.caminhoLocal, CoreMatchers.notNullValue());
        assertThat(Configuracao.urlGit, CoreMatchers.notNullValue());
        assertThat(Configuracao.usuarioGit, CoreMatchers.notNullValue());
        assertThat(Configuracao.projetos, CoreMatchers.notNullValue());
        assertThat(Configuracao.senhaGit, CoreMatchers.notNullValue());

    }
}