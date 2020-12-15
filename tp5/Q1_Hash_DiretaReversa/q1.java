import java.io.*;

class Hash {
	Jogador tabela[];
	int m1, m2, m, reserva;
	int NULO = -1;

	public Hash() {
		this(13, 7);
	}

	public Hash(int m1, int m2) {
		this.m1 = m1;
		this.m2 = m2;
		this.m = m1 + m2;
		this.tabela = new Jogador[this.m];
		for (int i = 0; i < m; i++) {
			tabela[i] = null;
		}
		reserva = 0;
	}

	public int h(int elemento) {
		return elemento % m1;
	}

	public boolean inserir(Jogador elemento) {
		boolean resp = false;

		if (elemento != null) {
			int pos = h(elemento.getAltura());
			if (tabela[pos] == null) {
				tabela[pos] = elemento;
				resp = true;
			} else if (reserva < m2) {
				tabela[m1 + reserva] = elemento;
				reserva++;
				resp = true;
			}
		}

		return resp;
	}

	public boolean pesquisar(String elemento, int altura) {
		boolean resp = false;

		int pos = h(altura);
		if (tabela[pos].getNome().equals(elemento)) {
			// System.out.println("chegou");
			resp = true;

		} else {
			for (int i = 0; i < reserva; i++) {
				if (tabela[m1 + i].getNome().equals(elemento)) {
					resp = true;
					i = reserva;
				}
			}
			// System.out.println("---------------------");
			// System.out.println(tabela[pos].getNome());
			// System.out.println(elemento);
			// System.out.println("---------------------");
		}
		return resp;
	}

	boolean remover(int elemento) {
		boolean resp = false;

		// ...

		return resp;
	}
}

// -----------------HASH------------------
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

public class q1 extends Jogador {

	public static int pesquisaJooj(String key) throws Exception {
		boolean pos = false;
		int position = 0;
		for (int i = 0; i < countGlobal; i++) {
			if (array[i].getNome().equalsIgnoreCase(key)) {
				position = i;
				i = countGlobal;
				pos = true;
			}
		}
		if (pos == true) {
			// System.out.println(array[position].getNome());
			return array[position].getAltura();
		} else {
			return 1;
		}
		// array[pos].imprimir();
	}

	public static void main(String[] args) throws Exception {
		String[] arrayID = new String[1024];
		int countId = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in, "ISO-8859-1"));
		arrayID[countId] = br.readLine();
		while (arrayID[countId].equals("FIM") == false) {
			array[countGlobal] = new Jogador();
			array[countGlobal].ler(arrayID[countId]);
			// array[countGlobal].imprimir();
			countGlobal++;
			countId++;
			arrayID[countId] = br.readLine();
		}
		// System.out.println("chegou");
		int tamTab = 21;
		int tamReserva = 9;
		Hash table = new Hash(tamTab, tamReserva);
		for (int i = 0; i < countGlobal; i++) {
			table.inserir(array[i]);
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
			// System.out.println(arrayOps[i]);
			System.out.print(arrayOps[i] + " "
					+ (table.pesquisar(arrayOps[i], pesquisaJooj(arrayOps[i])) != false ? "SIM" : "NAO"));
			System.out.println();
		}

	}
}
