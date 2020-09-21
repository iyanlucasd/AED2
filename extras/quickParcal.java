public class quickParcal {
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void quicksort(int[] array, int esq, int dir, int k) {
        int i = esq, j = dir;
        int pivo = array[(dir + esq) / 2];
        while (i <= j) {
            while (array[i] < pivo)
                i++;
            while (array[j] > pivo)
                j--;
            if (i <= j) {
                swap(array, i, j);
                i++;
                j--;
            }
        }
        if (esq < j)
            quicksort(array, esq, j, k);
        if (i < k && i < dir) {
            quicksort(array, i, dir, k);
        }
    }

    public static void mostrar(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print("[" + array[i] + "]");
        }
    }

    public static void main(String[] args) {
        int[] array = { 11, 4, 3, 7, 23, 4345, 56, 0 };
        quicksiort(array, 0, array.length - 1, 4);
        mostrar(array);
    }

}
