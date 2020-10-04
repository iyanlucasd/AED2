
import java.util.*;
import java.io.*;

class Jogador {
    public static Jogador[] array = new Jogador[1024];
    public static int countGlobal = 0;
    public static int comparacoes = 0;

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
            }
            s = file.readLine();
        }

    }

}

public class ex02 extends Jogador {
    // 0,Curly Armstrong,180,77,Indiana University,1918,,
    // 93,Wah Wah,180,77,,1921,,

    public static String asterisco(String s) {
        String aux = "";
        for (int i = 0; i < s.length(); i++) {
            comparacoes++;
            if (s.charAt(i) != '*') {
                aux += s.charAt(i);
            }
        }
        return aux;

    }

    public static void PesquisaSeq(String[] pesquisa, int count) {
        for (int i = 0; i < count; i++) {
            Boolean achou = false;
            for (int j = 0; j < countGlobal; j++) {
                String nome = array[j].getNome();
                comparacoes++;
                if (pesquisa[i].equals(nome) == true) {
                    achou = true;
                    j = countGlobal;
                } else {
                    comparacoes++;
                    if (nome.charAt(nome.length() - 1) == '*') {
                        comparacoes++;
                        if (pesquisa[i].equals(asterisco(nome)) == true) {
                            achou = true;
                            j = countGlobal;
                        }
                    }
                }
            }
            comparacoes++;
            if (achou == true) {
                System.out.println("SIM");
            } else if (achou == false) {
                System.out.println("NAO");
            }
            comparacoes++;
        }

    }

    public static void logCreator(long tempo1, long tempo2) throws Exception {
        long tempoExecucao = tempo2 - tempo1;
        File log = new File("691360_sequencial.txt");
        FileWriter logWriter = new FileWriter("691360_sequencial.txt");
        logWriter.write("691360\t" + tempoExecucao + "\t" + comparacoes);
    }

    public static void main(String[] args) throws Exception {
        // 1
        // Cliff Barker
        // 104
        // 1047

        long tempo1 = new Date().getTime();
        String arrayID = "";
        String[] pesquisa = new String[200];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in, "ISO-8859-1"));
        arrayID = br.readLine();
        while (arrayID.equals("FIM") == false) {
            array[countGlobal] = new Jogador();
            array[countGlobal].ler(arrayID);
            // array[countGlobal].imprimir();
            countGlobal++;
            arrayID = br.readLine();
        }
        int i = 0;
        // System.out.println(countGlobal);
        pesquisa[i] = br.readLine();
        while (pesquisa[i].equals("FIM") == false) {
            // System.out.println(pesquisa[i]);
            i++;
            pesquisa[i] = br.readLine();

        }
        PesquisaSeq(pesquisa, i);
        long tempo2 = new Date().getTime();
        logCreator(tempo1, tempo2);
    }
}
