public class ex6 {
    public void mostraPilhaIterativo() {
		int array[] = new int[6];
		int j = 0;
		Celula i = topo;
		array[j] = i.elemento;
		for (; i != null; i = i.prox) {
			array[j] = i.elemento;
			j++;
		}
		System.out.print("[ ");
		for (j = array.length - 1; j >= 0; j--) {
			System.out.print(" " + array[j] + " ");
		}
		System.out.println(" ]");

	}
}
