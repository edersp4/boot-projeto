package application.service;

import application.service.base.BaseMockito;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import static org.junit.jupiter.api.Assertions.*;


class CopiarFerramentaServiceTest extends BaseMockito {

    @InjectMocks
    CopiarFerramentaService copiarFerramentaService;

    @Test
    void baixarTodosOsProjetosPeloGit() {
        copiarFerramentaService.baixarTodosOsProjetosPeloGit();

    }
}