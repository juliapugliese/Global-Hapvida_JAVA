package UsuarioModel.Medicamentos;

public class Remedio {
    private String nome;
    private String composicao;

    public Remedio(String nome, String composicao) {
        this.nome = nome;
        this.composicao = composicao;
    }

    public Remedio() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getComposicao() {
        return composicao;
    }

    public void setComposicao(String composicao) {
        this.composicao = composicao;
    }
}
