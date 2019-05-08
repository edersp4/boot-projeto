package application.service;

import org.apache.commons.io.FileUtils;

import java.io.File;

public class JavaService {
    public static final String JAVA_PATH = "\\\\sp7266sr600\\PUBLICA\\CEDESSP334\\Boot\\Java\\jdk1.8.0_144";

    public void executar(){

        try {
            FileUtils.copyDirectory(new File(JAVA_PATH) , new File(CopiarFerramentaService.DIRETORIO_ROOT + File.separator + "jdk1.8.0_144"));

        }catch (Exception e){

        }

    }
}
