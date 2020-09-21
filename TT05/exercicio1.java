import java.util.*;

public class exercicio1 {

    public static int somatorioPA(double a, double b, int n) {
        int resultado = 0;
        int aux = 0;
        for (int i = 0; i <= n; i++) {
            aux = (int)a + (i * (int)b);
            resultado = resultado + aux;
        }
        return resultado;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double a = input.nextDouble();
        double b = input.nextDouble();
        int n = input.nextInt();
        System.out.println(somatorioPA(a, b, n));
    }
}