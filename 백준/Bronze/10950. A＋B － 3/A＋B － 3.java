import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        int x, y;

        for (int i = 0; i < T; i++) {
            x = sc.nextInt();
            y = sc.nextInt();

            System.out.printf("%d\n", x + y);
            sc.nextLine();
        }
    }
}