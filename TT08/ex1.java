public class ex1 {

    public static void maiorMenor(int[] array) {
        int menor = array[0];
        int maior = array[0];
        for (int i = 0; i < array.length; i++) {
            if (menor > array[i]) {
                menor = array[i];
            }
            if (maior < array[i]) {
                maior = array[i];
            }
        }
        System.out.println("maior = " + maior);
        System.out.println("menor = " + menor);
    }

    public static void main(String[] args) {
        int[] array = { 2, 3, 4, 8, 9, 12, 33, 1, 4, 6};
        maiorMenor(array);
    }
}