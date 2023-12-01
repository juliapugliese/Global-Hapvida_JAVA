package UsuarioModel.Pessoa.DadosPaciente;

public class HistoricoMedico {
    private String nomeOuMotivo;
    private String hospital;
    private String dataInicio;
    private String dataAlta;
    private String complicacoes;

    public HistoricoMedico() {
    }

    public HistoricoMedico(String nomeOuMotivo, String hospital, String dataInicio, String dataAlta, String complicacoes) {
        this.nomeOuMotivo = nomeOuMotivo;
        this.hospital = hospital;
        this.dataInicio = dataInicio;
        this.dataAlta = dataAlta;
        this.complicacoes = complicacoes;
    }

    public HistoricoMedico(String nomeOuMotivo, String hospital, String dataInicio, String dataAlta) {
        this.nomeOuMotivo = nomeOuMotivo;
        this.hospital = hospital;
        this.dataInicio = dataInicio;
        this.dataAlta = dataAlta;
    }

    public String getNomeOuMotivo() {
        return nomeOuMotivo;
    }

    public void setNomeOuMotivo(String nomeOuMotivo) {
        this.nomeOuMotivo = nomeOuMotivo;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataAlta() {
        return dataAlta;
    }

    public void setDataAlta(String dataAlta) {
        this.dataAlta = dataAlta;
    }

    public String getComplicacoes() {
        return complicacoes;
    }

    public void setComplicacoes(String complicacoes) {
        this.complicacoes = complicacoes;
    }

    @Override
    public String toString() {
        return  nomeOuMotivo + " no " +
                hospital + "dia" + dataInicio +
                ", complicações:" + complicacoes;
    }
}
