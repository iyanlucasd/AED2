public class ex3Fila extends Fila {
    public int mostraTerceiro() {
        Celula i = primeiro.prox;
        for (int j = 0; i != null && j < 3; i = i.prox, j++);
        return i.elemento;
    }
}