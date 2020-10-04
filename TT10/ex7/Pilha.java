/**
 * Pilha dinamica
 * 
 * @author Max do Val Machado
 * @version 2 01/2015
 */
public class Pilha {
	private Celula topo;

	/**
	 * Construtor da classe que cria uma fila sem elementos.
	 */
	public Pilha() {
		topo = null;
	}

	public Celula getTopo() {
		return topo;
	}

	/**
	 * Insere elemento na pilha (politica FILO).
	 * 
	 * @param x int elemento a inserir.
	 */
	public void inserir(int x) {
		Celula tmp = new Celula(x);
		tmp.prox = topo;
		topo = tmp;
		tmp = null;
	}

	/**
	 * Remove elemento da pilha (politica FILO).
	 * 
	 * @return Elemento removido.
	 * @trhows Exception Se a sequencia nao contiver elementos.
	 */
	public int remover() throws Exception {
		if (topo == null) {
			throw new Exception("Erro ao remover!");
		}
		int resp = topo.elemento;
		Celula tmp = topo;
		topo = topo.prox;
		tmp.prox = null;
		tmp = null;
		return resp;
	}

	/**
	 * Mostra os elementos separados por espacos, comecando do topo.
	 */
	public void mostrar() {
		System.out.print("[ ");
		for (Celula i = topo; i != null; i = i.prox) {
			System.out.print(i.elemento + " ");
		}
		System.out.println("] ");
	}

	public int getSoma() {
		return getSoma(topo);
	}

	private int getSoma(Celula i) {
		int resp = 0;
		if (i != null) {
			resp += i.elemento + getSoma(i.prox);
		}
		return resp;
	}

	public int getMax() {
		int max = topo.elemento;
		for (Celula i = topo.prox; i != null; i = i.prox) {
			if (i.elemento > max)
				max = i.elemento;
		}
		return max;
	}

	public void getMaxRec() {
		Celula i = topo;
		System.out.println(MaxRec(i, 0));
	}

	public int MaxRec(Celula i, int max) {
		if (i != null) {
			if (max < i.elemento) {
				return MaxRec(i.prox, i.elemento);
			} else {
				return MaxRec(i.prox, max);
			}
		}
		return max;
	}

	public void mostraPilhaIterativo() {
		int array[] = new int[6];
		int j = 0;
		Celula i = topo;
		array[j] = i.elemento;
		for (; i != null; i = i.prox) {
			array[j] = i.elemento;
			j++;
		}
		System.out.print("[ ");
		for (j = array.length - 1; j >= 0; j--) {
			System.out.print(" " + array[j] + " ");
		}
		System.out.println(" ]");

	}

	public void mostraPilha() {
		mostraPilha(topo);
	}

	private void mostraPilha(Celula i) {
		if (i != null) {
			mostraPilha(i.prox);
			System.out.println("" + i.elemento);
		}
	}

	public void mostraPilhaRem() {
		System.out.print("[ ");
		mostraPilhaRem(topo);
		System.out.println(" ]");
	}

	private void mostraPilhaRem(Celula i) {
		if (i != null) {
			System.out.print(" " + i.elemento + " ");
			mostraPilhaRem(i.prox);
		}
	}

}
