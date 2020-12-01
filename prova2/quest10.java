// método recursivo e inserções
// ------------------------------------------------------------------------
public class quest10 {

    public static void somaLista(Lista l1, Lista l2, Lista l3, int count,int show) {
        if (count <= l1.tamanho() ) {
            somaLista(l1, l2, l3, count+1, show-1);
            System.out.println((count < l1.tamanho() && count < l2.tamanho() && count < l3.tamanho())
            ? ("["+ show+"] "+ (l1.returnPos(count) + l2.returnPos(count) + l3.returnPos(count)))
            : "fim soma!");
        } 
            

    }

    	// método de retornar o numero da posição
	// -----------------------------------------------
	public int returnPos(int pos) {
		int j = 0;
		int x = 0;
		for (Celula i = primeiro.prox; i != null && j <= pos; i = i.prox, j++) {
			x = i.elemento;
		}
		return x;
	}
	// -----------------------------------------------


    public static void main(String[] args) {
        Lista l1 = new Lista();
        Lista l2 = new Lista();
        Lista l3 = new Lista();
        l1.inserirInicio(5);
        l1.inserirInicio(1);
        l1.inserirInicio(2);
        l1.inserirInicio(3);

        l2.inserirInicio(4);
        l2.inserirInicio(1);
        l2.inserirInicio(2);
        l2.inserirInicio(3);

        l3.inserirInicio(6);
        l3.inserirInicio(1);
        l3.inserirInicio(2);
        l3.inserirInicio(3);
        somaLista(l1, l2, l3, 0, l1.tamanho());
    }
}
// ------------------------------------------------------------------------