import java.io.*;
import java.lang.*;
import java.util.Scanner;

public class heapEx4 {

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        boolean flag = true;
        while (flag == true) {
            int[] heap = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
            int n = input.nextInt();
            do {
                n/=2;
                System.out.println(heap[n]);
            } while (n > 0);
        }
    }
}