import java.io.*;
import java.util.*;

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

    // 0,Curly Armstrong,180,77,Indiana University,1918,,
    // 93,Wah Wah,180,77,,1921,,
    public static void swap(int i, int j) {
        Jogador temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void sort(int esq, int dir) {
        int i = esq, j = dir;
        Jogador pivo = array[(dir + esq) / 2];
        while (i <= j) {
            while (array[i].getEstadoNascimento().compareTo(pivo.getEstadoNascimento()) < 0
                    || array[i].getEstadoNascimento().compareTo(pivo.getEstadoNascimento()) == 0
                            && array[i].getNome().compareTo(pivo.getNome()) < 0)
                i++;
            while (array[j].getEstadoNascimento().compareTo(pivo.getEstadoNascimento()) > 0
                    || array[j].getEstadoNascimento().compareTo(pivo.getEstadoNascimento()) == 0
                            && array[j].getNome().compareTo(pivo.getNome()) > 0)

                j--;
            if (i <= j) {
                swap(i, j);
                i++;
                j--;
            }
        }
        if (esq < j)
            sort(esq, j);
        if (i < dir) {
            sort(i, dir);
        }
    }

    public static void desempate(int n) {

        Jogador temp;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (array[i].getEstadoNascimento().compareTo(array[j].getEstadoNascimento()) == 0) {
                    if (array[i].getNome().compareTo(array[j].getNome()) > 0) {
                        temp = array[i];
                        array[i] = array[j];
                        array[j] = temp;
                    }
                } else {
                    j = n;
                }
            }
        }
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
            }
            s = file.readLine();
        }
    }
}

public class listaFlexquick extends Jogador {

    public static Jogador pesquisar(String key) throws Exception {
        array[countGlobal] = new Jogador();
        array[countGlobal].ler(key);
        // array[countGlobal].imprimir();
        countGlobal++;
        // achei.imprimir();
        return array[countGlobal - 1];
    }

    public static void tratamentoOps(ListaDupla listaFlex, String arrayOps) throws Exception {
        String[] sOpsSplit = new String[3];
        sOpsSplit = arrayOps.split(" ");
        if (sOpsSplit[0].charAt(1) == '*') {
            // System.out.println("1");
            if (sOpsSplit[0].charAt(0) == 'I') {
                int pos = Integer.parseInt(sOpsSplit[1]);
                listaFlex.inserir(pesquisar(sOpsSplit[2]), pos);
            } else {
                int key = Integer.parseInt(sOpsSplit[1]);
                Jogador temp = listaFlex.remover(key);
                System.out.println("(R) " + temp.getNome());
            }

        } else {
            if (sOpsSplit[0].charAt(0) == 'I') {
                switch (sOpsSplit[0]) {
                    case "II":
                        listaFlex.inserirInicio(pesquisar(sOpsSplit[1]));
                        break;
                    case "IF":
                        listaFlex.inserirFim(pesquisar(sOpsSplit[1]));
                        break;
                    default:
                        break;
                }
            } else {
                switch (sOpsSplit[0]) {
                    case "RI":
                        Jogador temp = listaFlex.removerInicio();
                        System.out.println("(R) " + temp.getNome());
                        break;
                    case "RF":
                        Jogador temp2 = listaFlex.removerFim();
                        System.out.println("(R) " + temp2.getNome());
                    default:
                        break;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        String arrayID = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in, "ISO-8859-1"));
        arrayID = br.readLine();
        while (arrayID.equals("FIM") == false) {
            array[countGlobal] = new Jogador();
            array[countGlobal].ler(arrayID);
            // array[countGlobal].imprimir();
            countGlobal++;
            arrayID = br.readLine();
        }
        sort(0, countGlobal - 1);
        ListaDupla listaFlex = new ListaDupla(array[0]);
        for (int i = 1; i < countGlobal; i++) {
            listaFlex.inserirFim(array[i]);
        }
        listaFlex.mostrar();
    }
}
