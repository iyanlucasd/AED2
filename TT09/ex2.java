public class ex2 {
    public static void shift(int[] array, int dir) {
        if (dir == 0) {
            for (int i = 0; i < array.length - 1; i++) {
                array[i] = array[i + 1];
            }
            array[array.length - 1] = 0;
        } else {
            for (int i = array.length - 2; i > 0; i--) {
                array[i + 1] = array[i];
            }
            array[1] = array[0];
            array[0] = 0;
        }
    }

    public static void mostrar(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println();
    }

    public static void inicialisadorArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = 0;
        }
        mostrar(array);
    }

    public static void remEsq(int[] array) {
        if (array[0] == 0) {
            System.out.println("ERRO! Underflow");
        } else {
            array[0] = 0;
            shift(array, 0);
            mostrar(array);
        }
    }

    public static void remDir(int[] array) {
        if (array[array.length - 1] == 0) {
            System.out.println("ERRO! Underflow");
        } else {
            array[array.length - 1] = 0;
            shift(array, 1);
            mostrar(array);
        }
    }

    public static void InsEsq(int[] array, int n) {
        if (array[0] != 0) {
            if (array[array.length - 1] != 0) {
                System.out.println("ERRO! Overflow");
            } else {
                shift(array, 1);
                array[0] = n;
                mostrar(array);
            }
        } else {
            if (array[array.length - 1] != 0) {
                array[0] = n;
                mostrar(array);
            } else {
                array[0] = n;
                mostrar(array);
            }
        }
    }

    public static void InsDir(int[] array, int n) {
        if (array[array.length - 1] != 0) {
            if (array[0] != 0) {
                System.out.println("ERRO! Overflow");
            } else {
                shift(array, 0);
                array[array.length - 1] = n;
                mostrar(array);
            }
        } else {
            if (array[0] != 0) {
                array[array.length - 1] = n;
                mostrar(array);
            } else {
                array[array.length - 1] = n;
                mostrar(array);
            }
        }
    }

    public static void main(String[] args) {
        int[] array = { 0, 10, 2, 3, 44, 5, 5, 7, 8, 1 };
        // inicialisadorArray(array);
        InsDir(array, 77);
    }
}