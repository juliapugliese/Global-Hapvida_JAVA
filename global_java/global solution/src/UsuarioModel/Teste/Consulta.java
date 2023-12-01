package UsuarioModel.Teste;

import UsuarioModel.Pessoa.Medico;
import UsuarioModel.Acoes.FichaMedica;
import UsuarioModel.Pessoa.Paciente;

public class Consulta {
    private int id;
    private static int contadorId = 1;
    private Paciente paciente;
    private String dataConsulta;
    private String motivo;

    public Consulta(){
        this.id = contadorId;
        contadorId += 1;
    }
    public Consulta(int id, Paciente paciente, String dataConsulta, String motivo) {
        this.id = id;
        this.paciente = paciente;
        this.dataConsulta = dataConsulta;
        this.motivo = motivo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public String getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(String dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    @Override
    public String toString() {
        return "Consulta:" + "\r\n" +
                "ID: " + id + "\r\n" +
                "Dados paciente: " + paciente + "\r\n" +
                "Data da consulta: " + dataConsulta + "\r\n" +
                "Motivo: " + motivo ;
    }
}
