package application.service;

import org.eclipse.jgit.api.CloneCommand;
import org.eclipse.jgit.api.CreateBranchCommand;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.JGitInternalException;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;

import java.io.File;

public class GitService {
    public void executar() {

    }

    public void cloneRepo(String repositoryUrl, String gitLocalRepositoryPath, String tfsUser, String password)  {
        try {
        CloneCommand cloneCommand = Git.cloneRepository()
                .setURI(repositoryUrl)
                .setDirectory(new File(gitLocalRepositoryPath));


        UsernamePasswordCredentialsProvider credentials = new UsernamePasswordCredentialsProvider(tfsUser, password);
        cloneCommand.setCredentialsProvider(credentials);
            cloneCommand.call();
            System.out.println("repositoryUrl = " + repositoryUrl + " foi criado com sucesso !");
        } catch (GitAPIException | JGitInternalException e) {
            System.out.println("Não foi possivel clonar o projeto para " + repositoryUrl);
            System.out.println(e.getMessage());
        }



//        Git repository = cloneCommand.call();

//        repository.checkout().setCreateBranch(true).setName("develop")
//                .setUpstreamMode(CreateBranchCommand.SetupUpstreamMode.SET_UPSTREAM)
//                .setStartPoint("origin/develop").call();
    }
}
