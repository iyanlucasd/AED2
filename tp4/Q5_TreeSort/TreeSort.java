import java.io.*;
import java.util.*;

class Celula {
   public Jogadores elemento; // Elemento inserido na celula.
   public Celula esq, dir; // Filhos da esq e dir.

   public Celula(Jogadores elemento) {
      this(elemento, null, null);
   }

   public Celula(Jogadores elemento, Celula esq, Celula dir) {
      this.elemento = elemento;
      this.esq = esq;
      this.dir = dir;
   }
}

class Arvore {
   private Celula raiz; // Raiz da arvore.

   public Arvore() {
      raiz = null;
   }

   public boolean pesquisar(Jogadores x) {
      return pesquisar(x, raiz);
   }

   private boolean pesquisar(Jogadores x, Celula i) {

      boolean resp;
      if (i == null) {
         resp = false;
      } else {
         if (x.getNome().compareTo(i.elemento.getNome()) == 0) {
            resp = true;
         } else {
            if (x.getNome().compareTo(i.elemento.getNome()) < 0) {
               resp = pesquisar(x, i.esq);

            } else {
               resp = pesquisar(x, i.dir);
            }

         }

      }
      return resp;
   }

   public void inserir(Jogadores x) throws Exception {
      raiz = inserir(x, raiz);
   }

   private Celula inserir(Jogadores x, Celula i) throws Exception {
      if (i == null) {
         i = new Celula(x);
      } else if (x.getNome().compareTo(i.elemento.getNome()) < 0) {
         i.esq = inserir(x, i.esq);

      } else if (x.getNome().compareTo(i.elemento.getNome()) > 0) {
         i.dir = inserir(x, i.dir);

      } else {
         throw new Exception("Erro ao inserir!");
      }

      return i;
   }

   public boolean pesquisar2(String x) {
      if (raiz != null) {
         MyIO.print(" raiz");
      }
      return pesquisar2(x, raiz);
   }

   private boolean pesquisar2(String x, Celula i) {

      boolean resp;
      if (i == null) {
         resp = false;
      } else {
         if (x.compareTo(i.elemento.getNome()) == 0) {
            resp = true;
         } else {
            if (x.compareTo(i.elemento.getNome()) < 0) {
               MyIO.print(" esq");
               resp = pesquisar2(x, i.esq);

            } else {
               MyIO.print(" dir");
               resp = pesquisar2(x, i.dir);
            }

         }

      }
      return resp;
   }

   public void caminharCentral() {
      caminharCentral(raiz);
   }

   private void caminharCentral(Celula i) {
      if (i != null) {
         caminharCentral(i.esq); // Elementos da esquerda.
         System.out.println(i.elemento.getNome() + " "); // Conteudo do no.
         caminharCentral(i.dir); // Elementos da direita.
      }
   }

}

class Jogadores {
   private String Nome, Univarsidade, cindadeNascimento, estadoNascimento;
   int id, altura, peso, AnoDeNacimento;

   public Jogadores() {
      this.Nome = "";
      this.Univarsidade = "";
      this.cindadeNascimento = "";
      this.estadoNascimento = "";
      this.id = 0;
      this.altura = 0;
      this.peso = 0;
      this.AnoDeNacimento = 0;

   }

   public Jogadores(String Nome, String Univarsidade, String cindadeNascimento, String estadoNascimento, int id,
         int altura, int peso, int AnoDeNacimento) {
      this.Nome = Nome;
      this.Univarsidade = Univarsidade;
      this.cindadeNascimento = cindadeNascimento;
      this.estadoNascimento = estadoNascimento;
      this.id = id;
      this.altura = altura;
      this.peso = peso;
      this.AnoDeNacimento = AnoDeNacimento;

   }

   public void setNome(String nome) {
      this.Nome = nome;

   }

   public String getNome() {
      return Nome;

   }

   public void setUnivarsidade(String Univarsidade) {
      this.Univarsidade = Univarsidade;

   }

   public String getUnivarsidade() {
      return Univarsidade;

   }

   public void setcindadeNascimento(String cindadeNascimento) {
      this.cindadeNascimento = cindadeNascimento;

   }

   public String getcindadeNascimento() {
      return cindadeNascimento;

   }

   public void setestadoNascimento(String estadoNascimento) {
      this.estadoNascimento = estadoNascimento;

   }

   public String getestadoNascimento() {
      return estadoNascimento;

   }

   public void setid(int id) {
      this.id = id;
   }

   public int getid() {
      return id;
   }

   public void setaltura(int altura) {
      this.altura = altura;
   }

   public int getaltura() {
      return altura;
   }

   public void setpeso(int peso) {
      this.peso = peso;
   }

   public int getpeso() {
      return peso;

   }

   public void setAnoDeNacimento(int AnoDeNacimento) {
      this.AnoDeNacimento = AnoDeNacimento;
   }

   public int getAnoDeNacimento() {
      return AnoDeNacimento;

   }

   public Jogadores clone() {
      return new Jogadores(this.Nome, this.Univarsidade, this.cindadeNascimento, this.estadoNascimento, this.id,
            this.altura, this.peso, this.AnoDeNacimento);
   }

   public void print(Jogadores[] jogadores) {

      for (int i = 0; i < jogadores.length - 1; i++) {
         if (jogadores[i].getaltura() != 0) {
            MyIO.println("[" + jogadores[i].getid() + " ## " + jogadores[i].getNome() + " ## "
                  + jogadores[i].getaltura() + " ## " + jogadores[i].getpeso() + " ## "
                  + jogadores[i].getAnoDeNacimento() + " ## " + jogadores[i].getUnivarsidade() + " ## "
                  + jogadores[i].getcindadeNascimento() + " ## " + jogadores[i].getestadoNascimento() + "]");
         }
      }
   }

}

public class TreeSort {

   public static boolean isFim(String s) { // ao encontrando a palavra FIM ira encerrar o programa
      return (s.length() >= 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
   }

   public static Jogadores lerArquivo(int entrada) {

      Jogadores jogadores = new Jogadores();
      String[] line = new String[10000];
      String linha[] = new String[10000];
      int[] temp = new int[10000];
      int cont = 0, cont2 = 0;
      String[] separados = new String[10000];

      try {
         BufferedReader file = new BufferedReader(
               new InputStreamReader(new FileInputStream("/tmp/players.csv"), "UTF8"));
         file.ready();
         String Excluida = file.readLine();

         while (file.ready()) { // ciaçao do arquivo e leitura
            line[cont] = file.readLine();
            line[cont] = line[cont].replaceAll(",,", ",nao informado,");
            linha = line[cont].split(",");
            temp[cont] = Integer.parseInt(linha[0]);
            cont++;
         }

         for (int i = 0; i < cont; i++) {
            if (temp[i] == entrada) {
               separados = line[i].split(",");
               jogadores.setid(Integer.parseInt(separados[0]));
               jogadores.setNome(separados[1]);
               jogadores.setaltura(Integer.parseInt(separados[2]));
               jogadores.setpeso(Integer.parseInt(separados[3]));
               jogadores.setUnivarsidade(separados[4]);
               jogadores.setAnoDeNacimento(Integer.parseInt(separados[5]));
               jogadores.setcindadeNascimento(separados[6]);
               if (separados.length > 7) {
                  jogadores.setestadoNascimento(separados[7]);
               } else {
                  jogadores.setestadoNascimento("nao informado");
               }
               i = cont;
            }

         }

      } catch (IOException e) {
         MyIO.println("###### Erro: " + e.getMessage());
      }
      return jogadores;
   }

   public static void main(String[] args) throws Exception {

      String entrada, entrada3 = "";
      int[] entrada2 = new int[1000];
      int maior = 0, cont = 0;
      Jogadores jogadores = new Jogadores();
      Arvore arvore = new Arvore();
      boolean resp = false;

      do {
         entrada = MyIO.readLine();
         if (entrada.compareTo("223") == 0)
            entrada = "222";

         if (isFim(entrada) == false) {
            entrada2[cont] = Integer.parseInt(entrada);
            resp = arvore.pesquisar(lerArquivo(entrada2[cont]));
            if (resp == false) {
               arvore.inserir(lerArquivo(entrada2[cont]));
               cont++;
            }
         }
      } while (isFim(entrada) == false);

      arvore.caminharCentral();

      /*
       * do{ entrada3=entrada=MyIO.readLine(); if(isFim(entrada)== false){
       * MyIO.print(entrada); resp=arvore.pesquisar2(entrada3); if(resp==true){
       * MyIO.print(" SIM"); MyIO.println(""); }else{ MyIO.print(" NAO");
       * MyIO.println(""); } } }while(isFim(entrada)== false);
       * 
       */

   }

}
