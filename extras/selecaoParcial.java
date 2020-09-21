public class selecaoParcial {
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void sort(int[] array, int n, int k) {
        for (int i = 0; i < (n - 1); i++) {
            int menor = i;
            for (int j = (i + 1); j < n; j++) {
                if (array[menor] > array[j]) {
                    menor = j;
                }
            }
            if (i < k) {
                swap(array, menor, i);
            } else {
                i = n;
            }
        }
    }

    public static void mostrar(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print("[" + array[i] + "]");
        }
    }

    public static void main(String[] args) {
        int[] array = { 11, 2, 3, 4, 23, 4345, 56, 0 };
        sort(array, array.length, 3);
        mostrar(array);
    }
}
