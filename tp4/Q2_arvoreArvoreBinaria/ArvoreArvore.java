class no {
	public int x; // x inserido na celula.
	public no esq, dir; // Filhos da esq e dir.
	public no2 nohDois;

	public no(int x) {
		this.x = x;
		this.esq = this.dir = null;
		this.nohDois = null;
	}

	public no(int x, no esq, no dir, no2 nohDois) {
		this.x = x;
		this.esq = esq;
		this.dir = dir;
		this.nohDois = nohDois;
	}

}

class no2 {
	public String x; 
	public no2 esq; 
	public no2 dir; 

	no2(String x) {
		this.x = x;
		this.esq = this.dir = null;
	}

	no2(String x, no2 esq, no2 dir) {
		this.x = x;
		this.esq = esq;
		this.dir = dir;
	}
}

class ArvoreArvore {
	private no raiz; 

	public ArvoreArvore() {
		raiz = null;
	}

	public boolean pesquisar(String x) {

		if (raiz != null) {
			System.out.print(" raiz");
		}
		return pesquisar(x, raiz);
	}

	private boolean pesquisar(String x, no i) {
		boolean resp = false;
		if (i != null) {

			resp = pesquisar2(x, i.nohDois);

			if (resp == false) {
				System.out.print(" esq");
				resp = pesquisar(x, i.esq);
			}
			if (resp == false) {
				System.out.print(" dir");
				resp = pesquisar(x, i.dir);
			}
		}

		return resp;
	}

	private boolean pesquisar2(String x, no2 i) {
		boolean resp = false;
		if (i != null) {

			if (x.compareTo(i.x) == 0) {
				resp = true;

			} else {

				System.out.print(" ESQ");
				resp = pesquisar2(x, i.esq);

				if (resp == false) {
					System.out.print(" DIR");
					resp = pesquisar2(x, i.dir);
				}
			}
		}
		return resp;
	}

	public void inserir(int x) throws Exception {
		raiz = inserir(x, raiz);
	}

	private no inserir(int x, no i) throws Exception {
		if (i == null) {
			i = new no(x);
		} else if (x < i.x) {
			i.esq = inserir(x, i.esq);

		} else if (x > i.x) {
			i.dir = inserir(x, i.dir);

		} else {
			throw new Exception("Erro ao inserir!");
		}

		return i;
	}

	public void inserir2(String x, int y) throws Exception {
		inserir2(x, y, raiz);
	}

	private void inserir2(String x, int y, no i) throws Exception {
		if (i.x == y) {
			i.nohDois = inserir3(x, i.nohDois);
		} else if (y < i.x) {
			inserir2(x, y, i.esq);

		} else if (y > i.x) {
			inserir2(x, y, i.dir);

		} else {
			throw new Exception("Erro ao inserir!");
		}

	}

	private no2 inserir3(String x, no2 i) throws Exception {

		if (i == null) {
			i = new no2(x);
		} else if (x.compareTo(i.x) < 0)
			i.esq = inserir3(x, i.esq);
		else if (x.compareTo(i.x) > 0)
			i.dir = inserir3(x, i.dir);
		else {
			throw new Exception("Erro ao inserir!");
		}
		return i;

	}

}