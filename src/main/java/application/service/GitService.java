package application.service;

import application.ArquivoController;
import application.Project;
import org.eclipse.jgit.api.CloneCommand;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.*;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class GitService {

    public void cloneRepo(String repositoryUrl, String gitLocalRepositoryPath, String tfsUser, String password, Project projeto, boolean ehParaClonar) {
        try {

            if (!ehParaClonar) {
                CloneCommand cloneCommand = Git.cloneRepository()
                        .setURI(repositoryUrl)
                        .setDirectory(new File(gitLocalRepositoryPath));


                UsernamePasswordCredentialsProvider credentials = new UsernamePasswordCredentialsProvider(tfsUser, password);
                cloneCommand.setCredentialsProvider(credentials);
                Git repository = cloneCommand.call();


                System.out.println("repositoryUrl = " + repositoryUrl + " foi criado com sucesso !");

                projeto.setBaixado("Sim");

                checkout(projeto, repository);
            }

            try (Git git = Git.open(new File(gitLocalRepositoryPath))) {
                projeto.setBaixado("Sim");
                checkout(projeto, git);
            } catch (IOException e) {
                projeto.setBaixado("Não");
                e.printStackTrace();
            }

        } catch (GitAPIException |
                JGitInternalException e) {
            System.out.println("Não foi possivel clonar o projeto para " + repositoryUrl);
            System.out.println(e.getMessage());
            projeto.setBaixado("Não");
        }
    }

    private void checkout(Project projeto, Git repository) throws GitAPIException {
        System.out.println("Projeto checkout =" + projeto);
        final Ref ref = repository.getRepository()
                .getTags()
                .get(projeto.getTag());

        if (Objects.nonNull(ref))
            repository.checkout()
                    .setName(ref.getObjectId()
                            .name())
                    .call();
        else {
            repository.checkout()
                    .setName(projeto.getTag())
                    .call();
        }
    }
}

