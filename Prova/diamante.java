import java.util.Scanner;

public class diamante {

    public static void count(String s) {
        int rcount = 0;
        int lcount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '<') {
                lcount++;
            }
            else if (s.charAt(i) == '>') {
                rcount++;
            }
        }
        if (lcount > rcount) {
            System.out.println(rcount);
        } else if (rcount > lcount) {
            System.out.println(lcount);
        } else {
            System.out.println(rcount);
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = "<<<..<......<<<<....>";
        int entrada = input.nextInt();
        input.nextLine();
        while (entrada > 0) {
            // System.out.println("s1");
            s = input.nextLine();
            // System.out.println(s);
            count(s);
            // System.out.println("s2");
            entrada--;
        }
    }

}