public class ex1Fila extends Fila {
    public int remover() throws Exception {
        if(primeiro == ultimo)
        throw new Exception("Erro");

        Celula tmp = primeiro.prox;
        primeiro.prox = primeiro.prox.prox;
        int elemento = tmp.elemento;
        tmp.prox = null;
        tmp = null;
        return elemento;
    }
}
