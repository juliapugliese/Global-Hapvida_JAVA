import UsuarioModel.Acoes.*;
import UsuarioModel.Medicamentos.Remedio;
import UsuarioModel.Pessoa.*;
import UsuarioModel.Teste.*;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Login> usuariosCadastrados;
    static ArrayList<FichaMedica> fichasMedicas;

    static ArrayList<String> alergias;
    static ArrayList<Remedio> medicamentosUsoContinuo;
    static ArrayList<HistoricoMedico> historicoMedico;

    static ArrayList<Vacinas> vacinacoes;



    public static void main(String[] args) {

        usuariosCadastrados = new ArrayList<>();
        fichasMedicas = new ArrayList<>();

        alergias = new ArrayList<>();
        medicamentosUsoContinuo = new ArrayList<>();
        historicoMedico = new ArrayList<>();

        vacinacoes = new ArrayList<>();

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

                    Optional<Login> optional = usuariosCadastrados.stream()
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
                    4) Avaliar atendimento \r
                    5) Chamar ambulância \r
                    6) Timer remédios \r
                    0) Sair""");

            var opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 2 -> {
                    System.out.println("Essa ficha médica é sua? sim/não");
                    var sn = scanner.nextLine().replaceAll("[áàâãä]", "a");
                    if (sn.equalsIgnoreCase("sim")) {
                        cadastrarFichaMedicaDonoConta(userName);
                        usuariosCadastrados.stream().filter(login -> login.getNomeUsuario().equals(userName)).forEach(login -> fichasMedicas.add(login.getDonoConta()));

                    } else if (sn.equalsIgnoreCase("nao")) {
                        usuariosCadastrados.stream().filter(login -> login.getNomeUsuario().equals(userName)).forEach(login -> login.getTerceiros().add(cadastrarFichaMedica()));
                    } else {
                        System.out.println("Opção inválida");
                    }
                }
                case 21 -> {
                    usuariosCadastrados.stream().filter(login -> login.getNomeUsuario().equals(userName)).forEach(login -> System.out.println(login.getDonoConta()));
                    usuariosCadastrados.stream().filter(login -> login.getNomeUsuario().equals(userName)).forEach(login -> System.out.println(login.getTerceiros()));
                    //imprime todas as fichas medicas
                }
                case 1 -> {
                    usuariosCadastrados.stream().filter(login -> login.getNomeUsuario().equals(userName)).forEach(System.out::println);
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
        var novoUsuario = new Login();

        System.out.println("Iniciando o cadastro de usuário");

        System.out.println("Nome de usuário: ");
        novoUsuario.setNomeUsuario(scanner.nextLine());

        System.out.println("Senha: ");
        novoUsuario.setSenha(scanner.nextLine());

        novoUsuario.setDonoConta(cadastrarPaciente());

        usuariosCadastrados.add(novoUsuario);

        System.out.println("\r\nUsuário registrado com sucesso");


    }
    public static FichaMedica cadastrarFichaMedica() {
        var novoPerfil = new FichaMedica();

        System.out.println("\r\nIniciando o cadastro da ficha medica");

        novoPerfil.setPaciente(cadastrarPaciente());

        System.out.println("Unidade de saúde que frequenta: ");
        novoPerfil.setNomeUnidadeSaudeFrequenta(scanner.nextLine());

        System.out.println("Tem alguma alergia?");
        var temAlergia = (scanner.nextLine()).replaceAll("[áàâãä]", "a");

        if (temAlergia.equalsIgnoreCase("sim")) {
            System.out.println("Quantas?");
            var qtd = scanner.nextInt(); scanner.nextLine();
            cadastrarAlergia(qtd);
            novoPerfil.setAlergia(alergias);
        }

        System.out.println("Tipo sanguíneo: ");
        novoPerfil.setTipoSanguineo(scanner.nextLine());

        System.out.println("Tem alguma doença crônica? Qual? Caso contrário digite não");
        novoPerfil.setDoencaCronica(scanner.nextLine());

        System.out.println("Usa algum medicamento continuamente? Caso contrário digite não");
        var usaMedicacao = (scanner.nextLine()).replaceAll("[áàâãä]", "a");
        if (usaMedicacao.equalsIgnoreCase("sim")) {
            System.out.println("Quantos?");
            var qtd = scanner.nextInt(); scanner.nextLine();
            cadastrarMedicamentoUsoContinuo(qtd);
            novoPerfil.setMedicacaoContinua(medicamentosUsoContinuo); }
        else { novoPerfil.setHistoricoMedico(null); }

        System.out.println("Já ficou internada ou foi operada? Caso contrário digite não");
        var temHistoricoMedico = (scanner.nextLine()).replaceAll("[áàâãä]", "a");
        if (temHistoricoMedico.equalsIgnoreCase("sim")) {
            System.out.println("Quantas vezes?");
            var qtd = scanner.nextInt(); scanner.nextLine();
            cadastrarHistoricoMedico(qtd);
            novoPerfil.setHistoricoMedico(historicoMedico); }
        else { novoPerfil.setHistoricoMedico(null); }

        System.out.println("Tem alguma deficiência? Qual? Caso contrário digite não");
        novoPerfil.setDeficiencia(scanner.nextLine());

        System.out.println("\r\nFicha médica registrada com sucesso");

        fichasMedicas.add(novoPerfil);
        return novoPerfil;
    }
    public static void cadastrarFichaMedicaDonoConta(String userName) {

        System.out.println("\r\nIniciando o cadastro da ficha medica");

        System.out.println("Unidade de saúde que frequenta: ");
        usuariosCadastrados.stream().filter(login -> login.getNomeUsuario().equals(userName)).forEach(login -> login.getDonoConta().setNomeUnidadeSaudeFrequenta(scanner.nextLine()));

        System.out.println("Tem alguma alergia?");
        var temAlergia = (scanner.nextLine()).replaceAll("[áàâãä]", "a");

        if (temAlergia.equalsIgnoreCase("sim")) {
            System.out.println("Quantas?");
            var qtd = scanner.nextInt(); scanner.nextLine();
            cadastrarAlergia(qtd);
            usuariosCadastrados.stream().filter(login -> login.getNomeUsuario().equals(userName)).forEach(login -> login.getDonoConta().setAlergia(alergias));
        }

        System.out.println("Tipo sanguíneo: ");
        usuariosCadastrados.stream().filter(login -> login.getNomeUsuario().equals(userName)).forEach(login -> login.getDonoConta().setTipoSanguineo(scanner.nextLine()));


        System.out.println("Tem alguma doença crônica? Qual? Caso contrário digite não");
        usuariosCadastrados.stream().filter(login -> login.getNomeUsuario().equals(userName)).forEach(login -> login.getDonoConta().setDoencaCronica(scanner.nextLine()));

        System.out.println("Usa algum medicamento continuamente? Caso contrário digite não");
        var usaMedicacao = (scanner.nextLine()).replaceAll("[áàâãä]", "a");
        if (usaMedicacao.equalsIgnoreCase("sim")) {
            System.out.println("Quantos?");
            var qtd = scanner.nextInt(); scanner.nextLine();
            cadastrarMedicamentoUsoContinuo(qtd);
            usuariosCadastrados.stream().filter(login -> login.getNomeUsuario().equals(userName)).forEach(login -> login.getDonoConta().setMedicacaoContinua(medicamentosUsoContinuo));
        }
        else { usuariosCadastrados.stream().filter(login -> login.getNomeUsuario().equals(userName)).forEach(login -> login.getDonoConta().setMedicacaoContinua(null));
        }

        System.out.println("Já ficou internada ou foi operada? Caso contrário digite não");
        var temHistoricoMedico = (scanner.nextLine()).replaceAll("[áàâãä]", "a");
        if (temHistoricoMedico.equalsIgnoreCase("sim")) {
            System.out.println("Quantas vezes?");
            var qtd = scanner.nextInt(); scanner.nextLine();
            cadastrarHistoricoMedico(qtd);
            usuariosCadastrados.stream().filter(login -> login.getNomeUsuario().equals(userName)).forEach(login -> login.getDonoConta().setHistoricoMedico(historicoMedico));
        }
        else {usuariosCadastrados.stream().filter(login -> login.getNomeUsuario().equals(userName)).forEach(login -> login.getDonoConta().setHistoricoMedico(null));
        }

        System.out.println("Tem alguma deficiência? Qual? Caso contrário digite não");
        usuariosCadastrados.stream().filter(login -> login.getNomeUsuario().equals(userName)).forEach(login -> login.getDonoConta().setDeficiencia(scanner.nextLine()));

        System.out.println("\r\nFicha médica registrada com sucesso");
    }
    public static Consulta agendarConsulta(){
        var novaConsulta = new Consulta();

        System.out.printf("Digite a data da consulta (DD/MM/AAAA): ");
        return novaConsulta;

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

        return novoPerfil;
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

}