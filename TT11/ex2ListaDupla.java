public class ex2ListaDupla extends ListaDupla {
    public void inverte() {
        Celula i = primeiro.prox;
        Celula j = ultimo;
        Celula k;
        while (i != j && j.prox != i) {
            int tmp = i.elemento;
            i.elemento = j.elemento;
            j.elemento = tmp;
            i = i.prox;
            j = j.ant;
            for (k = primeiro; k.prox != j; k = k.prox)
                ;
            j = k;
        }
    }
}
