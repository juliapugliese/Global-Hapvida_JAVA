package UsuarioModel.Teste;

import UsuarioModel.Pessoa.Medico;
import UsuarioModel.Acoes.FichaMedica;

public class Consulta {
    private int id;
    private static int contadorId = 1;
    private FichaMedica fichaMedica;
    private Medico medico;
    private String dataConsulta;
    private String motivo;

    public Consulta(){
        this.id = contadorId;
        contadorId += 1;
    }
    public Consulta(int id, FichaMedica fichaMedica, Medico medico, String dataConsulta, String motivo) {
        this.id = id;
        this.fichaMedica = fichaMedica;
        this.medico = medico;
        this.dataConsulta = dataConsulta;
        this.motivo = motivo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public FichaMedica getFichaMedica() {
        return fichaMedica;
    }

    public void setFichaMedica(FichaMedica fichaMedica) {
        this.fichaMedica = fichaMedica;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
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
                "Ficha médica: " + fichaMedica + "\r\n" +
                "Médico: " + medico +  "\r\n" +
                "Data da consulta: " + dataConsulta + "\r\n" +
                "Motivo: " + motivo ;
    }
}
