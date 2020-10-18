public class ex5Fila extends Fila {
    public void inverteFila() {
        Celula fim = ultimo;
        while (primeiro != fim) {
            Celula nova = new Celula(primeiro.prox.prox.elemento);
            nova.prox = fim.prox;
            Celula tmp = primeiro.prox;
            primeiro.prox = tmp.prox;
            nova = tmp = tmp.prox = null;
            if (ultimo == fim) {
                ultimo = ultimo.prox;
            }
        }
        fim = null;
    }
}
