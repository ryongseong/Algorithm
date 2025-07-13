import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String[] input = br.readLine().split(" ");
            if (input[0].equals("0") && input[1].equals("0") && input[2].equals("0")) {
                break;
            }
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int c = Integer.parseInt(input[2]);

            System.out.println(solve(a, b, c));
        }

    }

    public static String solve(int a, int b, int c) {
        if (Math.pow(a, 2) + Math.pow(b, 2) == Math.pow(c, 2)) {
            return "right";
        } else if (Math.pow(a, 2) + Math.pow(c, 2) == Math.pow(b, 2)) {
            return "right";
        } else if (Math.pow(b, 2) + Math.pow(c, 2) == Math.pow(a, 2)) {
            return "right";
        } else {
            return "wrong";
        }
    }
}