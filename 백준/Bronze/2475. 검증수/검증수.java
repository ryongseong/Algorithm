import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] parts = input.split(" ");
        int n = 0;

        for (String part : parts) {
            n += (int) Math.pow(Integer.parseInt(part), 2);
        }

        System.out.printf("%d\n", n%10);
    }
}