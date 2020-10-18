import java.io.*;

class Jogador {
    public static Jogador[] array = new Jogador[1024];
    public static int countGlobal = 0;

    // variaveis
    private int id = 0;
    private String nome = "";
    private int altura = 0;
    private int peso = 0;
    private String universidade = "";
    private String anoNascimento = "";
    private String cidadeNascimento = "";
    private String estadoNascimento = "";

    // construtores
    public Jogador() {
        this.id = 0;
        this.nome = "";
        this.altura = 0;
        this.peso = 0;
        this.universidade = "";
        this.anoNascimento = "";
        this.cidadeNascimento = "";
        this.estadoNascimento = "";
    }

    public Jogador(int id, String nome, int altura, int peso, String universidade, String anoNascimento,
            String cidadeNascimento, String estadoNascimento) {
        this.id = 0;
        this.nome = "";
        this.altura = 0;
        this.peso = 0;
        this.universidade = "";
        this.anoNascimento = "";
        this.cidadeNascimento = "";
        this.estadoNascimento = "";
    }

    // set
    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public void setUniversidade(String universidade) {
        this.universidade = universidade;
    }

    public void setAnoNascimento(String anoNascimento) {
        this.anoNascimento = anoNascimento;
    }

    public void setCidadeNascimento(String cidadeNascimento) {
        this.cidadeNascimento = cidadeNascimento;
    }

    public void setEstadoNascimento(String estadoNascimento) {
        this.estadoNascimento = estadoNascimento;
    }

    // get
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getAltura() {
        return altura;
    }

    public int getPeso() {
        return peso;
    }

    public String getUniversidade() {
        return universidade;
    }

    public String getAnoNascimento() {
        return anoNascimento;
    }

    public String getCidadeNascimento() {
        return cidadeNascimento;
    }

    public String getEstadoNascimento() {
        return estadoNascimento;
    }

    // clone
    protected Jogador clone() {
        Jogador clone = new Jogador(this.id, this.nome, this.altura, this.peso, this.universidade, this.anoNascimento,
                this.cidadeNascimento, this.estadoNascimento);
        return clone;
    }

    // imprimir
    public void imprimir() {
        System.out.print("[");
        System.out.print(getId());
        System.out.print(" ## ");
        System.out.print(getNome());
        System.out.print(" ## ");
        System.out.print(getAltura());
        System.out.print(" ## ");
        System.out.print(getPeso());
        System.out.print(" ## ");
        System.out.print(getAnoNascimento());
        System.out.print(" ## ");
        System.out.print(getUniversidade());
        System.out.print(" ## ");
        System.out.print(getCidadeNascimento());
        System.out.print(" ## ");
        System.out.print(getEstadoNascimento());
        System.out.println("]");
    }

    public void tratamento(String s) {
        s = s.replaceAll(",,", ",nao informado,");
        int aux = s.length();
        if (s.charAt(aux - 1) == ',') {
            s += "nao informado";
        }

        String[] sSplit = s.split(",");
        if (sSplit[0] != null) {
            int ID = Integer.parseInt(sSplit[0]);
            array[countGlobal].setId(ID);
            array[countGlobal].setNome(sSplit[1]);
            int height = Integer.parseInt(sSplit[2]);
            array[countGlobal].setAltura(height);
            int weight = Integer.parseInt(sSplit[3]);
            array[countGlobal].setPeso(weight);
            array[countGlobal].setUniversidade(sSplit[4]);
            array[countGlobal].setAnoNascimento(sSplit[5]);
            array[countGlobal].setCidadeNascimento(sSplit[6]);
            array[countGlobal].setEstadoNascimento(sSplit[7]);
        }

    }

    public void ler(String id) throws Exception {
        String s = "";
        BufferedReader file = new BufferedReader(
                new InputStreamReader(new FileInputStream("/tmp/players.csv"), "UTF8"));

        s = file.readLine();
        while (s != null) {
            String[] sSplit = s.split(",");
            if (sSplit[0].equals(id) == true) {
                tratamento(s);
            } else if ((sSplit[0].equals("222") && id.equals("223"))) {
                tratamento(s);
            }
            s = file.readLine();
        }

    }

}

public class exHeap extends Jogador {
    // 0,Curly Armstrong,180,77,Indiana University,1918,,
    // 93,Wah Wah,180,77,,1921,,

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
        if (l < n){ 
          if( array[l].getAltura() > array[largest].getAltura()  ){ 
          largest = l;
      }
       if(array[r].getAltura() == array[largest].getAltura()&& array[r].getNome().compareTo(array[largest].getNome()) > 0){
        largest = l;
       }
    }
        // if right child is larger than largest so far
        if (r < n) {
          if (array[r].getAltura() > array[largest].getAltura()) {
    
            largest = r;
          }
          if (array[r].getAltura() == array[largest].getAltura()&& array[r].getNome().compareTo(array[largest].getNome()) > 0) {
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

    public static void main(String[] args) throws Exception {
        String[] arrayID = new String[3922];
        int i = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in, "ISO-8859-1"));
        arrayID[i] = br.readLine();
        while (arrayID[i].equals("FIM") == false) {
            i++;
            arrayID[i] = br.readLine();
        }

        while (countGlobal < i) {
            array[countGlobal] = new Jogador();
            array[countGlobal].ler(arrayID[countGlobal]);
            // array[countGlobal].imprimir();
            countGlobal++;
        }

        sort();
        sort();

        i = 0;
        while (i < countGlobal) {
            array[i].imprimir();
            i++;

        }

    }
}
