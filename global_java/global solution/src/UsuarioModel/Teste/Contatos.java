package UsuarioModel.Teste;

import java.util.Random;
import java.util.Scanner;

public class Contatos {

    private String nome;
    private String telefone;
    static Scanner scanner = new Scanner(System.in);

    public static void chamarAmbulancia(){

        System.out.println("Diga o seu nome");
        var nome = scanner.nextInt();


        System.out.println("Diga o que esta acontencendo com você");
        System.out.println("Captando audio...");
        System.out.println("Captando localização do dispositivo...");
        System.out.println("Captando numero de telefone do dispositivo...");
        System.out.println("chamando ambulância... enviando ficha medica para o hospital");

        //O que você deve saber antes de ligar para o 192:
        // 1 - o que aconteceu com o paciente;
        //2 - endereço - rua, avenida, número, bairro e referência do local da ocorrência;
        //3 - dados do paciente, como nome, idade e sexo;
        //4 - o número do telefone de onde você está ligando.
    }
}
