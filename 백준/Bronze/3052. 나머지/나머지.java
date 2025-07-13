import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];
        boolean[] result = new boolean[42];

        for (int i = 0; i < 10; i++) {
            arr[i] = sc.nextInt() % 42;
        }

        for (int i = 0; i < 10; i++) {
            result[arr[i]] = true;
        }

        int count = 0;
        for (int i = 0; i < 42; i++) {
            if (result[i]) {
                count++;
            }
        }

        System.out.println(count);
    }
}