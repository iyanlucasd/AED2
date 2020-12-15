import java.util.*;

public class q1 {
    static int countDebugger = 0;
    static Scanner input = new Scanner(System.in);

    public static void debugger() {
        System.out.println("chegou " + countDebugger);
    }

    public static int euOdeioJoaozinho(int numCaixas, int numStacks) {
        int stack = 0;
        int stackHeight = 0;
        int stackItemLeft = 0;
        int stackItemEsq = 0;
        int stackItem = 0;
        // System.out.println(numCaixas + " " + numStacks);
        int[] array = new int[numStacks];
        for (int i = 0; i < array.length; i++) {
            array[i] = input.nextInt();
            for (int j = 0; j < array[i]; j++) {
                stackItem = input.nextInt();
                if (stackItem == 1) {
                    // countDebugger++;
                    // debugger();
                    stack = i;
                    stackHeight = j + 1;
                }
            }
        }
        stackItemLeft = array[stack] - stackHeight;
        // countDebugger++;
        // debugger();
        for (int i = stack - 1; i >= 0 && array[i] >= stackHeight; i--) {
            stackItemLeft += (array[i] - stackHeight + 1);
        }
        stackItemEsq = array[stack] - stackHeight;
        for (int i = stack + 1; i < numStacks && array[i] >= stackHeight; i++) {
            stackItemEsq += (array[i] - stackHeight + 1);
        }
        // countDebugger++;
        // debugger();
        return minimoDeCaixas(stackItemLeft, stackItemEsq);
    }

    public static int minimoDeCaixas(int x, int y) {
        // countDebugger++;
        // debugger();
        if (x < y) {
            return x;
        } else {
            return y;
        }
    }
    public static void main(String[] args) {
        int numCaixas = input.nextInt();
        int numStacks = input.nextInt();
        while (numCaixas != 0 || numStacks != 0) {
            System.out.println(euOdeioJoaozinho(numCaixas, numStacks));
            // countDebugger++;
            // debugger();
            numCaixas = input.nextInt();
            numStacks = input.nextInt();
        }
    }
}
