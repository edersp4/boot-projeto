package application;

import javafx.beans.property.SimpleStringProperty;

public class Project {
    private final SimpleStringProperty nome;
    private final SimpleStringProperty baixado;
    private final SimpleStringProperty tag;

    public Project(String nome, String baixado, String tag) {
        this.nome = new SimpleStringProperty(nome);
        this.baixado = new SimpleStringProperty(baixado);
        this.tag = new SimpleStringProperty(tag);
    }

    public String getNome() {
        return nome.get();
    }

    public SimpleStringProperty nomeProperty() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome.set(nome);
    }

    public String getBaixado() {
        return baixado.get();
    }

    public SimpleStringProperty baixadoProperty() {
        return baixado;
    }

    public void setBaixado(String baixado) {
        this.baixado.set(baixado);
    }

    public String getTag() {
        return tag.get();
    }

    public SimpleStringProperty tagProperty() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag.set(tag);
    }
}
