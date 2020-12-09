/**
 * Arvore binaria de pesquisa
 * 
 * @author Max do Val Machado
 */
public class ArvoreBinaria {
	private No raiz; // Raiz da arvore.

	/**
	 * Construtor da classe.
	 */
	public ArvoreBinaria() {
		raiz = null;
	}

	/**
	 * Metodo publico iterativo para pesquisar elemento.
	 * 
	 * @param x Elemento que sera procurado.
	 * @return <code>true</code> se o elemento existir, <code>false</code> em caso
	 *         contrario.
	 */
	public boolean pesquisar(String x) {
		boolean trueOrFalse = false;
		System.out.print(x+" ");
		if (x.equals(raiz.elemento.getNome())) {
			trueOrFalse = true;
			System.out.print("raiz ");
		} else {
			System.out.print("raiz ");
			trueOrFalse = pesquisar(x, raiz);
		}
		if (trueOrFalse == true) {
			System.out.println("SIM");
		} else {
			System.out.println("NAO");
			
		}
		return trueOrFalse;
	}

	/**
	 * Metodo privado recursivo para pesquisar elemento.
	 * 
	 * @param x Elemento que sera procurado.
	 * @param i No em analise.
	 * @return <code>true</code> se o elemento existir, <code>false</code> em caso
	 *         contrario.
	 */
	private boolean pesquisar(String x, No i) {
		boolean resp;
		if (i == null) {
			resp = false;

		} else if (x.compareToIgnoreCase(i.elemento.getNome()) == 0) {
			resp = true;

		} else if (x.compareTo(i.elemento.getNome()) < 0) {
			System.out.print("esq ");
			resp = pesquisar(x, i.esq);

		} else {
			System.out.print("dir ");
			resp = pesquisar(x, i.dir);
		}
		return resp;
	}

	/**
	 * Metodo publico iterativo para exibir elementos.
	 */
	public void caminharCentral() {
		System.out.print("[ ");
		caminharCentral(raiz);
		System.out.println("]");
	}

	/**
	 * Metodo privado recursivo para exibir elementos.
	 * 
	 * @param i No em analise.
	 */
	private void caminharCentral(No i) {
		if (i != null) {
			caminharCentral(i.esq); // Elementos da esquerda.
			System.out.print(i.elemento + " "); // Conteudo do no.
			caminharCentral(i.dir); // Elementos da direita.
		}
	}

	/**
	 * Metodo publico iterativo para exibir elementos.
	 */
	public void caminharPre() {
		System.out.print("[ ");
		caminharPre(raiz);
		System.out.println("]");
	}

	/**
	 * Metodo privado recursivo para exibir elementos.
	 * 
	 * @param i No em analise.
	 */
	private void caminharPre(No i) {
		if (i != null) {
			System.out.print(i.elemento + " "); // Conteudo do no.
			caminharPre(i.esq); // Elementos da esquerda.
			caminharPre(i.dir); // Elementos da direita.
		}
	}

	/**
	 * Metodo publico iterativo para exibir elementos.
	 */
	public void caminharPos() {
		System.out.print("[ ");
		caminharPos(raiz);
		System.out.println("]");
	}

	/**
	 * Metodo privado recursivo para exibir elementos.
	 * 
	 * @param i No em analise.
	 */
	private void caminharPos(No i) {
		if (i != null) {
			caminharPos(i.esq); // Elementos da esquerda.
			caminharPos(i.dir); // Elementos da direita.
			System.out.print(i.elemento + " "); // Conteudo do no.
		}
	}

	/**
	 * Metodo publico iterativo para inserir elemento.
	 * 
	 * @param x Elemento a ser inserido.
	 * @throws Exception Se o elemento existir.
	 */
	public void inserir(Jogador x) throws Exception {
		raiz = inserir(x, raiz);
	}

	/**
	 * Metodo privado recursivo para inserir elemento.
	 * 
	 * @param x Elemento a ser inserido.
	 * @param i No em analise.
	 * @return No em analise, alterado ou nao.
	 * @throws Exception Se o elemento existir.
	 */
	private No inserir(Jogador x, No i) throws Exception {
		if (i == null) {
			i = new No(x);

		} else if (x.getNome().compareTo(i.elemento.getNome()) < 0) {
			i.esq = inserir(x, i.esq);

		} else if (x.getNome().compareTo(i.elemento.getNome()) > 0) {
			i.dir = inserir(x, i.dir);

		} else {
			throw new Exception("Erro ao inserir!");
		}

		return i;
	}

	/**
	 * Metodo publico para inserir elemento.
	 * 
	 * @param x Elemento a ser inserido.
	 * @throws Exception Se o elemento existir.
	 */
	public void inserirPai(Jogador x) throws Exception {
		if (raiz == null) {
			raiz = new No(x);
		} else if (x.getNome().compareTo(raiz.elemento.getNome()) < 0) {
			inserirPai(x, raiz.esq, raiz);
		} else if (x.getNome().compareTo(raiz.elemento.getNome()) > 0) {
			inserirPai(x, raiz.dir, raiz);
		} else {
			throw new Exception("Erro ao inserirPai!");
		}
	}

	/**
	 * Metodo privado recursivo para inserirPai elemento.
	 * 
	 * @param x   Elemento a ser inserido.
	 * @param i   No em analise.
	 * @param pai No superior ao em analise.
	 * @throws Exception Se o elemento existir.
	 */
	private void inserirPai(Jogador x, No i, No pai) throws Exception {
		if (i == null) {
			if (x.getNome().compareTo(i.elemento.getNome()) < 0) {
				pai.esq = new No(x);
			} else {
				pai.dir = new No(x);
			}
		} else if (x.getNome().compareTo(i.elemento.getNome()) < 0) {
			inserirPai(x, i.esq, i);
		} else if (x.getNome().compareTo(i.elemento.getNome()) > 0) {
			inserirPai(x, i.dir, i);
		} else {
			throw new Exception("Erro ao inserirPai!");
		}
	}

	/**
	 * Metodo publico iterativo para remover elemento.
	 * 
	 * @param x Elemento a ser removido.
	 * @throws Exception Se nao encontrar elemento.
	 */
	public void remover(Jogador x) throws Exception {
		raiz = remover(x, raiz);
	}

	/**
	 * Metodo privado recursivo para remover elemento.
	 * 
	 * @param x Elemento a ser removido.
	 * @param i No em analise.
	 * @return No em analise, alterado ou nao.
	 * @throws Exception Se nao encontrar elemento.
	 */
	private No remover(Jogador x, No i) throws Exception {

		if (i == null) {
			throw new Exception("Erro ao remover!");

		} else if (x.getNome().compareTo(i.elemento.getNome()) < 0) {
			i.esq = remover(x, i.esq);

		} else if (x.getNome().compareTo(i.elemento.getNome()) > 0) {
			i.dir = remover(x, i.dir);

			// Sem no a direita.
		} else if (i.dir == null) {
			i = i.esq;

			// Sem no a esquerda.
		} else if (i.esq == null) {
			i = i.dir;

			// No a esquerda e no a direita.
		} else {
			i.esq = antecessor(i, i.esq);
		}

		return i;
	}

	/**
	 * Metodo para trocar no removido pelo antecessor.
	 * 
	 * @param i No que teve o elemento removido.
	 * @param j No da subarvore esquerda.
	 * @return No em analise, alterado ou nao.
	 */
	private No antecessor(No i, No j) {

		// Existe no a direita.
		if (j.dir != null) {
			// Caminha para direita.
			j.dir = antecessor(i, j.dir);

			// Encontrou o maximo da subarvore esquerda.
		} else {
			i.elemento = j.elemento; // Substitui i por j.
			j = j.esq; // Substitui j por j.ESQ.
		}
		return j;
	}

	/**
	 * Metodo publico iterativo para remover elemento.
	 * 
	 * @param x Elemento a ser removido.
	 * @throws Exception Se nao encontrar elemento.
	 */
	public void remover2(Jogador x) throws Exception {
		if (raiz == null) {
			throw new Exception("Erro ao remover2!");
		} else if (x.getNome().compareTo(raiz.elemento.getNome()) < 0) {
			remover2(x, raiz.esq, raiz);
		} else if (x.getNome().compareTo(raiz.elemento.getNome()) > 0) {
			remover2(x, raiz.dir, raiz);
		} else if (raiz.dir == null) {
			raiz = raiz.esq;
		} else if (raiz.esq == null) {
			raiz = raiz.dir;
		} else {
			raiz.esq = antecessor(raiz, raiz.esq);
		}
	}

	/**
	 * Metodo privado recursivo para remover elemento.
	 * 
	 * @param x   Elemento a ser removido.
	 * @param i   No em analise.
	 * @param pai do No em analise.
	 * @throws Exception Se nao encontrar elemento.
	 */
	private void remover2(Jogador x, No i, No pai) throws Exception {
		if (i == null) {
			throw new Exception("Erro ao remover2!");
		} else if (x.getNome().compareTo(i.elemento.getNome()) < 0) {
			remover2(x, i.esq, i);
		} else if (x.getNome().compareTo(i.elemento.getNome()) > 0) {
			remover2(x, i.dir, i);
		} else if (i.dir == null) {
			pai = i.esq;
		} else if (i.esq == null) {
			pai = i.dir;
		} else {
			i.esq = antecessor(i, i.esq);
		}
	}

	public Jogador getRaiz() throws Exception {
		return raiz.elemento;
	}

	public static boolean igual(ArvoreBinaria a1, ArvoreBinaria a2) {
		return igual(a1.raiz, a2.raiz);
	}

	private static boolean igual(No i1, No i2) {
		boolean resp;
		if (i1 != null && i2 != null) {
			resp = (i1.elemento == i2.elemento) && igual(i1.esq, i2.esq) && igual(i1.dir, i2.dir);
		} else if (i1 == null && i2 == null) {
			resp = true;
		} else {
			resp = false;
		}
		return resp;
	}

	public int soma() {
		return soma(raiz);
	}

	public int soma(No i) {
		int resp = 0;
		if (i != null) {
			resp = i.elemento.getAltura() + soma(i.esq) + soma(i.dir);
		}
		return resp;
	}

	public int quantidadePares() {
		return quantidadePares(raiz);
	}

	public int quantidadePares(No i) {
		int resp = 0;
		if (i != null) {
			resp = ((i.elemento.getAltura() % 2 == 0) ? 1 : 0) + quantidadePares(i.esq) + quantidadePares(i.dir);
		}
		return resp;
	}

	public boolean hasDiv11() {
		return hasDiv11(raiz);
	}

	public boolean hasDiv11(No i) {
		boolean resp = false;
		if (i != null) {
			resp = (i.elemento.getAltura() % 11 == 0) || hasDiv11(i.esq) || hasDiv11(i.dir);
		}
		return resp;
	}
}
