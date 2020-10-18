public class ex4fila extends Fila{
    public int somaFila() {
        int soma = 0;
        for(Celula i = primeiro.prox; i != null; i = i.prox)
			soma += i.elemento;
        return soma;
    }
}
