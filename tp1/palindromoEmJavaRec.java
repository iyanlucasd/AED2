import java.io.*;

public class palindromoEmJavaRec {
    /**
     * @method palindromoIterativo verifica se é palindromo ou não
     * @param s string do pub.in
     * @param count 0, conta a quantidade de iguais
     * @param tam 0, conta a quantidade de chamadas recursiva
     * @return bool true/false
     */
    public static boolean palindromoRec(String s, int count, int tam) {
        boolean simNao = true;
        if (tam < (s.length() / 2)) {
            if (s.charAt(tam) == s.charAt(s.length() - tam - 1)) {
                return palindromoRec(s, count + 1, tam + 1);
            } else {
                return palindromoRec(s, count, tam + 1);
            }
        } else {
            if (count == s.length() / 2) {
                simNao = true;
            } else {
                simNao = false;
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
            if (palindromoRec(s[i], 0, 0) == true) {
                System.out.println("SIM");
            } else {
                System.out.println("NAO");
            }
            i++;
            s[i] = br.readLine();
        }

    }
}
