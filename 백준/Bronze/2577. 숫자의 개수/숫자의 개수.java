import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());
        long result = (long) A * B * C;

        int[] numbers = new int[10];
        String productString = Long.toString(result);
        for (char digit : productString.toCharArray()) {
            numbers[digit - '0']++;
        }
        StringBuilder output = new StringBuilder();
        for (int number : numbers) {
            output.append(number).append("\n");
        }
        System.out.print(output.toString());
    }
}