package application.service;

import org.apache.commons.io.FileUtils;

import java.io.File;

public class Ferramenta {

    public static final String FERRAMENTA_PATH = "\\\\sp7266sr600\\PUBLICA\\CEDESSP334\\Boot\\Ferramentas";

    public void executar(){

        try {
            File ferramenta_path = new File(CopiarFerramentaService.DIRETORIO_ROOT + File.separator + "Ferramenta");

            if (!ferramenta_path.exists()) {
                ferramenta_path.mkdirs();
            }

            FileUtils.copyDirectory(new File(FERRAMENTA_PATH), ferramenta_path);

        }catch (Exception e){

        }

    }
}
