import java.io.*;

public class palindromoEmJava {
    /**
     * @method palindromoIterativo verifica se é palindromo ou não
     * @param s string do pub.in
     * @return bool true/false
     */
    public static boolean palindromoIterativo(String s) {
        boolean simNao = false;
        for (int i = 0; i < (s.length()); i++) {
            if (s.charAt(i) == s.charAt(s.length() - i - 1)) {
                simNao = true;
            } else {
                simNao = false;
                i = s.length();
            }
        }

        return simNao;
    }

    /**
     * @method main verifica se é FIM, recebe as entradas do pub.in e chama as
     *         funções
     * @param args recebido na execução
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        /**
         * variáveis: bufferReader para ler entradas array de string para receber todas
         * as entradas o pub.in flag para parar o laço contador
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in, "ISO-8859-1"));
        String[] s = new String[1000];
        int i = 0;
        s[i] = br.readLine();
        while (s[i].equals("FIM") == false) {
            if (palindromoIterativo(s[i]) == true) {
                System.out.println("SIM");
            } else {
                System.out.println("NAO");
            }
            i++;
            s[i] = br.readLine();
        }

    }
}