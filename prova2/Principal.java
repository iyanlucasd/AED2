import java.io.*;
import java.util.Scanner;

class Principal {

   public static Matriz[] array = new Matriz[1024];
   public static int countGlobal = 0;

   public static void inserirMatriz(int[][] matrix, int linha, int coluna) {
      array[countGlobal] = new Matriz(linha, coluna);
      int numero = 0;
      for (int i = 0; i < linha; i++) {
         for (int j = 0; j < coluna; j++) {
            System.out.print(matrix[i][j]);
         }
         System.out.println();
      }
      // for (int i = 0; i < linha; i++) {
      // for (int j = 0; j < coluna; j++) {
      // numero = matrix[i][j];
      // array[countGlobal].inserir(numero);
      // }
      // }

   }

   private static int campoMinado(int[][] mat, int i, int j) {
      int p = 0;
      int l = mat.length - 1;
      int c = mat[i].length - 1;
      if (i > 0 && mat[i - 1][j] == 1)
         p++;
      if (i < l && mat[i + 1][j] == 1)
         p++;
      if (j > 0 && mat[i][j - 1] == 1)
         p++;
      if (j < c && mat[i][j + 1] == 1)
         p++;
      return p;
   }

   public static void tratamentoMatriz(String[] arrayString, int linha, int coluna, int at, int count)
         throws IOException {
      int[][] matrix = new int[linha][coluna];
      int[][] resposta = new int[linha][coluna];
      int count2 = 0;
      for (int i = 0; i < linha && at < count; i++, at++) {
         // System.out.println(arrayString[i]);
         for (int j = 0; j < coluna; j++) {
            if (arrayString[at].charAt(j) == '0') {
               // System.out.println("chegou1");
               matrix[i][count2] = 0;
               count2++;
            } else if (arrayString[at].charAt(j) == '1') {
               // System.out.println("chegou2");
               matrix[i][count2] = 1;
               count2++;
            }
         }
         count2 = 0;
      }
      for (int i = 0; i < linha; i++) {
         for (int j = 0; j < coluna; j++) {
            if (matrix[i][j] == 1)
               resposta[i][j] = 9;
            else
               resposta[i][j] = (campoMinado(matrix, i, j));
         }
      }

      inserirMatriz(resposta, linha, coluna);

   }

   public static void tratamento(String n, String[] arrayString, int at, int count) throws IOException {
      String[] nSplit = n.split(" ");
      int linha = Integer.parseInt(nSplit[0]);
      int coluna = Integer.parseInt(nSplit[1]);
      // System.out.println(nSplit[0]);
      // System.out.println(nSplit[1]);
      for (int i = at; i < count; i++) {
         // System.out.println(arrayString[i]);
      }
      System.out.println("--------------");
      tratamentoMatriz(arrayString, linha, coluna, at, count);
      // array[countGlobal].mostrar();
   }

   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in, "ISO-8859-1"));

      // 4 4
      // 0 0 1 1
      // 0 1 0 1
      // 0 0 1 0
      // 1 1 0 1

      // 0299
      // 1949
      // 1393
      // 9939

      String n = br.readLine();
      String[] nSplit = n.split(" ");
      int num = Integer.parseInt(nSplit[0]);
      String arrayString[] = new String[1000];
      int count = 0;
      // System.out.println(n);
      for (; count < num; count++) {
         arrayString[count] = br.readLine();
         // System.out.println(arrayString[count]);
      }
      tratamento(n, arrayString, 0, count);
      int at = count;
      while (n.equals("FIM") == false) {
         n = br.readLine();
         System.out.println(n);
         if (condition) {
            
         }
         // System.out.println(arrayStr/ing[count]);
         // tratamento(n, arrayString);
         nSplit = n.split(" ");
         num = Integer.parseInt(nSplit[0]);
         for (int i = at; i < num; i++, count++) {
            arrayString[count] = br.readLine();
         }
         // System.out.println(arrayString[count]);
         tratamento(n, arrayString, at, count);
         at = count;
      }
   }

   // array[countGlobal].mostrar();
}
