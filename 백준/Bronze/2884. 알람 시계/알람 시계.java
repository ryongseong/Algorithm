import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] parts = sc.nextLine().split(" ");
        int hour = Integer.parseInt(parts[0]);
        int minute = Integer.parseInt(parts[1]);

        if (minute < 45) {
            if (hour == 0) {
                hour = 23;
            } else {
                hour -= 1;
            }
            minute += 60;
        }
        System.out.printf("%d %d\n", hour, minute - 45);
    }
}