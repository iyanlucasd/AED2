class Celula {
    int elemento;
    Celula prox, ant, inf, sup;

    public Celula() {
        this(0);
    }

    public Celula(int elemento) {
        this.elemento = elemento;
        prox = ant = inf = sup = null;
    }
}

class Matriz {
    int linha, coluna;
    Celula inicio;

    public void inserir() {
        for (Celula i = inicio; i != null; i = i.inf) {
            for (Celula j = i; j != null; j = j.prox) {
                j.elemento = MyIO.readInt();
            }
        }

    }

    public Matriz(int linha, int coluna) {
        this.linha = linha;
        this.coluna = coluna;
        int x = 0;

        Celula i, j;
        int lin, col;
        inicio = new Celula(x++);
        for (j = inicio, col = 1; col < coluna; j = j.prox, col++) {
            j.prox = new Celula(0);
            j.prox.ant = j;
        }

        for (i = inicio, lin = 1; lin < linha; i = i.inf, lin++) {
            i.inf = new Celula(0);
            i.inf.sup = i;

            for (j = i.inf, col = 1; col < coluna; j = j.prox, col++) {
                j.prox = new Celula(0);
                j.prox.ant = j;
                j.prox.sup = j.sup.prox;
                j.sup.prox.inf = j.prox;
            }
        }
    }

    public void mostrar() {
        for (Celula i = inicio; i != null; i = i.inf) {
            for (Celula j = i; j != null; j = j.prox) {
                System.out.print(j.elemento + " ");
            }
            MyIO.println("");
        }
    }

    public void diagonalmain() {
        if (this.linha == this.coluna && linha > 0) {
            Celula i = inicio;
            do {
                System.out.print(i.elemento + " ");
                i = i.prox;
                if (i != null) {
                    i = i.inf;
                }
            } while (i != null);
        }
    }

    public void diagonalSec() {
        if (this.linha == this.coluna && linha > 0) {
            Celula i;
            Celula flow = null;
            for (i = inicio; i != null; i = i.prox) {
                flow = i;
            }

            do {
                MyIO.print(flow.elemento + " ");
                flow = flow.inf;

                if (flow != null) {
                    flow = flow.ant;
                }

            } while (flow != null);
        }
    }

    public Matriz soma(Matriz a) {
        return soma(this, a);
    }

    public Matriz soma(Matriz a, Matriz b) {
        Matriz resp = null;
        if (a.linha == b.linha && a.coluna == b.coluna) {
            resp = new Matriz(a.linha, a.coluna);

            Celula firstAnswer = resp.inicio;
            Celula tmpA = a.inicio;
            Celula tmpB = b.inicio;

            for (int i = 0; i < linha; i++) {
                Celula secondAnswer = firstAnswer;
                Celula secTempA = tmpA;
                Celula secTmpB = tmpB;

                for (int j = 0; j < coluna; j++) {
                    secondAnswer.elemento = secTempA.elemento + secTmpB.elemento;
                    secondAnswer = secondAnswer.prox;
                    secTempA = secTempA.prox;
                    secTmpB = secTmpB.prox;
                }
                firstAnswer = firstAnswer.inf;
                tmpA = tmpA.inf;
                tmpB = tmpB.inf;
            }
        }
        return resp;
    }

    public Matriz multiplexMatrix(Matriz a, Matriz b) {
        Matriz resp = null;

        if (a.linha == b.coluna) {
            resp = new Matriz(a.linha, b.coluna);

            Celula firstAnswer = resp.inicio;
            Celula tmpA = a.inicio;
            Celula tmpB = b.inicio;

            for (int i = 0; i < linha; i++) {
                Celula secondAnswer = firstAnswer;
                Celula secTempA = tmpA;
                Celula secTmpB = tmpB;

                for (int k = 0; k < b.coluna; k++) {
                    Celula flowA = secTempA;
                    Celula flowB = secTmpB;

                    for (int j = 0; j < b.coluna; j++) {
                        secondAnswer.elemento = secondAnswer.elemento + (secTempA.elemento * secTmpB.elemento);
                        secTempA = secTempA.prox;
                        secTmpB = secTmpB.inf;
                    }
                    secondAnswer = secondAnswer.prox;
                    secTempA = flowA;
                    secTmpB = flowB.prox;
                }
                firstAnswer = firstAnswer.inf;
                tmpA = tmpA.inf;
            }
        }
        return resp;
    }

}

public class matrizEmJava {
    public static void main(String[] args) throws Exception {
        int n = MyIO.readInt();
        for (int i = 0; i < n; i++) {
            int x=0;
            int y = 0;
            y = MyIO.readInt();
            x = MyIO.readInt();
            Matriz first = new Matriz(x, y);
            first.inserir();
            first.diagonalmain();
            MyIO.println("");
            first.diagonalSec();
            MyIO.println("");
            int tmp = MyIO.readInt();
            int pow = MyIO.readInt();
            Matriz second = new Matriz(x, y);
            second.inserir();
            Matriz flow = new Matriz(x, y);
            flow = first.soma(first, second);
            flow.mostrar();
            Matriz flow2 = new Matriz(x, y);
            flow2 = first.multiplexMatrix(first, second);
            flow2.mostrar();
        }
    }
}