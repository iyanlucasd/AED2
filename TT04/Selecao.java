/**
 * Algoritmo de ordenacao por selecao
 * 
 * @author Max do Val Machado
 * @version 3 08/2020
 */

class Selecao extends Geracao {

    /**
     * Construtor.
     */
    public Selecao() {
        super();
    }

    /**
     * Construtor.
     * 
     * @param int tamanho do array de numeros inteiros.
     */
    public Selecao(int tamanho) {
        super(tamanho);
    }

    /**
     * Algoritmo de ordenacao por selecao.
     */
    @Override
    public void sort() {
        int comparacao = 0;
        int movimentacao = 0;
        for (int i = 0; i < (n - 1); i++) {
            int menor = i;
            for (int j = (i + 1); j < n; j++) {
                if (array[menor] > array[j]) {
                    menor = j;
                }
                comparacao++;
            }
            swap(menor, i);
            movimentacao++;
        }
    }

    public int novoSelecao() {
        int comparacao = 0;
        int movimentacao = 0;

        for (int i = 0; i < array.length - 1; i++) {
            int menor = i;
            for (int j = (i + 1); j < array.length; j++) {
                if (array[menor] > array[j]) {
                    menor = j;
                }
                comparacao++;
            }
            swap(menor, i);
            movimentacao++;
        }
        return movimentacao;
    }

}
