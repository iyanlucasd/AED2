import java.io.*;

public class cifraDeCesar {
    /**
     * @method cifraCesarLeitura transforma o char em int (ASCII) e adiciona a cifra
     * @param x string não mudada
     * @return string com cifra
     */
    public static String cifraCesarLeitura(String x) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < x.length(); i++) {
            int aux = 0;
            aux = ((int) x.charAt(i) + 3);
            builder.append((char) aux);
        }
        return builder.toString();
    }

    /**
     * @method main recebe o numero das entradas e chama as funções
     * @param args recebido da execução
     * @exception IOException
     */
    public static void main(String[] args) throws IOException {
        /**
         * variáveis: bufferReader para ler entradas array de string para receber todas
         * as entradas o pub.in flag para parar o laço contador
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = new String[1000];
        boolean flag = true;
        int i = 0;
        while (flag == true) {
            s[i] = br.readLine();
            if (s[i].equals("FIM")) {
                flag = false;
            } else {
                System.out.println(cifraCesarLeitura(s[i]));
                i++;
            }
        }
    }// fim main
}// fim cifraDeCesar