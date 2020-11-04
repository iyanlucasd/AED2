public class ex1ListaDupla extends ListaDupla {
    public void inverte() {
        Celula i = primeiro.prox;
        Celula j = ultimo;
        while(i != j && j.prox != i){
            int tmp = i.elemento;
            i.elemento = j.elemento;
            j.elemento = tmp;
            i = i.prox;
            j = j.ant;
        }
    }
    

}
