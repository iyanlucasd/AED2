public class ex4 {
    public void mostraPilhaRem() {
		System.out.print("[ ");
		mostraPilhaRem(topo);
		System.out.println(" ]");
	}

	private void mostraPilhaRem(Celula i) {
		if (i != null) {
			System.out.print(" " + i.elemento + " ");
			mostraPilhaRem(i.prox);
		}
	}
}
