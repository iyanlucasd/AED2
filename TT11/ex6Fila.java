public class ex6Fila extends Fila {
    public int contar() {
        return contar(primeiro.prox);
    }

    public int contar(Celula i) {
        int resp = 0;
        if (i == null) {
            resp = 0;
        } else if (i.elemento % 2 == 0 && i.elemento % 5 == 0) {
            resp = 1 + contar(i.prox);
        } else {
            resp = contar(i.prox);
        }
        return resp;
    }
}
