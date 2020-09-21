package exercicios_00b;

import java.util.Scanner;

public class ex1 {

    public static boolean estaContido(final int[] array) {
        final Scanner input = new Scanner(System.in);
        System.out.println("digite o numero para procurar\n");
        int x = 0;
        int count = 0;
        x = input.nextInt();
        for (int i = 0; i < 10; i++) {
            if (x == array[i]) {
                count++;
            }
        }
        if (count > 0) {

            return true;
        } else {
            return false;
        }

    }

    public static boolean estaContidoResumido(final int[] array) {
        final Scanner input = new Scanner(System.in);
        System.out.println("digite o numero para procurar\n");
        int x = 0;
        int count = 0;
        x = input.nextInt();
        if (x > array[4]) {
            for (int i = 4; i < 10; i++) {
                if (x == array[i]) {
                    count++;
                }
            }
            if (count > 0) {

                return true;
            } else {
                return false;
            }
        } else {
            for (int i = 0; i < 5; i++) {
                if (x == array[i]) {
                    count++;
                }
            }
            if (count > 0) {

                return true;
            } else {
                return false;
            }
        }

    }

    public static void main(final String[] args) {
        final Scanner input = new Scanner(System.in);
        final int[] array = new int[10];

        for (int i = 0; i < 10; i++) {
            array[i] = input.nextInt();
        }
        if (estaContido(array) == true) {
            System.out.println("o numero esta contido");
        } else {
            System.out.println("o numero nao esta contido");

        }
    }

}