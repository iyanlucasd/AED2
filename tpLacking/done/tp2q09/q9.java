import java.io.*;
import java.util.*;

class Jogador {
  private int id;
  private String universidade;
  private int altura;
  private String nome;
  private int peso;
  private String cidadeNascimento;
  private int anoNascimento;
  private String estadoNacimento;

  public Jogador() {
    id = 0;
    altura = 0;
    peso = 0;
    anoNascimento = 0;
    nome = "";
    universidade = "";
    cidadeNascimento = "";
    estadoNacimento = "";
  } // end construtor padrao

  public void setId(int id) {
    this.id = id;
  } // end setId

  public int getId() {
    return id;
  } // end getId

  public void setAltura(int altura) {
    this.altura = altura;
  } // end setAltura

  public int getAltura() {
    return altura;
  } // end getAltura

  public void setPeso(int peso) {
    this.peso = peso;
  } // end setPesoo

  public int getPeso() {
    return peso;
  } // end getPeso

  public void setAnoNascimento(int anoNascimento) {
    this.anoNascimento = anoNascimento;
  } // end setAnoNascimento

  public int getAnoNascimento() {
    return anoNascimento;
  } // end getAnoNascimento

  public void setNome(String nome) {
    this.nome = nome;
  } // end setNome

  public String getNome() {
    return nome;
  } // end getNome

  public void setUniversidade(String universidade) {
    this.universidade = universidade;
  } // end setUniversidade

  public String getUniversidade() {
    return universidade;
  } // end getUniversidade

  public void setCidadeNascimento(String cidadeNascimento) {
    this.cidadeNascimento = cidadeNascimento;
  } // end setCidadeNascimento

  public String getCidadeNascimento() {
    return cidadeNascimento;
  } // end GetCidadeNascimento

  public void setEstadoDeNascimento(String estadoNascimento) {
    this.estadoNacimento = estadoNascimento;
  } // end setEstadoDeNascimento

  public String getEstadoDeNascimento() {
    return estadoNacimento;
  } // end setEstadoDeNascimento
} // class objeto

public class q9 {
  public static Jogador[] array = new Jogador[1024];
  public static int countGlobal = 0;

  public static void swap(int i, int j) {
    Jogador tmp = array[i];
    array[i] = array[j];
    array[j] = tmp;

  }

  public static void heapify(int n, int i) {
    int largest = i;
    int l = 2 * i + 1;
    int r = 2 * i + 2;

    // if left child is larger than root
    if (l < n) {
      if (array[l].getAltura() > array[largest].getAltura()) {
        largest = l;
      }
      if (array[r].getAltura() == array[largest].getAltura()
          && array[r].getNome().compareTo(array[largest].getNome()) > 0) {
        largest = l;
      }
    }
    // if right child is larger than largest so far
    if (r < n) {
      if (array[r].getAltura() > array[largest].getAltura()) {

        largest = r;
      }
      if (array[r].getAltura() == array[largest].getAltura()
          && array[r].getNome().compareTo(array[largest].getNome()) > 0) {
        largest = r;

      }
    }

    // if largest is not root
    if (largest != i) {
      swap(i, largest);

      // recursively heapify the affected sub-tree
      heapify(n, largest);
    }
  }

  public static void sort() {
    // build heap (rearrange array)
    for (int i = countGlobal / 2 - 1; i >= 0; i--)
      heapify(countGlobal, i);

    // one by one extract an element from heap
    for (int i = countGlobal - 1; i >= 0; i--) {
      // move current root to end
      swap(0, i);

      // call max heapify on the reduced heap
      heapify(i, 0);
    }
  }

  public static void showAndTell() {
    for (int i = 0; i < countGlobal; i++) {
      System.out.println("[" + array[i].getId() + " ## " + array[i].getNome() + " ## " + array[i].getAltura() + " ## "
          + array[i].getPeso() + " ## " + array[i].getAnoNascimento() + " ## " + array[i].getUniversidade() + " ## "
          + array[i].getCidadeNascimento() + " ## " + array[i].getEstadoDeNascimento() + "]");
    } // end showAndTell
  }

  public static void tratamentoString(String s) throws Exception {
    int tam = s.length();
    if (s.charAt(tam - 1) == ',')
      s = s + "nao informado";
    s = s.replaceAll(",,", ",nao informado,");
    String vetor[] = s.split(",");

    int id = Integer.parseInt(vetor[0]);
    array[countGlobal].setId(id);

    array[countGlobal].setNome(vetor[1]);

    int altura = Integer.parseInt(vetor[2]);
    array[countGlobal].setAltura(altura);

    int peso = Integer.parseInt(vetor[3]);
    array[countGlobal].setPeso(peso);

    array[countGlobal].setUniversidade(vetor[4]);

    int anoNascimento = Integer.parseInt(vetor[5]);
    array[countGlobal].setAnoNascimento(anoNascimento);

    array[countGlobal].setCidadeNascimento(vetor[6]);

    array[countGlobal].setEstadoDeNascimento(vetor[7]);
  } // end tratamentoString

  public static String readArqueivo(String arrayID) throws Exception {
    String linha = "";
    BufferedReader file = new BufferedReader(new InputStreamReader(new FileInputStream("/tmp/players.csv")));

    linha = file.readLine();
    while (linha != null) {
      String[] id = linha.split(",");
      if (id[0].equals(arrayID) == true)
        return linha;
      linha = file.readLine();
    } // end while
    String s = "";

    return s;
  } // end readArqueivo

  public static void main(String[] args) throws Exception {
    String arrayID = "";
    BufferedReader leitor = new BufferedReader(new InputStreamReader(System.in));

    arrayID = leitor.readLine();

    while (arrayID.equals("FIM") != true) {
      array[countGlobal] = new Jogador();
      tratamentoString(readArqueivo(arrayID));
      countGlobal++;
      arrayID = leitor.readLine();
    } // end while

    sort();
    sort();
    showAndTell();
  } // end main
} // class
