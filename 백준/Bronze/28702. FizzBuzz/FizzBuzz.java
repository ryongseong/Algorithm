import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 0;
        for (int i = 3; i > 0; i--) {
            String x = sc.nextLine();
            if (!x.equals("Fizz") && !x.equals("Buzz") && !x.equals("FizzBuzz")) {
                n = Integer.parseInt(x) + i;
                break;
            }
        }
        System.out.println((n % 3 == 0 ? "Fizz" : "") + (n % 5 == 0 ? "Buzz" : "") + (n % 3 != 0 && n % 5 != 0 ? n : ""));
    }
}