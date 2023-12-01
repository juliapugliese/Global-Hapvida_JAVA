package UsuarioModel.Pessoa;

import UsuarioModel.Acoes.FichaMedica;
import UsuarioModel.Teste.Consulta;
import UsuarioModel.Teste.Contatos;

import java.util.ArrayList;
import java.util.List;

public class Paciente {
    private int id;
    private static int contadorId = 1;
    private String nome;
    private String sexo;
    private int rg;
    private int cpf;
    private String dataNascimento;
    private String telefone;
    private String email;
    private String endereco;
    private int cep;
    private FichaMedica fichaMedica;
    private List<Contatos> contatos;

    public Paciente(){
        this.id = contadorId;
        contadorId += 1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getContadorId() {
        return contadorId;
    }

    public static void setContadorId(int contadorId) {
        Paciente.contadorId = contadorId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getRg() {
        return rg;
    }

    public void setRg(int rg) {
        this.rg = rg;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public FichaMedica getFichaMedica() {
        return fichaMedica;
    }

    public void setFichaMedica(FichaMedica fichaMedica) {
        this.fichaMedica = fichaMedica;
    }

    public List<Contatos> getContatos() {
        return contatos;
    }

    public void setContatos(List<Contatos> contatos) {
        this.contatos = contatos;
    }

    @Override
    public String toString() {
        return  "Nome: " + nome + "\r\n" +
                "Id: " + id + "\r\n" +
                "Data de nascimento: " + dataNascimento + "\r\n" +
                "Sexo: " + sexo + "\r\n" +
                "RG: " + rg + "\r\n" +
                "CPF: " + cpf + "\r\n" +
                "Telefone: " + telefone + "\r\n" +
                "E-mail: " + email + "\r\n" +
                "Endereço: " + endereco + "\r\n" +
                "CEP: " + cep + "\r\n";
    }
}
