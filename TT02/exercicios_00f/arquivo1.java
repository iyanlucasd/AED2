package exercicios_00f;

import java.util.Scanner;

public class arquivo1 {

    /**
     * opa, bão? eu ja programava em java antes e nunca soube desse Arq, muito
     * obrigado por facilitar a minha vida :) brinquei com o código abração, iyan
     */

    public static void exemploArq01Escrita() {
        Arq.openWrite("exemplo.txt");
        Arq.println(1);
        Arq.println(5.3);
        Arq.println('X');
        Arq.println(true);
        Arq.println("Algoritmos");
        Arq.close();
    }

    public static void exemploArq02Leitura() {
        Arq.openRead("exemplo.txt");
        final int inteiro = Arq.readInt();
        final double real = Arq.readDouble();
        final char caractere = Arq.readChar();
        final boolean boleano = Arq.readBoolean();
        final String str = Arq.readString();
        Arq.close();
        System.out.println("inteiro: " + inteiro);
        System.out.println("real: " + real);
        System.out.println("caractere: " + caractere);
        System.out.println("boleano: " + boleano);
        System.out.println("str: " + str);
    }

    public static void main(final String[] args) {
        final Scanner input = new Scanner(System.in);
        exemploArq01Escrita();
        exemploArq02Leitura();
    }
}