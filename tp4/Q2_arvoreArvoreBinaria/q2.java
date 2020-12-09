import java.io.*;

class no {
    public int x; // x inserido na celula.
    public no esq, dir; // Filhos da esq e dir.
    public no2 nohDois;

    public no(int x) {
        this.x = x;
        this.esq = this.dir = null;
        this.nohDois = null;
    }

    public no(int x, no esq, no dir, no2 nohDois) {
        this.x = x;
        this.esq = esq;
        this.dir = dir;
        this.nohDois = nohDois;
    }

}

class no2 {
    public String x;
    public no2 esq;
    public no2 dir;

    no2(String x) {
        this.x = x;
        this.esq = this.dir = null;
    }

    no2(String x, no2 esq, no2 dir) {
        this.x = x;
        this.esq = esq;
        this.dir = dir;
    }
}

class ArvoreArvore {
    private no raiz;

    public ArvoreArvore() {
        raiz = null;
    }

    public boolean pesquisar(String x) {

        if (raiz != null) {
            System.out.print(" raiz");
        }
        return pesquisar(x, raiz);
    }

    private boolean pesquisar(String x, no i) {
        boolean resp = false;
        if (i != null) {

            resp = pesquisar2(x, i.nohDois);

            if (resp == false) {
                System.out.print(" esq");
                resp = pesquisar(x, i.esq);
            }
            if (resp == false) {
                System.out.print(" dir");
                resp = pesquisar(x, i.dir);
            }
        }

        return resp;
    }

    private boolean pesquisar2(String x, no2 i) {
        boolean resp = false;
        if (i != null) {

            if (x.compareTo(i.x) == 0) {
                resp = true;

            } else {

                System.out.print(" ESQ");
                resp = pesquisar2(x, i.esq);

                if (resp == false) {
                    System.out.print(" DIR");
                    resp = pesquisar2(x, i.dir);
                }
            }
        }
        return resp;
    }

    public void inserir(int x) throws Exception {
        raiz = inserir(x, raiz);
    }

    private no inserir(int x, no i) throws Exception {
        if (i == null) {
            i = new no(x);
        } else if (x < i.x) {
            i.esq = inserir(x, i.esq);

        } else if (x > i.x) {
            i.dir = inserir(x, i.dir);

        } else {
            throw new Exception("Erro ao inserir!");
        }

        return i;
    }

    public void inserir2(String x, int y) throws Exception {
        inserir2(x, y, raiz);
    }

    private void inserir2(String x, int y, no i) throws Exception {
        if (i.x == y) {
            i.nohDois = inserir3(x, i.nohDois);
        } else if (y < i.x) {
            inserir2(x, y, i.esq);

        } else if (y > i.x) {
            inserir2(x, y, i.dir);

        } else {
            throw new Exception("Erro ao inserir!");
        }

    }

    private no2 inserir3(String x, no2 i) throws Exception {

        if (i == null) {
            i = new no2(x);
        } else if (x.compareTo(i.x) < 0)
            i.esq = inserir3(x, i.esq);
        else if (x.compareTo(i.x) > 0)
            i.dir = inserir3(x, i.dir);
        else {
            throw new Exception("Erro ao inserir!");
        }
        return i;

    }

}

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
        System.out.print("## ");
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
        System.out.println(" ##");
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

public class q2 extends Jogador {

    public static Jogador pesquisar(String key) throws Exception {
        array[countGlobal] = new Jogador();
        array[countGlobal].ler(key);
        // array[countGlobal].imprimir();
        countGlobal++;
        // achei.imprimir();
        return array[countGlobal - 1];
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
        // System.out.println("chegou");
        ArvoreArvore arvore = new ArvoreArvore();

        arvore.inserir(7);
        arvore.inserir(3);
        arvore.inserir(11);
        arvore.inserir(1);
        arvore.inserir(5);
        arvore.inserir(9);
        arvore.inserir(12);
        arvore.inserir(0);
        arvore.inserir(2);
        arvore.inserir(4);
        arvore.inserir(6);
        arvore.inserir(8);
        arvore.inserir(10);
        arvore.inserir(13);
        arvore.inserir(14);

        String arrayOps[] = new String[1024];
        int count = 0;
        arrayOps[count] = br.readLine();
        while (arrayOps[count].equals("FIM") == false) {
            // System.out.println("chegou");
            count++;
            arrayOps[count] = br.readLine();
        }

        for (int i = 0; i < countGlobal; i++) {
            int val = array[i].getAltura() % 15;
            arvore.inserir2(array[i].getNome(), val);
        }

        for (int i = 0; i < count; i++) {
            System.out.print(arrayOps[i]);
            if (arvore.pesquisar(arrayOps[i]) == true) {
                System.out.print(" SIM");
                System.out.println();
            } else {
                System.out.print(" NAO");
                System.out.println();
            }
        }

    }
}
