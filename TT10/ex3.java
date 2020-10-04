public class ex3 extends Pilha{
    public void getMaxRec() {
		Celula i = topo;
		System.out.println(MaxRec(i, 0));
	}

	public int MaxRec(Celula i, int max) {
		if (i != null) {
			if (max < i.elemento) {
				return MaxRec(i.prox, i.elemento);
			} else {
				return MaxRec(i.prox, max);
			}
		}
		return max;
	}
}
