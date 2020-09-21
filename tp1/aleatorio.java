import java.io.*;
import java.util.*;

public class aleatorio {
    /**
     * @method trocaAleatoria troca a letra recebida por outra em uma string
     * @param c letra alvo
     * @param d letra da troca
     * @param s string para troca das letras
     * @return string com as letras trocadas
     */

    public static String trcaAleatoria(char c, char d, String s) {
        String aux = "";
        /**
         * for que corre a string até o final
         * se for a letra, a string recebe a letra trocada
         * se não recebe a letra original
         */
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                aux += d;
            } else {
                aux += s.charAt(i);
            }
        }
        return aux;

    }//fim trocaAleatoria
    /**
     * @method main gera uma letra a partir da seed, recebe as strings e chama os métodos
     * @throws IOExceptions
     * @param args recebe da execução
     */
    public static void main(String[] args) throws IOException {
        //metodo random passado no enunciado
        Random gerador = new Random();
        gerador.setSeed(4);
        char c = (char) ('a' + (Math.abs(gerador.nextInt()) % 26));
        char troca = (char) ('a' + (Math.abs(gerador.nextInt()) % 26)); 
        /**
         * variáveis:
         * bufferReader para ler entradas
         * array de string para receber todas as entradas o pub.in
         * flag para parar o laço
         * contador
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in, "UTF-8"));
        String[] s = new String[1000];
        boolean flag = true;
        int i = 0;
        while (flag == true) {
            s[i] = br.readLine();
            if (s[i].equals("FIM")) {
                flag = false;
            } else {

                MyIO.println(trcaAleatoria(c, troca, s[i]));
                i++;
            }
        }
    }//fim main
}//fim classe aleatório