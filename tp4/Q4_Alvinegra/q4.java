import java.io.*;

class No {
	public boolean cor;
	public Jogador x;
	public No esq, dir;

	public No() {
	}

	public No(Jogador x) {
		this(x, false, null, null);
	}

	public No(Jogador x, boolean cor) {
		this(x, cor, null, null);
	}

	public No(Jogador x, boolean cor, No esq, No dir) {
		this.cor = cor;
		this.x = x;
		this.esq = esq;
		this.dir = dir;
	}
}

class ArvoreAlvinegra {
	private No raiz; // Raiz da arvore.

	public ArvoreAlvinegra() {
		raiz = null;
	}

	public boolean pesquisar(Jogador x) {
		return pesquisar(x, raiz);
	}

	private boolean pesquisar(Jogador x, No i) {
		boolean resp;
		if (i == null) {
			resp = false;
		} else if (x.getNome().compareTo(i.x.getNome()) == 0) {
			resp = true;

		} else if (x.getNome().compareTo(i.x.getNome()) < 0) {
			resp = pesquisar(x, i.esq);

		} else {
			resp = pesquisar(x, i.dir);
		}
		return resp;
	}

	public boolean pesquisar2(String x) {
		System.out.print(" raiz");
		return pesquisar2(x, raiz);
	}

	private boolean pesquisar2(String x, No i) {
		boolean resp;
		if (i == null) {
			resp = false;
		} else if (x.compareTo(i.x.getNome()) == 0) {
			resp = true;

		} else if (x.compareTo(i.x.getNome()) < 0) {
			System.out.print(" esq");
			resp = pesquisar2(x, i.esq);

		} else {
			System.out.print(" dir");
			resp = pesquisar2(x, i.dir);
		}
		return resp;
	}

	public void inserir(Jogador x) throws Exception {

		if (raiz == null) {
			raiz = new No(x, false);
		} else if (raiz.esq == null && raiz.dir == null) {
			if (raiz.x.getNome().compareTo(x.getNome()) > 0) {
				raiz.esq = new No(x, true);
			} else {
				raiz.dir = new No(x, true);
			}

		} else if (raiz.esq == null) {
			if (raiz.x.getNome().compareTo(x.getNome()) > 0) {
				raiz.esq = new No(x);
			} else if (raiz.dir.x.getNome().compareTo(x.getNome()) > 0) {
				raiz.esq = new No(raiz.x);
				raiz.x = x;
			} else {
				raiz.esq = new No(raiz.x);
				raiz.x = raiz.dir.x;
				raiz.dir.x = x;
			}
			raiz.esq.cor = raiz.dir.cor = false;
		} else if (raiz.dir == null) {
			if (raiz.x.getNome().compareTo(x.getNome()) < 0) {
				raiz.dir = new No(x);
			} else if (raiz.esq.x.getNome().compareTo(x.getNome()) < 0) {
				raiz.dir = new No(raiz.x);
				raiz.x = x;
			} else {
				raiz.dir = new No(raiz.x);
				raiz.x = raiz.esq.x;
				raiz.esq.x = x;
			}

			raiz.esq.cor = raiz.dir.cor = false;
		} else {
			inserir(x, null, null, null, raiz);
		}

		raiz.cor = false;
	}

	private void balancear(No bisavo, No avo, No pai, No i) {

		// Se o pai tambem e preto, reequilibrar a arvore, rotacionando o avo
		if (pai.cor == true) {

			// 4 tipos de reequilibrios e acoplamento
			if (pai.x.getNome().compareTo(avo.x.getNome()) > 0) {
				if (i.x.getNome().compareTo(pai.x.getNome()) > 0) {
					avo = rotacaoEsq(avo);
				} else {
					avo = rotacaoDirEsq(avo);
				}

			} else { // rotacao a direita ou esquerda-direita
				if (i.x.getNome().compareTo(pai.x.getNome()) < 0) {
					avo = rotacaoDir(avo);
				} else {
					avo = rotacaoEsqDir(avo);
				}
			}

			if (bisavo == null) {
				raiz = avo;
			} else {
				if (avo.x.getNome().compareTo(bisavo.x.getNome()) < 0) {
					bisavo.esq = avo;
				} else {
					bisavo.dir = avo;
				}
			}
			avo.cor = false;
			avo.esq.cor = avo.dir.cor = true;
		}
	}

	private void inserir(Jogador x, No bisavo, No avo, No pai, No i) throws Exception {
		if (i == null) {
			if (x.getNome().compareTo(pai.x.getNome()) < 0) {
				i = pai.esq = new No(x, true);
			} else {
				i = pai.dir = new No(x, true);
			}
			if (pai.cor == true) {
				balancear(bisavo, avo, pai, i);
			}
		} else {
			if (i.esq != null && i.dir != null && i.esq.cor == true && i.dir.cor == true) {
				i.cor = true;
				i.esq.cor = i.dir.cor = false;
				if (i == raiz) {
					i.cor = false;
				} else if (pai.cor == true) {
					balancear(bisavo, avo, pai, i);
				}
			}
			if (x.getNome().compareTo(i.x.getNome()) < 0) {
				inserir(x, avo, pai, i, i.esq);
			} else if (x.getNome().compareTo(i.x.getNome()) > 0) {
				inserir(x, avo, pai, i, i.dir);
			} else {
			}
		}
	}

	private No rotacaoDir(No no) {
		No noEsq = no.esq;
		No noEsqDir = noEsq.dir;

		noEsq.dir = no;
		no.esq = noEsqDir;

		return noEsq;
	}

	private No rotacaoEsq(No no) {
		No noDir = no.dir;
		No noDirEsq = noDir.esq;

		noDir.esq = no;
		no.dir = noDirEsq;
		return noDir;
	}

	private No rotacaoDirEsq(No no) {
		no.dir = rotacaoDir(no.dir);
		return rotacaoEsq(no);
	}

	private No rotacaoEsqDir(No no) {
		no.esq = rotacaoEsq(no.esq);
		return rotacaoDir(no);
	}
}

// -------------------------------------------------------------

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

public class q4 extends Jogador {

	public static Jogador pesquisar(String key) throws Exception {
		array[countGlobal] = new Jogador();
		array[countGlobal].ler(key);
		// array[countGlobal].imprimir();
		countGlobal++;
		// achei.imprimir();
		return array[countGlobal - 1];
	}

	public static void main(String[] args) throws Exception {
		String arrayID = "";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in, "ISO-8859-1"));
		arrayID = br.readLine();
		while (arrayID.equals("FIM") == false) {
			array[countGlobal] = new Jogador();
			array[countGlobal].ler(arrayID);
			// array[countGlobal].imprimir();
			countGlobal++;
			arrayID = br.readLine();
		}
		// System.out.println("chegou");
		ArvoreAlvinegra arvore = new ArvoreAlvinegra();
		for (int i = 0; i < countGlobal; i++) {
			arvore.inserir(array[i]);
		}
		String arrayOps[] = new String[1024];
		int count = 0;
		arrayOps[count] = br.readLine();
		while (arrayOps[count].equals("FIM") == false) {
			// System.out.println("chegou");
			count++;
			arrayOps[count] = br.readLine();
		}
		for (int i = 0; i < count; i++) {
			System.out.print(arrayOps[i]);
			if (arvore.pesquisar2(arrayOps[i]) == true) {
				System.out.print(" SIM");
				System.out.println();
			} else {
				System.out.print(" NAO");
				System.out.println();
			}
		}

	}
}
