package UsuarioModel.Pessoa;

import UsuarioModel.Teste.Consulta;

import java.util.ArrayList;
import java.util.List;

public class Medico {
    private int id;
    private static int contadorId = 1;
    private String nome;
    private String especialidade;
    private List<Consulta> consultasAgendadas = new ArrayList<>();

    public Medico(){
        this.id = contadorId;
        contadorId += 1;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public List<Consulta> getConsultasAgendadas() {
        return consultasAgendadas;
    }

    public void setConsultasAgendadas(List<Consulta> consultasAgendadas) {
        this.consultasAgendadas = consultasAgendadas;
    }
}
