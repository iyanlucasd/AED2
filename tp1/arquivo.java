import java.io.*;
import java.util.*;

//função para eu debuggar ;-;
public class arquivo {
    public static void debugg(String s) {
        System.out.println("debugg " + s);
    }

    /**
     * @method função que abre o arquivo em modo de escrita e leitura escreve todas
     *         as entradas no file fecha o arquivo.
     * @param n numero de entradas
     * @param d double para escrita no arquivo
     */
    public static void saveArquivo(int n, double d) throws Exception {
        RandomAccessFile raf = new RandomAccessFile("exemplo.txt", "rw");
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            d = MyIO.readDouble();
            raf.writeDouble(d);
        }

        raf.close();
    } // fim save arquivo

    /**
     * @method printaContrario função que abre o arquivo em leitura binaria e vai
     *         pro final do arquivo le as entradas e printa na tela fecha o arquivo.
     * @param numero numero de entradas
     * @param d      doubles para escrever no arquivo
     */
    public static void printArquivo(int n) throws Exception {
        RandomAccessFile raf = new RandomAccessFile("exemplo.txt", "rw");
        int i = 0;
        double d = 0.00;
        /**
         * for que percorre o arquivo seek vai para n -1 multiplicado pelo numero de
         * bytes de um double dessa forma vai para uma nova linha mesmo que com números
         * de tamanhos diferentes lê o numero se o número tiver o mesmo tamanho de uma
         * long, printa como double se não printa como inteiro
         */
        for (int j = 0; j < n; n--) {
            raf.seek((n - 1) * 8);
            d = raf.readDouble();
            i = (int) d;
            if (d == (long) d)

                MyIO.println(i);
            else {
                MyIO.println(d);

            }
        }

        raf.close();
    }// fim print arquivo

    /**
     * @method main recebe o numero das entradas e chama as funções
     * @param args recebido da execução
     */
    public static void main(final String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        int n = 0;
        n = MyIO.readInt();
        double d = 0.0;
        saveArquivo(n, d);
        printArquivo(n);
    }// fim main
}// fim arquivo