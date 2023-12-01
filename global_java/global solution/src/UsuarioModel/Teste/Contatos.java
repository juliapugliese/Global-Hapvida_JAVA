package UsuarioModel.Teste;

import java.util.Random;
import java.util.Scanner;

public class Contatos {

    private String nome;
    private String telefone;

    public Contatos() {
    }

    public Contatos(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return  nome +  " " +
                "Telefone: " + telefone;
    }
}
