import java.io.*;
import java.util.*;

class No {
    public char elemento;
    public int tamanho = 255;
    public No[] prox;
    public boolean folha;

    public No() {
        this(' ');
    }

    public No(char elemento) {
        this.elemento = elemento;
        prox = new No[tamanho];
        for (int i = 0; i < tamanho; i++)
            prox[i] = null;
        folha = false;
    }

    public static int hash(char x) {
        return (int) x;
    }
}

class Arvore {
    private No raiz;

    public Arvore() {
        raiz = new No();
    }

    public void insert(String s) throws Exception {
        insert(s, raiz, 0);
    }

    private void insert(String s, No no, int i) throws Exception {
        if (no.prox[s.charAt(i)] == null) {
            no.prox[s.charAt(i)] = new No(s.charAt(i));

            if (i == s.length() - 1) {
                no.prox[s.charAt(i)].folha = true;
            } else {
                insert(s, no.prox[s.charAt(i)], i + 1);
            }

        } else if (no.prox[s.charAt(i)].folha == false && i < s.length() - 1) {
            insert(s, no.prox[s.charAt(i)], i + 1);

        } else {
            throw new Exception("Erro ao insert!");
        }
    }

    public boolean pesquisar(String s) throws Exception {
        return pesquisar(s, raiz, 0);
    }

    public boolean pesquisar(String s, No no, int i) throws Exception {
        boolean resp;
        if (no.prox[s.charAt(i)] == null) {
            resp = false;
        } else if (i == s.length() - 1) {
            resp = (no.prox[s.charAt(i)].folha == true);
        } else if (i < s.length() - 1) {
            resp = pesquisar(s, no.prox[s.charAt(i)], i + 1);
        } else {
            throw new Exception("Erro ao pesquisar!");
        }
        return resp;
    }

    public boolean mostrar(String s, No no) {
        boolean resp = false;

        for (int i = 0; i < no.prox.length; i++) {

            if (s.charAt(i) == no.elemento) {
                resp = true;
                i = no.prox.length;
            }
        }
        return resp;
    }

    public int contarAs() {
        int resp = 0;
        if (raiz != null) {
            resp = contarAs(raiz);
        }
        return resp;
    }

    public int contarAs(No no) {
        int resp = (no.elemento == 'A') ? 1 : 0;

        if (no.folha == false) {
            for (int i = 0; i < no.prox.length; i++) {
                if (no.prox[i] != null) {
                    resp += contarAs(no.prox[i]);
                }
            }
        }
        return resp;
    }

    public void sort(Jogador[] lista, int indiceInicio, int indiceFim) {
        // Condicional que verifica a validade dos parametros passados.
        if (lista != null && indiceInicio < indiceFim && indiceInicio >= 0 && indiceFim < lista.length
                && lista.length != 0) {
            int meio = ((indiceFim + indiceInicio) / 2);
            sort(lista, indiceInicio, meio);
            sort(lista, meio + 1, indiceFim);

            merge(lista, indiceInicio, meio, indiceFim);
        }

    }

    public void merge(Jogador[] lista, int indiceInicio, int meio, int indiceFim) {
        Jogador[] mergeSet = new Jogador[lista.length];
        for (int i = indiceInicio; i <= indiceFim; i++) {
            mergeSet[i] = lista[i];
        }

        int i = indiceInicio;
        int j = meio + 1;
        int k = indiceInicio;

        while (i <= meio && j <= indiceFim) {
            if (mergeSet[i].getNome().compareTo(mergeSet[j].getNome()) <= 0) {
                lista[k] = mergeSet[i];
                i++;
            } else {
                lista[k] = mergeSet[j];
                j++;
            }
            k++;
        }

        while (i <= meio) {
            lista[k] = mergeSet[i];
            i++;
            k++;
        }

        while (j <= indiceFim) {
            lista[k] = lista[j];
            j++;
            k++;
        }
    }

}

class Jogador {

    private int id;
    private String universidade;
    private int altura;
    private String nome;
    private int peso;
    private String cidadeNascimento;
    private int anoNascimento;
    private String estadoNascimento;

    public Jogador() {
        id = 0;
        altura = 0;
        peso = 0;
        anoNascimento = 0;
        nome = "";
        universidade = "";
        cidadeNascimento = "";
        estadoNascimento = "";

    }// end construtor padrao

    public Jogador(String nome, String universidade, String cidadeNascimento, String estadoNascimento, int id,
            int altura, int peso, int anoNascimento) {
        this.nome = nome;
        this.universidade = universidade;
        this.cidadeNascimento = cidadeNascimento;
        this.estadoNascimento = estadoNascimento;
        this.id = id;
        this.altura = altura;
        this.peso = peso;
        this.anoNascimento = anoNascimento;

    }

    public void setId(int id) {
        this.id = id;
    }// end setId

    public void setAltura(int altura) {
        this.altura = altura;
    }// end setAltura

    public void setPeso(int peso) {
        this.peso = peso;
    }// end setPesoo

    public void setAnoNascimento(int anoNascimento) {
        this.anoNascimento = anoNascimento;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setUniversidade(String universidade) {
        this.universidade = universidade;
    }

    public void setCidadeNascimento(String cidadeNascimento) {
        this.cidadeNascimento = cidadeNascimento;
    }

    public void setEstadoDeNascimento(String estadoNascimento) {
        this.estadoNascimento = estadoNascimento;
    }

    public int getAltura() {
        return altura;
    }// end getAltura

    public int getPeso() {
        return peso;
    }

    public int getAnoNascimento() {
        return anoNascimento;
    }

    public String getNome() {
        return nome;
    }

    public String getUniversidade() {
        return universidade;
    }

    public String getCidadeNascimento() {
        return cidadeNascimento;
    }

    public String getEstadoDeNascimento() {
        return estadoNascimento;
    }

    public int getId() {
        return id;
    }// end getId

    public Jogador clone(Jogador x) {
        x.id = id;
        x.nome = nome;
        x.altura = altura;
        x.peso = peso;
        x.universidade = universidade;
        x.cidadeNascimento = cidadeNascimento;
        x.estadoNascimento = estadoNascimento;
        x.anoNascimento = anoNascimento;
        return x;
    }

    public void Imprimir() {
        System.out.println("[" + getId() + " ## " + getNome() + " ## " + getAltura() + " ## " + getPeso() + " ## "
                + getAnoNascimento() + " ## " + getUniversidade() + " ## " + getCidadeNascimento() + " ## "
                + getEstadoDeNascimento() + "]");
    }

}

public class q6 {

    public static Arvore arvore = new Arvore();
    public static Arvore arvore2 = new Arvore();
    public static Jogador[] array = new Jogador[1000];
    public static Jogador ply;

    public static int countGlobal = 0;

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
    }

    public static String leituraArquivo(String arrayId) throws Exception {
        String linha = "";
        BufferedReader file = new BufferedReader(new InputStreamReader(new FileInputStream("/tmp/players.csv")));

        linha = file.readLine();
        while (linha != null) {
            String[] id = linha.split(",");
            if (id[0].equals(arrayId) == true)
                return linha;
            linha = file.readLine();
        }
        String s = "";
        return s;
    }

    public static void main(String[] args) throws Exception {

        String arrayId = "";
        String casos = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        arrayId = br.readLine();

        while (arrayId.equals("FIM") != true) {
            array[countGlobal] = new Jogador();
            tratamentoString(leituraArquivo(arrayId));
            countGlobal++;
            arrayId = br.readLine();
        } // end while

        for (int i = 0; i < countGlobal; i++) {
            if (arvore.pesquisar(array[i].getNome()) == false) {
                if (array[i].getId() > 0 && array[i].getId() < 9)
                    System.out.println(array[i].getId() + "       " + array[i].getNome());
                else if (array[i].getId() > 10 && array[i].getId() < 99)
                    System.out.println(array[i].getId() + "     " + array[i].getNome());
                else if (array[i].getId() > 100 && array[i].getId() < 999)
                    System.out.println(array[i].getId() + "    " + array[i].getNome());
                else
                    System.out.println(array[i].getId() + "   " + array[i].getNome());
                arvore.insert(array[i].getNome());
            }
        }

        arrayId = br.readLine();

        while (arrayId.equals("FIM") != true) {
            array[countGlobal] = new Jogador();
            tratamentoString(leituraArquivo(arrayId));

            countGlobal++;
            arrayId = br.readLine();
        }
        for (int i = 0; i < countGlobal; i++) {

            if (arvore.pesquisar(array[i].getNome()) == false) {

                if (array[i].getId() > 0 && array[i].getId() < 9)
                    System.out.println(array[i].getId() + "      " + array[i].getNome());
                else if (array[i].getId() > 10 && array[i].getId() < 99)
                    System.out.println(array[i].getId() + "     " + array[i].getNome());
                else if (array[i].getId() > 100 && array[i].getId() < 999)
                    System.out.println(array[i].getId() + "    " + array[i].getNome());
                else
                    System.out.println(array[i].getId() + "   " + array[i].getNome());
                arvore2.insert(array[i].getNome());
            }

        }

        String arrayOps;
        boolean pesq = false;

        arrayOps = br.readLine();

        while (arrayOps.equals("FIM") == false) {
            System.out.print(arrayOps);
            System.out
                    .print(((pesq = arvore.pesquisar(arrayOps)) == true || (pesq = arvore2.pesquisar(arrayOps)) == true)
                            ? " SIM\n"
                            : " NAO\n");

            arrayOps = br.readLine();
        }

    }// end main

}// class Main