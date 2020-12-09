import java.io.*;

/**
 * Arvore binaria de pesquisa
 * 
 * @author Max do Val Machado
 */
class ArvoreBinaria {
	private No raiz; // Raiz da arvore.

	/**
	 * Construtor da classe.
	 */
	public ArvoreBinaria() {
		raiz = null;
	}

	public boolean pesquisar(Jogador x) {
		return pesquisar(x, raiz);
	}

	private boolean pesquisar(Jogador x, No i) {

		boolean resp;
		if (i == null) {
			resp = false;
		} else {
			if (x.getNome().compareTo(i.elemento.getNome()) == 0) {
				resp = true;
			} else {
				if (x.getNome().compareTo(i.elemento.getNome()) < 0) {
					resp = pesquisar(x, i.esq);

				} else {
					resp = pesquisar(x, i.dir);
				}

			}

		}
		return resp;
	}

	/**
	 * Metodo publico iterativo para exibir elementos.
	 */
	public void caminharCentral() {
		caminharCentral(raiz);
	}

	private void caminharCentral(No i) {
		if (i != null) {
			caminharCentral(i.esq); // Elementos da esquerda.
			System.out.println(i.elemento.getNome() + " "); // Conteudo do no.
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

class No {
	public Jogador elemento; // Conteudo do no.
	public No esq, dir; // Filhos da esq e dir.

	/**
	 * Construtor da classe.
	 * 
	 * @param elemento Conteudo do no.
	 */
	public No(Jogador elemento) {
		this(elemento, null, null);
	}

	/**
	 * Construtor da classe.
	 * 
	 * @param elemento Conteudo do no.
	 * @param esq      No da esquerda.
	 * @param dir      No da direita.
	 */
	public No(Jogador elemento, No esq, No dir) {
		this.elemento = elemento;
		this.esq = esq;
		this.dir = dir;
	}
}

class Jogador {
	public static Jogador[] array = new Jogador[1024];
	public static int countGlobal = 0;

	// variaveis
	private int id = 0;
	private String nome = "";
	private int altura = 0;
	private int peso = 0;
	private String universidade = "";
	private String anoNascimento = "";
	private String cidadeNascimento = "";
	private String estadoNascimento = "";

	// construtores
	public Jogador() {
		this.id = 0;
		this.nome = "";
		this.altura = 0;
		this.peso = 0;
		this.universidade = "";
		this.anoNascimento = "";
		this.cidadeNascimento = "";
		this.estadoNascimento = "";
	}

	public Jogador(int id, String nome, int altura, int peso, String universidade, String anoNascimento,
			String cidadeNascimento, String estadoNascimento) {
		this.id = 0;
		this.nome = "";
		this.altura = 0;
		this.peso = 0;
		this.universidade = "";
		this.anoNascimento = "";
		this.cidadeNascimento = "";
		this.estadoNascimento = "";
	}

	// set
	public void setId(int id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public void setUniversidade(String universidade) {
		this.universidade = universidade;
	}

	public void setAnoNascimento(String anoNascimento) {
		this.anoNascimento = anoNascimento;
	}

	public void setCidadeNascimento(String cidadeNascimento) {
		this.cidadeNascimento = cidadeNascimento;
	}

	public void setEstadoNascimento(String estadoNascimento) {
		this.estadoNascimento = estadoNascimento;
	}

	// get
	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public int getAltura() {
		return altura;
	}

	public int getPeso() {
		return peso;
	}

	public String getUniversidade() {
		return universidade;
	}

	public String getAnoNascimento() {
		return anoNascimento;
	}

	public String getCidadeNascimento() {
		return cidadeNascimento;
	}

	public String getEstadoNascimento() {
		return estadoNascimento;
	}

	// clone
	protected Jogador clone() {
		Jogador clone = new Jogador(this.id, this.nome, this.altura, this.peso, this.universidade, this.anoNascimento,
				this.cidadeNascimento, this.estadoNascimento);
		return clone;
	}

	// imprimir
	public void imprimir() {
		System.out.print("## ");
		System.out.print(getNome());
		System.out.print(" ## ");
		System.out.print(getAltura());
		System.out.print(" ## ");
		System.out.print(getPeso());
		System.out.print(" ## ");
		System.out.print(getAnoNascimento());
		System.out.print(" ## ");
		System.out.print(getUniversidade());
		System.out.print(" ## ");
		System.out.print(getCidadeNascimento());
		System.out.print(" ## ");
		System.out.print(getEstadoNascimento());
		System.out.println(" ##");
	}

	public void tratamento(String s) {
		s = s.replaceAll(",,", ",nao informado,");
		int aux = s.length();
		if (s.charAt(aux - 1) == ',') {
			s += "nao informado";
		}

		String[] sSplit = s.split(",");
		if (sSplit[0] != null) {
			int ID = Integer.parseInt(sSplit[0]);
			array[countGlobal].setId(ID);
			array[countGlobal].setNome(sSplit[1]);
			int height = Integer.parseInt(sSplit[2]);
			array[countGlobal].setAltura(height);
			int weight = Integer.parseInt(sSplit[3]);
			array[countGlobal].setPeso(weight);
			array[countGlobal].setUniversidade(sSplit[4]);
			array[countGlobal].setAnoNascimento(sSplit[5]);
			array[countGlobal].setCidadeNascimento(sSplit[6]);
			array[countGlobal].setEstadoNascimento(sSplit[7]);
		}

	}

	public void ler(String id) throws Exception {
		String s = "";
		BufferedReader file = new BufferedReader(
				new InputStreamReader(new FileInputStream("/tmp/players.csv"), "UTF8"));

		s = file.readLine();
		while (s != null) {
			String[] sSplit = s.split(",");
			if (sSplit[0].equals(id) == true) {
				tratamento(s);
			}
			s = file.readLine();
		}
	}
}

public class q5 extends Jogador {

	public static Jogador pesquisar(String key) throws Exception {
		array[countGlobal] = new Jogador();
		array[countGlobal].ler(key);
		// array[countGlobal].imprimir();
		countGlobal++;
		// achei.imprimir();
		return array[countGlobal - 1];
	}

	public static void main(String[] args) throws Exception {
		String[] arrayID = new String[1024];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in, "ISO-8859-1"));
		arrayID[countGlobal] = br.readLine();
		while (arrayID[countGlobal].equals("FIM") == false) {
			// System.out.println(arrayID[countGlobal]);
			array[countGlobal] = new Jogador();
			array[countGlobal].ler(arrayID[countGlobal]);
			// array[countGlobal].imprimir();
			countGlobal++;
			arrayID[countGlobal] = br.readLine();
		}
		// System.out.println("chegou");
		ArvoreBinaria arvore = new ArvoreBinaria();
		for (int i = 0; i < countGlobal; i++) {
			if (arvore.pesquisar(array[i]) == false) {
				arvore.inserir(array[i]);
			}
		}
		String arrayOps[] = new String[1024];
		int count = 0;
		arrayOps[count] = br.readLine();
		while (arrayOps[count].equals("FIM") == false) {
			// System.out.println("chegou");
			count++;
			arrayOps[count] = br.readLine();
		}
			arvore.caminharCentral();

	}
}
