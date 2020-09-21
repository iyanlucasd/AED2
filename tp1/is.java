import java.io.*;

public class is {
    /**
     * @method isVogal verifica se a string é só vogal ou não
     * @param x string do pub.in
     * @return sim/nao
     */
    public static String isVogal(String x) {
        String s = x.toUpperCase();
        boolean simNao = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A' || s.charAt(i) == 'O' || s.charAt(i) == 'I' || s.charAt(i) == 'E'
                    || s.charAt(i) == 'U') {
                simNao = true;
            } else {
                simNao = false;
                i = s.length();
            }
        }
        if (simNao == true) {
            return "SIM";
        } else {
            return "NAO";
        }
    }

    /**
     * @method isCons verifica se a string é só consoante ou não
     * @param x string do pub.in
     * @return sim/nao
     */
    public static String isCons(String x) {
        String s = x.toUpperCase();
        boolean simNao = false;
        for (int i = 0; i < s.length(); i++) {
            if ((int) s.charAt(i) > 64 && (int) s.charAt(i) < 91) {
                if ((s.charAt(i) == 'A' || s.charAt(i) == 'O' || s.charAt(i) == 'I' || s.charAt(i) == 'E'
                        || s.charAt(i) == 'U')) {
                    simNao = false;
                    i = s.length();
                } else {
                    simNao = true;
                }
            }
        }
        if (simNao == true) {
            return "SIM";
        } else {
            return "NAO";
        }
    }

    /**
     * @method isInt verifica se a string é só inteiro ou não
     * @param x string do pub.in
     * @return sim/nao
     */
    public static String isInt(String x) {
        String s = x.toUpperCase();
        boolean simNao = false;
        for (int i = 0; i < s.length(); i++) {
            if ((int) s.charAt(i) > 47 && (int) s.charAt(i) < 58) {
                simNao = true;
            } else {
                simNao = false;
                i = s.length();
            }
        }
        if (simNao == true) {
            return "SIM";
        } else {
            return "NAO";
        }
    }

    /**
     * @method isFloat verifica se a string é só float ou não
     * @param x string do pub.in
     * @return sim/nao
     */
    public static String isFloat(String x) {
        String s = x.toUpperCase();
        boolean simNao = false;
        for (int i = 0; i < s.length(); i++) {
            if ((int) s.charAt(i) > 47 && (int) s.charAt(i) < 58 || (int) s.charAt(i) == 44) {
                simNao = true;
            } else {
                simNao = false;
                i = s.length();
            }
        }
        if (simNao == true) {
            return "SIM";
        } else {
            return "NAO";
        }
    }

    /**
     * @method main verifica se é fim, recebe as entradas e chamas as funções
     * @param args recebe da execução
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        /**
         * variáveis: bufferReader para ler entradas array de string para receber todas
         * as entradas o pub.in flag para parar o laço contador
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in, "ISO-8859-1"));
        String[] s = new String[1000];
        boolean flag = true;
        int i = 0;
        while (flag == true) {
            s[i] = br.readLine();
            if (s[i].equals("FIM")) {
                flag = false;
            } else {
                System.out.print(isVogal(s[i]) + " ");
                System.out.print(isCons(s[i]) + " ");
                System.out.print(isInt(s[i]) + " ");
                System.out.println(isFloat(s[i]));
                i++;
            }
        }
    }
}