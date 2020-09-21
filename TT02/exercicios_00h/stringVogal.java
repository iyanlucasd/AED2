package exercicios_00h;

import java.util.*;

public class stringVogal {

    public static int isVogal(String s, int tam, int vogalQuantidade) {
        if (tam >= 0) {
            if (s.charAt(tam) == 'A' || s.charAt(tam) == 'E' || s.charAt(tam) == 'I' || s.charAt(tam) == 'O'
                    || s.charAt(tam) == 'U') {
                return isVogal(s, tam - 1, vogalQuantidade + 1);
            } else {
                return isVogal(s, tam - 1, vogalQuantidade);
            }
        }
        return vogalQuantidade;
    }

    public static void main(String[] args) {
        int vogalQuantidade = 0;
        String s = "";
        Scanner imput = new Scanner(System.in);
        s = imput.nextLine();
        int lengh = s.length();
        System.out.println(isVogal(s.toUpperCase(), lengh - 1, 0));
    }
}