import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int X = sc.nextInt();
        sc.nextLine();
        String input = sc.nextLine();

        ArrayList<Integer> numbers = new ArrayList<>();

        for (String s : input.split(" ")) {
            if (Integer.parseInt(s) < X) {
                numbers.add(Integer.parseInt(s));
            }
        }

        for (int i : numbers) {
            System.out.print(i + " ");
        }
    }
}

