public class ex1 {

    public static void main(String[] args) {
        int mov = 0;
        int[] array = new int [10];
        int n = array.length;

        for (int i = 0; i < (n - 1); i++) {
            int menor = i;

            for (int j = (i + 1); j < n; j++) {
                if (array[menor] > array[j]) {
                    menor = j;
                }
            }
            //swap(menor, i);
            mov += 3;
        }
        System.out.println(mov);
    }
}