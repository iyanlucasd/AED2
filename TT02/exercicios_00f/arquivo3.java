package exercicios_00f;

import java.io.*;
import java.util.*;

class arquivo3 {
    // ler e escrever uma frase
    // exercício 1
    public static void escreverFrase() {
        Scanner input = new Scanner(System.in);
        Arq.openWrite(input.nextLine());
        String s = "";
        s = input.nextLine();
        Arq.println(s);
        Arq.close();
    }

    // ler e printar na tela, depois converte tudo para uppercase
    // exercício 2
    public static void lerPrintTela() {
        Scanner input = new Scanner(System.in);
        Arq.openRead(input.nextLine());
        String x = new String();
        x = Arq.readAll();
        System.out.println(x);
        System.out.println(x.toUpperCase());
        Arq.close();
    }

    // ler e cola tudo em outro arquivo
    // exercício 3
    public static void copiaCola() {
        Scanner input = new Scanner(System.in);
        Arq.openRead(input.nextLine());
        String x = "";
        x = Arq.readAll();
        Arq.close();
        Arq.openWrite("copia.txt");
        Arq.print(x);
        Arq.close();
    }

    // ler e printa tudo em maiúsculo
    // exercício 4
    public static void lerUpperCase() {
        Scanner input = new Scanner(System.in);
        Arq.openRead(input.nextLine());
        String x = "";
        x = Arq.readAll();
        Arq.close();
        Arq.openWrite(input.nextLine());
        Arq.print(x.toUpperCase());
        Arq.close();

    }

    // ler e cola tudo em outro arquivo invertido
    // exercício 5
    public static void charInversor() {
        StringBuilder builder = new StringBuilder();
        StringBuilder reverse = new StringBuilder();
        Scanner input = new Scanner(System.in);
        Arq.openRead(input.nextLine());
        String x = "";
        x = Arq.readAll();
        builder.append(x);
        System.out.println(x);
        Arq.close();
        Arq.openWrite("copia.txt");
        reverse = builder.reverse();
        System.out.println(reverse);
        x = reverse.toString();
        Arq.print(x);
        Arq.close();

    }

    public static void cifraCesarLeitura() {
        Scanner input = new Scanner(System.in);
        Arq.openRead(input.nextLine());
        String x = "";
        x = Arq.readAll();
        Arq.close();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < x.length(); i++) {
            if (x.charAt(i) != 32 || x.charAt(i) != '\n') {
                int aux = 0;
                aux = ((int) x.charAt(i) + 3);
                builder.append((char) aux);
            } else {
                builder.append(x.charAt(i));
            }
        }
        System.out.println(builder.toString());
    }

public static void cifraCesarDescrypto() {
    Scanner input = new Scanner(System.in);
    Arq.openRead(input.nextLine());
    String x = "";
    x = Arq.readAll();
    Arq.close();
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < x.length(); i++) {
            int aux = 0;
            aux = ((int) x.charAt(i) - 3);
            builder.append((char) aux);

    }
    System.out.println(builder.toString());
}
    public static void main(String[] args) {
        // escreverFrase();
        // lerPrintTela();
        // copiaCola();
        // charInversor();
        // cifraCesarLeitura();
        // cifraCesarDescrypto();
    }

    // método que limpa o buffer
    private static void clearBuffer(final Scanner scanner) {
        // se tem algo no buffer, faz um nextline puxando o quem la
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
    }

}