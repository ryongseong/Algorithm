import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        for (int i = 0; i < testCases; i++) {
            int floors = sc.nextInt();
            int roomsPerFloor = sc.nextInt();
            int guestNumber = sc.nextInt();

            int floorNumber = (guestNumber - 1) % floors + 1;
            int roomNumber = (guestNumber - 1) / floors + 1;

            System.out.printf("%d%02d%n", floorNumber, roomNumber);
        }

        sc.close();
    }
}