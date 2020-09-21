package exercicios_00f;

import java.io.*;
import java.util.Formatter;
import java.util.Scanner;
import java.io.File;
import java.nio.charset.*;

public class Arq
{
   private static String nomeArquivo = "";
   private static String charsetArquivo = "ISO-8859-1";
   private static boolean write = false, read = false;
   private static Formatter saida = null;
   private static Scanner entrada = null;

	public static boolean openWrite(final String nomeArq, final String charset) {
       boolean resp = false;
       close();
       try {
          saida = new Formatter(nomeArq, charset);
          nomeArquivo = nomeArq;
          resp = write = true;
       } catch (final Exception e) {
       }
       return resp;
    }

    public static boolean openWrite(final String nomeArq) {
       return openWrite(nomeArq, charsetArquivo);
    }

    public static boolean openWriteClose(final String nomeArq, final String charset, final String conteudo) {
       final boolean resp = openWrite(nomeArq, charset);
       if (resp == true) {
          println(conteudo);
          close();
       }
       return resp;
    }

    public static boolean openWriteClose(final String nomeArq, final String conteudo) {
       return openWriteClose(nomeArq, charsetArquivo, conteudo);
    }

    public static boolean openRead(final String nomeArq) {
       return openRead(nomeArq, charsetArquivo);
    }

    public static boolean openRead(final String nomeArq, final String charset) {
       boolean resp = false;
       close();
       try {
          entrada = new Scanner(new File(nomeArq), charset);
          nomeArquivo = nomeArq;
          resp = read = true;
       } catch (final Exception e) {
       }
       return resp;
    }

    public static String openReadClose(final String nomeArq) {
       openRead(nomeArq);
       final String resp = readAll();
       close();
       return resp;
    }

    public static void close() {
       if (write == true) {
          saida.close();
       }
       if (read == true) {
          entrada.close();
       }
       write = read = false;
       nomeArquivo = "";
       charsetArquivo = "ISO-8859-1";
    }

    public static long length() {
       long resp = -1;
       if (read != write) {
          final File file = new File(nomeArquivo);
          resp = file.length();
       }
       return resp;
    }

    public static void print(final int x) {
       if (write == true) {
          saida.format("%d", x);
       }
    }

    public static void print(final double x) {
       if (write == true) {
          saida.format("%f", x);
       }
    }

    public static void print(final String x) {
       if (write == true) {
          saida.format("%s", x);
       }
    }

    public static void print(final boolean x) {
       if (write == true) {
          saida.format("%s", ((x) ? "true" : "false"));
       }
    }

    public static void print(final char x) {
       if (write == true) {
          saida.format("%c", x);
       }
    }

    public static void println(final int x) {
       if (write == true) {
          saida.format("%d\n", x);
       }
    }

    public static void println(final double x) {
       if (write == true) {
          saida.format("%f\n", x);
       }
    }

    public static void println(final String x) {
       if (write == true) {
          saida.format("%s\n", x);
       }
    }

    public static void println(final boolean x) {
       if (write == true) {
          saida.format("%s\n", ((x) ? "true" : "false"));
       }
    }

    public static void println(final char x) {
       if (write == true) {
          saida.format("%c\n", x);
       }
    }

    public static int readInt() {
       int resp = -1;
       try {
          resp = entrada.nextInt();
       } catch (final Exception e) {
       }
       return resp;
    }

    public static char readChar() {
       char resp = ' ';
       try {
          resp = (char) entrada.nextByte();
       } catch (final Exception e) {
       }
       return resp;
    }

    public static double readDouble() {
       double resp = -1;
       try {
          resp = Double.parseDouble(readString().replace(",", "."));
       } catch (final Exception e) {
       }
       return resp;
    }

    public static String readString() {
       String resp = "";
       try {
          resp = entrada.next();
       } catch (final Exception e) {
          System.out.println(e.getMessage());
       }
       return resp;
    }

    public static boolean readBoolean() {
       boolean resp = false;
       try {
          resp = (entrada.next().equals("true")) ? true : false;
       } catch (final Exception e) {
       }
       return resp;
    }

    public static String readLine() {
       String resp = "";
       try {
          resp = entrada.nextLine();
       } catch (final Exception e) {
          System.out.println(e.getMessage());
       }
      return resp;
	}


   public static boolean hasNext(){
      return entrada.hasNext();
   }

   public static String readAll(){
      String resp = "";
      while(hasNext()){
         resp += (readLine() + "\n");
      }
      return resp;
   }
}
