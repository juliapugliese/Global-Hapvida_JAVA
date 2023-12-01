package UsuarioModel.Pessoa.DadosPaciente;

import UsuarioModel.Pessoa.Paciente;

import java.util.ArrayList;
import java.util.List;

public class Conta {
    private String nomeUsuario;
    private String senha;
    private Paciente donoConta;
    private List<Paciente> familiares = new ArrayList<>();

    public Conta() {
    }

    public Conta(String nomeUsuario, String senha) {
        this.nomeUsuario = nomeUsuario;
        this.senha = senha;
    }

    public Conta(String nomeUsuario, String senha, List<Paciente> familiares) {
        this.nomeUsuario = nomeUsuario;
        this.senha = senha;
        this.familiares = familiares;
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

    public List<Paciente> getFamiliares() {
        return familiares;
    }

    public void setFamiliares(List<Paciente> familiares) {
        this.familiares = familiares;
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
