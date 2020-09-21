package exercicios_00h;

import java.io.*;
import java.util.*;

public class multiplicacaoRecursiva {
    public static int multiplicacao(int x, int y, int z) {
        if (y > 0) {
            return multiplicacao(x + z, y - 1, z);
        }
        return x - z;
    }

    public static int arrayRecursivo(int[] array, int tam, int maior) {
        if (tam >= 0) {
            if (maior < array[tam]) {
                maior = array[tam];
                return arrayRecursivo(array, tam - 1, maior);
            }
        }

        return maior;
    }

    public static boolean isPalindromo(String s, int i) {
        boolean resp;
        if (i >= s.length() / 2) {
            resp = true;
        } else if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
            resp = false;
        } else {
            resp = isPalindromo(s, i + 1);
        }
        return resp;
    }

    public static void arraySortRecursivo(int[] array, int i, int j) {
        int aux = 0;
        int count = 0;
        while (count < j) {
            if (array[i] < array[i - 1]) {
                
            }
        }
    }

    public static void main(final String[] args) {
        Scanner input = new Scanner(System.in);
        // int x = input.nextInt();
        // int y = input.nextInt();
        int[] array = new int[5];
        // String s = input.nextLine();
        for (int i = 0; i < array.length; i++) {
            array[i] = input.nextInt();
        }
        // // System.out.println(multiplicacao(x, y, x));
        // System.out.println(arrayRecursivo(array, array.length - 1, 0));
        // System.out.println(isPalindromo(s, 0));
    }
}