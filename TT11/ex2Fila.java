public class ex2Fila extends Fila {
    public int ehMaiorFila() {
        int maior = primeiro.prox.elemento;
        for (Celula i = primeiro.prox; i != null; i = i.prox) {
            if (i.elemento > maior)
                maior = i.elemento;
        }
    }
}
