package UsuarioModel.Acoes;

import UsuarioModel.Pessoa.Paciente;

import java.util.ArrayList;
import java.util.List;

public class Login {
    private String nomeUsuario;
    private String senha;
    private Paciente donoConta;
    private List<Paciente> terceiros = new ArrayList<>();

    public Login() {
    }

    public Login(String nomeUsuario, String senha) {
        this.nomeUsuario = nomeUsuario;
        this.senha = senha;
    }

    public Login(String nomeUsuario, String senha, List<Paciente> terceiros) {
        this.nomeUsuario = nomeUsuario;
        this.senha = senha;
        this.terceiros = terceiros;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Paciente> getTerceiros() {
        return terceiros;
    }

    public void setTerceiros(List<Paciente> terceiros) {
        this.terceiros = terceiros;
    }

    public Paciente getDonoConta() {
        return donoConta;
    }

    public void setDonoConta(Paciente donoConta) {
        this.donoConta = donoConta;
    }

    @Override
    public String toString() {
        return  "\r\n" + "Dono da conta: \r\n" +
                "Nome de usuário: " + nomeUsuario + "\r\n" +
                "Senha: " + "*********" + "\r\n" +
                donoConta;
    }
}
