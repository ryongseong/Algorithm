import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.nextLine();
        String B = sc.nextLine();
        int C = sc.nextInt();

        int numResult = 0;
        int stringResult = 0;

        numResult = Integer.parseInt(A) + Integer.parseInt(B) - C;
        stringResult = Integer.parseInt(A + B) - C;

        System.out.println(numResult);
        System.out.println(stringResult);
    }
}