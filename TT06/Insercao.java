/**
 * Algoritmo de ordenacao por insercao
 * 
 * @author Max do Val Machado
 * @version 3 01/2020
 */

class Insercao extends Geracao {

   /**
    * Construtor.
    */
   public Insercao() {
      super();
   }

   /**
    * Construtor.
    * 
    * @param int tamanho do array de numeros inteiros.
    */
   public Insercao(int tamanho) {
      super(tamanho);
   }

   public int binario(int[] array, int menor, int maior, int key) {
      int meio = (maior + menor) / 2;
      if (menor >= maior) {
         return (key > array[menor]) ? (menor + 1) : menor;

      } else if (array[meio] < key) {
         return binario(array, meio + 1, maior, key);
      } else if (array[meio] > key) {
         return binario(array, menor, meio - 1, key);
      } else {
         return meio + 1;
      }
   }

   /**
    * Algoritmo de ordenacao por insercao.
    */
   @Override
   public void sort() {
      for (int i = 1; i < n; i++) {
         int tmp = array[i];
         int j = i - 1;
         int location = binario(array, 0, j, tmp);
         while (j >= location) {
            array[j + 1] = array[j];
            j--;
         }
         array[j + 1] = tmp;
      }
   }
}
