package UsuarioModel.Acoes;

import UsuarioModel.Acoes.HistoricoMedico;
import UsuarioModel.Pessoa.Paciente;
import UsuarioModel.Teste.PlanoDeSaude;
import UsuarioModel.Medicamentos.Remedio;
import UsuarioModel.Teste.Vacinas;

import java.util.List;
public class FichaMedica {
    private String nomeUnidadeSaudeFrequenta;
    private List<String> alergia;
    private String tipoSanguineo;
    private String doencaCronica;
    private List<Remedio> medicacaoContinua;
    private List<HistoricoMedico> historicoMedico;
    private String deficiencia;
    private List<Vacinas> vacinacao;
    private PlanoDeSaude planoDeSaude;

    public FichaMedica() {
    }

    public FichaMedica(String nomeUnidadeSaudeFrequenta, List<String> alergia, String tipoSanguineo, String doencaCronica, List<Remedio> medicacaoContinua, List<HistoricoMedico> historicoMedico, String deficiencia, List<Vacinas> vacinacao, PlanoDeSaude planoDeSaude) {
        this.nomeUnidadeSaudeFrequenta = nomeUnidadeSaudeFrequenta;
        this.alergia = alergia;
        this.tipoSanguineo = tipoSanguineo;
        this.doencaCronica = doencaCronica;
        this.medicacaoContinua = medicacaoContinua;
        this.historicoMedico = historicoMedico;
        this.deficiencia = deficiencia;
        this.vacinacao = vacinacao;
        this.planoDeSaude = planoDeSaude;
    }


    public String getNomeUnidadeSaudeFrequenta() {
        return nomeUnidadeSaudeFrequenta;
    }

    public void setNomeUnidadeSaudeFrequenta(String nomeUnidadeSaudeFrequenta) {
        this.nomeUnidadeSaudeFrequenta = nomeUnidadeSaudeFrequenta;
    }

    public List<String> getAlergia() {
        return alergia;
    }

    public void setAlergia(List<String> alergia) {
        this.alergia = alergia;
    }

    public String getTipoSanguineo() {
        return tipoSanguineo;
    }

    public void setTipoSanguineo(String tipoSanguineo) {
        this.tipoSanguineo = tipoSanguineo;
    }

    public String getDoencaCronica() {
        return doencaCronica;
    }

    public void setDoencaCronica(String doencaCronica) {
        this.doencaCronica = doencaCronica;
    }

    public List<Remedio> getMedicacaoContinua() {
        return medicacaoContinua;
    }

    public void setMedicacaoContinua(List<Remedio> medicacaoContinua) {
        this.medicacaoContinua = medicacaoContinua;
    }

    public List<HistoricoMedico> getHistoricoMedico() {
        return historicoMedico;
    }

    public void setHistoricoMedico(List<HistoricoMedico> historicoMedico) {
        this.historicoMedico = historicoMedico;
    }

    public String getDeficiencia() {
        return deficiencia;
    }

    public void setDeficiencia(String deficiencia) {
        this.deficiencia = deficiencia;
    }

    public List<Vacinas> getVacinacao() {
        return vacinacao;
    }

    public void setVacinacao(List<Vacinas> vacinacao) {
        this.vacinacao = vacinacao;
    }

    public PlanoDeSaude getPlanoDeSaude() {
        return planoDeSaude;
    }

    public void setPlanoDeSaude(PlanoDeSaude planoDeSaude) {
        this.planoDeSaude = planoDeSaude;
    }

    @Override
    public String toString() {
        return
                "Unidade saúde que frequenta: " + nomeUnidadeSaudeFrequenta + "\r\n" +
                "Alergia: " + alergia + "\r\n" +
                "Tipo Sanguíneo: " + tipoSanguineo + "\r\n" +
                "Doença Crônica: " + doencaCronica + "\r\n" +
                "Medicação contínua: " + medicacaoContinua + "\r\n" +
                "Histórico médico: " + historicoMedico + "\r\n" +
                "Deficiência: " + deficiencia + "\r\n" +
                "Vacinação: " + vacinacao + "\r\n" +
                "Plano de saúde: " + planoDeSaude + "\r\n";

    }


}
