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

	/**
	 * Insere elemento na pilha (politica FILO).
	 * 
	 * @param x int elemento a inserir.
	 */
	public void inserir(Jogador x) {
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
	public Jogador remover() throws Exception {
		if (topo == null) {
			throw new Exception("Erro ao remover!");
		}
		Jogador resp = topo.elemento;
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
		int j = 0;
		for (Celula i = topo; i != null; i = i.prox) {
			System.out.print("["+j+"] ");
			i.elemento.imprimir(); 
			j++;
		}
	}

	// public Jogador getSoma() {
	// 	return getSoma(topo);
	// }

	// private Jogador getSoma(Celula i) {
	// 	Jogador resp = new Jogador();
	// 	if (i != null) {
	// 		resp += i.elemento. + getSoma(i.prox);
	// 	}
	// 	return resp;
	// }

	public Jogador getMax() {
		Jogador max = topo.elemento;
		for (Celula i = topo.prox; i != null; i = i.prox) {
			if (i.elemento.getId() > max.getId())
				max = i.elemento;
		}
		return max;
	}

	public void mostraPilha() {
		mostraPilha(topo, 141);
	}

	private void mostraPilha(Celula i, int count) {
		if (i != null) {
			mostraPilha(i.prox, count-1);
			System.out.print("["+count+"] ");
			i.elemento.imprimir();
		}
	}

}
