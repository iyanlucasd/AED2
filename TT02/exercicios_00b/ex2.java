package exercicios_00b;

import java.util.Scanner;

public class ex2 {

    public static void estaContido(int[] array) {
        int maior = array[0];
        int menor = maior;
        for (int i = 1; i < 10; i++) {
            if (maior < array[i]) {
                maior = array[i];
            } else {
                if (menor > array[i]) {
                    menor = array[i];
                }
            }
        }
        System.out.println("maior = " + maior + "\n menor = " + menor);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] array = new int[10];

        for (int i = 0; i < 10; i++) {
            array[i] = input.nextInt();
        }
        estaContido(array);
    }

}