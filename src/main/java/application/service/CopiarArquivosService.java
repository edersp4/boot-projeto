package application.service;

import javax.swing.*;
import java.io.File;

public class CopiarArquivosService {

    public static final String DIRETORIO_ROOT = "C:" + File.separator + "DesenvolvimentoAux";

    public void processar(boolean java, boolean ferramenta) {

    Runnable iniciar = () -> {

            File tools = new File(DIRETORIO_ROOT);

            try {
                if (!tools.exists()) {
                    tools.mkdirs();
                }

                if (ferramenta)
                    new Ferramenta().executar();

                if (java) {
                    new JavaService().executar();
                }
                JOptionPane.showMessageDialog(null, "Foi copiado com sucesso!");
            } catch (Exception e1) {
                JOptionPane.showMessageDialog(null, e1.getMessage());
                e1.printStackTrace();
            }
        };

    Thread thread = new Thread(iniciar);

    thread.start();

    }


}
