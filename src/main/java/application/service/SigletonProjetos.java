package application.service;

import application.Project;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SigletonProjetos {
    private static List<Project> projetos;

    static {
        projetos = carregarLista();
    }

    private SigletonProjetos() {
    }

    private static List<Project> carregarLista() {
        return Arrays.stream(Configuracao.projetos)
                .map(proj -> {
                    final String[] projetoTag = proj.split(":");
                    if(projetoTag.length == 1)
                        return new Project(projetoTag[0], "Não", "master");


                    return new Project(projetoTag[0], "Não", projetoTag[1]);
                })
                .collect(Collectors.toList());

    }

    public static List<Project> getProjetos() {
        return projetos;
    }
}
