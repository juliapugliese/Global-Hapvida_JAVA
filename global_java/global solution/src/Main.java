import UsuarioModel.Acoes.*;
import UsuarioModel.Medicamentos.Remedio;
import UsuarioModel.Pessoa.*;
import UsuarioModel.Pessoa.DadosPaciente.Conta;
import UsuarioModel.Pessoa.DadosPaciente.Contatos;
import UsuarioModel.Pessoa.DadosPaciente.FichaMedica;
import UsuarioModel.Pessoa.DadosPaciente.HistoricoMedico;
import UsuarioModel.Teste.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Conta> contasCadastradas;
    static ArrayList <Paciente> pacientes;
    static ArrayList <Medico> medicos;

    static ArrayList <Consulta> consultas;


    static ArrayList<String> alergias;
    static ArrayList<Remedio> medicamentosUsoContinuo;
    static ArrayList<HistoricoMedico> historicoMedico;

    static ArrayList<Vacinas> vacinacoes;



    public static void main(String[] args) {

        contasCadastradas = new ArrayList<>();
        pacientes = new ArrayList<>();
        medicos = new ArrayList<>();

        alergias = new ArrayList<>();
        medicamentosUsoContinuo = new ArrayList<>();
        historicoMedico = new ArrayList<>();

        vacinacoes = new ArrayList<>();
        consultas = new ArrayList<>();

        while (true) {
            System.out.println("""
                    \r
                    Bem vindo ao nosso sistema, digite a opção desejada:\r
                    1) Cadastrar\r
                    2) Fazer Login\r
                    0) Sair""");

            var opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 2 -> {
                    System.out.println("Digite seu nome de usuário");
                    var nomeUsuario = scanner.nextLine();

                    System.out.println("Digite sua senha");
                    var senha = scanner.nextLine();

                    Optional<Conta> optional = contasCadastradas.stream()
                            .filter(pessoa -> pessoa.getNomeUsuario().equals(nomeUsuario) & pessoa.getSenha().equals(senha)).findAny();

                    if (optional.isPresent()) {
                        abrirMenuUsuario(nomeUsuario);
                    } else {
                        System.out.println("Usuário ou senha inválidos");
                    }
                }
                case 1 -> {
                    criarConta();
                }
                case 0 -> {
                    System.out.println("Encerrando sistema;");
                    System.exit(0);
                }
                default -> {
                    System.out.println("Opção inválida");
                }
            }
        }

    }


    public static void abrirMenuUsuario(String userName) {

        while (true) {
            System.out.println("""
                    \r
                    Bem vindo ao nosso sistema, digite a opção desejada:\r
                    1) Verificar dados da conta \r
                    2) Cadastrar ficha médica \r
                        21) Imprimir fichas médicas \r
                    3) Agendar consulta \r
                    4) Cadastrar contatos \r
                    5) Avaliar atendimento \r
                    6) Chamar ambulância \r
                    7) Timer remédios \r
                    0) Sair""");

            var opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 4 -> {
                    System.out.println("Sincronizando contatos cadastrados..." );
                    contasCadastradas.stream().filter(login -> login.getNomeUsuario().equals(userName)).forEach(login -> login.getDonoConta().setContatos(sincronizarContatos(userName)));

                    contasCadastradas.stream().filter(login -> login.getNomeUsuario().equals(userName)).forEach(login -> login.getDonoConta().getContatos().add(cadastrarContatos()));

                    //teste
                    contasCadastradas.stream().filter(login -> login.getNomeUsuario().equals(userName)).forEach(login -> System.out.println("Contatos: " + login.getDonoConta().getContatos()));

                }
                case 3 -> {
                    agendarConsulta(contasCadastradas.stream()
                            .filter(login -> login.getNomeUsuario().equals(userName)).map(Conta::getDonoConta)
                            .findFirst().orElse(null));
                }
                case 2 -> {
                    System.out.println("Essa ficha médica é sua? sim/não");
                    var sn = scanner.nextLine().replaceAll("[áàâãä]", "a");
                    if (sn.equalsIgnoreCase("sim")) {
                        System.out.println("\r\nIniciando o cadastro da ficha medica");
                        contasCadastradas.stream().filter(login -> login.getNomeUsuario().equals(userName)).forEach(login ->login.getDonoConta().setFichaMedica(cadastrarFichaMedica()));

                    } else if (sn.equalsIgnoreCase("nao")) {
                        System.out.println("\r\nIniciando o cadastro da ficha medica");
                        contasCadastradas.stream().filter(login -> login.getNomeUsuario().equals(userName)).forEach(login -> login.getFamiliares().add(cadastrarFichaMedicaFamiliares()));
                    } else {
                        System.out.println("Opção inválida");
                    }
                }
                case 21 -> {
                    contasCadastradas.stream().filter(login -> login.getNomeUsuario().equals(userName)).forEach(login -> System.out.println(login.getDonoConta().toString() + login.getDonoConta().getFichaMedica()));
                    contasCadastradas.stream().filter(login -> login.getNomeUsuario().equals(userName)).forEach(login -> login.getFamiliares().forEach(familiar -> System.out.println(familiar.toString() + familiar.getFichaMedica())));

                    //imprime todas as fichas medicas
                }
                case 1 -> {
                    contasCadastradas.stream().filter(login -> login.getNomeUsuario().equals(userName)).forEach(System.out::println);
                    //imprime dados dono da conta
                }
                case 0 -> {
                    System.out.println("Encerrando sistema;");
                    //teste original System.exit(0);
                }
                default -> System.out.println("Opção inválida");
            }
        }

    }

    public static void criarConta() {
        var novoUsuario = new Conta();

        System.out.println("Iniciando o cadastro de usuário");

        System.out.println("Nome de usuário: ");
        novoUsuario.setNomeUsuario(scanner.nextLine());

        System.out.println("Senha: ");
        novoUsuario.setSenha(scanner.nextLine());

        novoUsuario.setDonoConta(cadastrarPaciente());

        contasCadastradas.add(novoUsuario);

        System.out.println("\r\nUsuário registrado com sucesso");


    }
    public static Paciente cadastrarPaciente() {
        var novoPerfil = new Paciente();

        System.out.println("Nome completo: ");
        novoPerfil.setNome(scanner.nextLine());

        System.out.println("RG: ");
        novoPerfil.setRg(scanner.nextInt());
        scanner.nextLine();

        System.out.println("CPF: ");
        novoPerfil.setCpf(scanner.nextInt());
        scanner.nextLine();

        System.out.println("Data de nascimento: ");
        novoPerfil.setDataNascimento(scanner.nextLine());

        System.out.println("Sexo: ");
        novoPerfil.setSexo(scanner.nextLine());

        System.out.println("Telefone: ");
        novoPerfil.setTelefone(scanner.nextLine());

        System.out.println("Email: ");
        novoPerfil.setEmail(scanner.nextLine());

        System.out.println("Endereço com referência: ");
        novoPerfil.setEndereco(scanner.nextLine());

        System.out.println("CEP: ");
        novoPerfil.setCep(scanner.nextInt());
        scanner.nextLine();

        pacientes.add(novoPerfil);

        return novoPerfil;
    }
    public static FichaMedica cadastrarFichaMedica() {
        var novaFichaMedica = new FichaMedica();


        System.out.println("Unidade de saúde que frequenta: ");
        novaFichaMedica.setNomeUnidadeSaudeFrequenta(scanner.nextLine());

        System.out.println("Tem alguma alergia?");
        var temAlergia = (scanner.nextLine()).replaceAll("[áàâãä]", "a");

        if (temAlergia.equalsIgnoreCase("sim")) {
            System.out.println("Quantas?");
            var qtd = scanner.nextInt(); scanner.nextLine();
            cadastrarAlergia(qtd);
            novaFichaMedica.setAlergia(alergias);
        }

        System.out.println("Tipo sanguíneo: ");
        novaFichaMedica.setTipoSanguineo(scanner.nextLine());

        System.out.println("Tem alguma doença crônica? Qual? Caso contrário digite não");
        novaFichaMedica.setDoencaCronica(scanner.nextLine());

        System.out.println("Usa algum medicamento continuamente? Caso contrário digite não");
        var usaMedicacao = (scanner.nextLine()).replaceAll("[áàâãä]", "a");
        if (usaMedicacao.equalsIgnoreCase("sim")) {
            System.out.println("Quantos?");
            var qtd = scanner.nextInt(); scanner.nextLine();
            cadastrarMedicamentoUsoContinuo(qtd);
            novaFichaMedica.setMedicacaoContinua(medicamentosUsoContinuo); }
        else { novaFichaMedica.setHistoricoMedico(null); }

        System.out.println("Já ficou internada ou foi operada? Caso contrário digite não");
        var temHistoricoMedico = (scanner.nextLine()).replaceAll("[áàâãä]", "a");
        if (temHistoricoMedico.equalsIgnoreCase("sim")) {
            System.out.println("Quantas vezes?");
            var qtd = scanner.nextInt(); scanner.nextLine();
            cadastrarHistoricoMedico(qtd);
            novaFichaMedica.setHistoricoMedico(historicoMedico); }
        else { novaFichaMedica.setHistoricoMedico(null); }

        System.out.println("Tem alguma deficiência? Qual? Caso contrário digite não");
        novaFichaMedica.setDeficiencia(scanner.nextLine());

        System.out.println("\r\nFicha médica registrada com sucesso");

        return novaFichaMedica;
    }
    public static Paciente cadastrarFichaMedicaFamiliares() {
        var novoPerfil = new Paciente();

        System.out.println("Nome completo: ");
        novoPerfil.setNome(scanner.nextLine());

        System.out.println("RG: ");
        novoPerfil.setRg(scanner.nextInt());
        scanner.nextLine();

        System.out.println("CPF: ");
        novoPerfil.setCpf(scanner.nextInt());
        scanner.nextLine();

        System.out.println("Data de nascimento: ");
        novoPerfil.setDataNascimento(scanner.nextLine());

        System.out.println("Sexo: ");
        novoPerfil.setSexo(scanner.nextLine());

        System.out.println("Telefone: ");
        novoPerfil.setTelefone(scanner.nextLine());

        System.out.println("Email: ");
        novoPerfil.setEmail(scanner.nextLine());

        System.out.println("Endereço com referência: ");
        novoPerfil.setEndereco(scanner.nextLine());

        System.out.println("CEP: ");
        novoPerfil.setCep(scanner.nextInt());
        scanner.nextLine();

        novoPerfil.setFichaMedica(cadastrarFichaMedica());

        return novoPerfil;
    }

    public static void agendarConsulta(Paciente dadosPaciente){

        var novaConsulta = new Consulta();

        novaConsulta.setPaciente(dadosPaciente);

        System.out.println("Digite a data da consulta (DD/MM/AAAA): ");
        novaConsulta.setDataConsulta(scanner.nextLine());

        System.out.println("Digite o motivo da consulta: ");
        novaConsulta.setMotivo(scanner.nextLine());

        System.out.println("Digite o médico com quem ira se consultar: ");
        var medicoConsulta = scanner.nextLine();
        novaConsulta.getMedico().setNome(medicoConsulta);
        medicos.stream().filter(medico -> medico.getNome().equalsIgnoreCase(medicoConsulta)).forEach(cadastro -> cadastro.getConsultasAgendadas().add(novaConsulta));

        System.out.println("Seu pedido será avaliado pelo médico e dentro de 48h você receberá uma confirmação por email");

        System.out.println(novaConsulta);

        consultas.add(novaConsulta);

    }

    public  static List<Contatos> sincronizarContatos (String userName) {

         List<Contatos> contatosDonoConta = new ArrayList<>();
         var novoContato = new Contatos();

        contasCadastradas.stream()
                .filter(login -> login.getNomeUsuario().equals(userName))
                .flatMap(login -> login.getFamiliares().stream())
                .forEach(familiar -> {
                    novoContato.setNome(familiar.getNome());
                    novoContato.setTelefone(familiar.getTelefone());
                    contatosDonoConta.add(novoContato);
                });
        return contatosDonoConta;

    }
    public  static Contatos cadastrarContatos(){
        var novoContato = new Contatos();

        System.out.println("Nome: ");
        novoContato.setNome(scanner.nextLine());

        System.out.println("Telefone: ");
        novoContato.setTelefone(scanner.nextLine());

        return novoContato;

    }

    public static void cadastrarAlergia(int qtd){
        int contador = 0;
        while (contador != qtd) {

            System.out.println("Causa da alergia: ");
            var novaAlergia = scanner.nextLine();

            contador ++;
            alergias.add(novaAlergia);
        }
    }
    public static void cadastrarHistoricoMedico(int qtd){
        int contador = 0;
        while (contador != qtd) {
            var novaPassagem = new HistoricoMedico();

            System.out.println("Nome da operação ou causa da internação: ");
            novaPassagem.setNomeOuMotivo(scanner.nextLine());

            System.out.println("Nome do hospital: ");
            novaPassagem.setHospital(scanner.nextLine());

            System.out.println("Data: ");
            novaPassagem.setDataInicio(scanner.nextLine());

            System.out.println("Teve complicações? Caso contrário digite não");
            novaPassagem.setComplicacoes(scanner.nextLine());

            contador ++;
            historicoMedico.add(novaPassagem);
        }
    }
    public static void cadastrarMedicamentoUsoContinuo(int qtd){
        int contador = 0;
        while (contador != qtd) {
            var novoMedicamento = new Remedio();

            System.out.println("Nome do medicamento: ");
            novoMedicamento.setNome(scanner.nextLine());

            System.out.println("Composição do medicamento: ");
            novoMedicamento.setComposicao(scanner.nextLine());

            contador ++;
            medicamentosUsoContinuo.add(novoMedicamento);
        }
    }


    //    public static void cadastrarFichaMedicaDonoConta(String userName) {
//
//        System.out.println("\r\nIniciando o cadastro da ficha medica");
//
//        System.out.println("Unidade de saúde que frequenta: ");
//        usuariosCadastrados.stream().filter(login -> login.getNomeUsuario().equals(userName)).forEach(login -> login.getDonoConta().setNomeUnidadeSaudeFrequenta(scanner.nextLine()));
//
//        System.out.println("Tem alguma alergia?");
//        var temAlergia = (scanner.nextLine()).replaceAll("[áàâãä]", "a");
//
//        if (temAlergia.equalsIgnoreCase("sim")) {
//            System.out.println("Quantas?");
//            var qtd = scanner.nextInt(); scanner.nextLine();
//            cadastrarAlergia(qtd);
//            usuariosCadastrados.stream().filter(login -> login.getNomeUsuario().equals(userName)).forEach(login -> login.getDonoConta().setAlergia(alergias));
//        }
//
//        System.out.println("Tipo sanguíneo: ");
//        usuariosCadastrados.stream().filter(login -> login.getNomeUsuario().equals(userName)).forEach(login -> login.getDonoConta().setTipoSanguineo(scanner.nextLine()));
//
//
//        System.out.println("Tem alguma doença crônica? Qual? Caso contrário digite não");
//        usuariosCadastrados.stream().filter(login -> login.getNomeUsuario().equals(userName)).forEach(login -> login.getDonoConta().setDoencaCronica(scanner.nextLine()));
//
//        System.out.println("Usa algum medicamento continuamente? Caso contrário digite não");
//        var usaMedicacao = (scanner.nextLine()).replaceAll("[áàâãä]", "a");
//        if (usaMedicacao.equalsIgnoreCase("sim")) {
//            System.out.println("Quantos?");
//            var qtd = scanner.nextInt(); scanner.nextLine();
//            cadastrarMedicamentoUsoContinuo(qtd);
//            usuariosCadastrados.stream().filter(login -> login.getNomeUsuario().equals(userName)).forEach(login -> login.getDonoConta().setMedicacaoContinua(medicamentosUsoContinuo));
//        }
//        else { usuariosCadastrados.stream().filter(login -> login.getNomeUsuario().equals(userName)).forEach(login -> login.getDonoConta().setMedicacaoContinua(null));
//        }
//
//        System.out.println("Já ficou internada ou foi operada? Caso contrário digite não");
//        var temHistoricoMedico = (scanner.nextLine()).replaceAll("[áàâãä]", "a");
//        if (temHistoricoMedico.equalsIgnoreCase("sim")) {
//            System.out.println("Quantas vezes?");
//            var qtd = scanner.nextInt(); scanner.nextLine();
//            cadastrarHistoricoMedico(qtd);
//            usuariosCadastrados.stream().filter(login -> login.getNomeUsuario().equals(userName)).forEach(login -> login.getDonoConta().setHistoricoMedico(historicoMedico));
//        }
//        else {usuariosCadastrados.stream().filter(login -> login.getNomeUsuario().equals(userName)).forEach(login -> login.getDonoConta().setHistoricoMedico(null));
//        }
//
//        System.out.println("Tem alguma deficiência? Qual? Caso contrário digite não");
//        usuariosCadastrados.stream().filter(login -> login.getNomeUsuario().equals(userName)).forEach(login -> login.getDonoConta().setDeficiencia(scanner.nextLine()));
//
//        System.out.println("\r\nFicha médica registrada com sucesso");
//    }

}