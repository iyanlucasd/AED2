package q1;

public class principal {
    public static void main(String[] args) {
        Hash table = new Hash(2);
        table.inserir(1);
        table.inserir(4);
        table.inserir(5);
        table.inserir(2);
        table.inserir(7);
        table.show();

    }
}

class Hash {
    int tabela[];
    int m;
    int NULO = -1;

    public Hash() {
        this(5);
    }

    public Hash(int m) {
        this.m = m;
        this.tabela = new int[this.m];
        for (int i = 0; i < m; i++) {
            tabela[i] = NULO;
        }
    }

    public void show() {
        System.out.print("[ ");
        for (int i = 0; i < tabela.length; i++) {
            System.out.print(tabela[i] + " ");
        }
        System.out.println("] ");
    }

    public int h(int elemento) {
        return elemento % m;
    }

    public int reh(int elemento) {
        return ++elemento % m;
    }

    public boolean inserir(int elemento) {
        boolean resp = false;

        if (elemento != NULO) {

            int pos = h(elemento);

            if (tabela[pos] == NULO) {
                tabela[pos] = elemento;
                resp = true;

            } else {

                pos = reh(elemento);

                if (tabela[pos] == NULO) {
                    tabela[pos] = elemento;
                    resp = true;
                }
            }
        }

        return resp;
    }

    public boolean pesquisar(int elemento) {
        boolean resp = false;

        int pos = h(elemento);

        if (tabela[pos] == elemento) {
            resp = true;

        } else {
            pos = reh(elemento);

            if (tabela[pos] == elemento) {
                resp = true;
            }
        }
        return resp;
    }

    boolean remover(int elemento) {
        boolean resp = false;

        // ...

        return resp;
    }
}

