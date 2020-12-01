/**
 * Lista dinamica
 * 
 * @author Max do Val Machado
 * @version 2 01/2015
 */
class Celula {
	public Jogador elemento; // Elemento inserido na celula.
	public Celula prox; // Aponta a celula prox.

	/**
	 * Construtor da classe.
	 */
	public Celula() {

	}

	/**
	 * Construtor da classe.
	 * 
	 * @param elemento int inserido na celula.
	 */
	public Celula(Jogador elemento) {
		this.elemento = elemento;
		this.prox = null;
	}
}

class ListaFlex {
	private Celula primeiro;
	private Celula ultimo;

	/**
	 * Construtor da classe que cria uma lista sem elementos (somente no cabeca).
	 */
	public ListaFlex() {
		primeiro = new Celula();
		ultimo = primeiro;
	}

	/**
	 * Insere um elemento na primeira posicao da lista.
	 * 
	 * @param x int elemento a ser inserido.
	 */
	public void inserirInicio(Jogador x) {
		Celula tmp = new Celula(x);
		tmp.prox = primeiro.prox;
		primeiro.prox = tmp;
		if (primeiro == ultimo) {
			ultimo = tmp;
		}
		tmp = null;
	}

	/**
	 * Insere um elemento na ultima posicao da lista.
	 * 
	 * @param x int elemento a ser inserido.
	 */
	public void inserirFim(Jogador x) {
		ultimo.prox = new Celula(x);
		ultimo = ultimo.prox;
	}

	/**
	 * Remove um elemento da primeira posicao da lista.
	 * 
	 * @return resp int elemento a ser removido.
	 * @throws Exception Se a lista nao contiver elementos.
	 */
	public Jogador removerInicio() throws Exception {
		if (primeiro == ultimo) {
			throw new Exception("Erro ao remover (vazia)!");
		}

		Celula tmp = primeiro;
		primeiro = primeiro.prox;
		Jogador resp = primeiro.elemento;
		tmp.prox = null;
		tmp = null;
		return resp;
	}

	/**
	 * Remove um elemento da ultima posicao da lista.
	 * 
	 * @return resp int elemento a ser removido.
	 * @throws Exception Se a lista nao contiver elementos.
	 */
	public Jogador removerFim() throws Exception {
		if (primeiro == ultimo) {
			throw new Exception("Erro ao remover (vazia)!");
		}

		// Caminhar ate a penultima celula:
		Celula i;
		for (i = primeiro; i.prox != ultimo; i = i.prox)
			;

		Jogador resp = ultimo.elemento;
		ultimo = i;
		i = ultimo.prox = null;

		return resp;
	}

	/**
	 * Insere um elemento em uma posicao especifica considerando que o primeiro
	 * elemento valido esta na posicao 0.
	 * 
	 * @param x   int elemento a ser inserido.
	 * @param pos int posicao da insercao.
	 * @throws Exception Se <code>posicao</code> invalida.
	 */
	public void inserir(Jogador x, int pos) throws Exception {

		int tamanho = tamanho();

		if (pos < 0 || pos > tamanho) {
			throw new Exception("Erro ao inserir posicao (" + pos + " / tamanho = " + tamanho + ") invalida!");
		} else if (pos == 0) {
			inserirInicio(x);
		} else if (pos == tamanho) {
			inserirFim(x);
		} else {
			// Caminhar ate a posicao anterior a insercao
			Celula i = primeiro;
			for (int j = 0; j < pos; j++, i = i.prox)
				;

			Celula tmp = new Celula(x);
			tmp.prox = i.prox;
			i.prox = tmp;
			tmp = i = null;
		}
	}

	/**
	 * Remove um elemento de uma posicao especifica da lista considerando que o
	 * primeiro elemento valido esta na posicao 0.
	 * 
	 * @param posicao Meio da remocao.
	 * @return resp int elemento a ser removido.
	 * @throws Exception Se <code>posicao</code> invalida.
	 */
	public Jogador remover(int pos) throws Exception {
		Jogador resp;
		int tamanho = tamanho();

		if (primeiro == ultimo) {
			throw new Exception("Erro ao remover (vazia)!");

		} else if (pos < 0 || pos >= tamanho) {
			throw new Exception("Erro ao remover (posicao " + pos + " / " + tamanho + " invalida!");
		} else if (pos == 0) {
			resp = removerInicio();
		} else if (pos == tamanho - 1) {
			resp = removerFim();
		} else {
			// Caminhar ate a posicao anterior a insercao
			Celula i = primeiro;
			for (int j = 0; j < pos; j++, i = i.prox)
				;

			Celula tmp = i.prox;
			resp = tmp.elemento;
			i.prox = tmp.prox;
			tmp.prox = null;
			i = tmp = null;
		}

		return resp;
	}

	/**
	 * Mostra os elementos da lista separados por espacos.
	 */
	public void mostrar() {
		int j = 0;
		for (Celula i = primeiro.prox; i != null; i = i.prox) {
			System.out.print("[" + j + "] ");
			j++;
			i.elemento.imprimir();
		}
	}

	/**
	 * Procura um elemento e retorna se ele existe.
	 * 
	 * @param x Elemento a pesquisar.
	 * @return <code>true</code> se o elemento existir, <code>false</code> em caso
	 *         contrario.
	 */
	public boolean pesquisar(Jogador x) {
		boolean resp = false;
		for (Celula i = primeiro.prox; i != null; i = i.prox) {
			if (i.elemento == x) {
				resp = true;
				i = ultimo;
			}
		}
		return resp;
	}

	/**
	 * Calcula e retorna o tamanho, em numero de elementos, da lista.
	 * System.out.println(lista.tamanho());
	 * 
	 * @return resp int tamanho
	 */
	public int tamanho() {
		int tamanho = 0;
		for (Celula i = primeiro; i != ultimo; i = i.prox, tamanho++)
			;
		return tamanho;
	}
}
