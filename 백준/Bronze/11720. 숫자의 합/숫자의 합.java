import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        String S = sc.next();

        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += S.charAt(i) - '0';
        }
        System.out.println(sum);
    }
}