public class insercaoParcial {

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void sort(int[] array, int n, int k) {
        for (int i = 1; i < n; i++) { // for percorre n-1
            int tmp = array[i];
            int j = (i<k)? i-1: k-1;
                while ((j >= 0) && (array[j] > tmp)) {
                    array[j + 1] = array[j];
                    j--;
                }
                array[j + 1] = tmp;


        }
    }

    public static void mostrar(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print("[" + array[i] + "]");
        }
    }

    public static void main(String[] args) {
        int[] array = { 11, 4, 3, 7, 23, 4345, 56, 0 };
        sort(array, array.length, 4);
        mostrar(array);
    }

}
