/**
 * Celula Dupla (lista dupla dinamica)
 * @author Max do Val Machado
 * @version 2 01/2015
 */
class CelulaDupla {
	public Jogador elemento;
	public CelulaDupla ant;
	public CelulaDupla prox;

	/**
	 * Construtor da classe.
	 */


	/**
	 * Construtor da classe.
	 * @param elemento int inserido na celula.
	 */
	public CelulaDupla(Jogador elemento) {
		this.elemento = elemento;
		this.ant = this.prox = null;
	}
}
