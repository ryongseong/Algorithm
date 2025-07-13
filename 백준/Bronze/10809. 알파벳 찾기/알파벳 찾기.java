import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int[] alphabetIndices = new int[26];

        Arrays.fill(alphabetIndices, -1);
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            int index = currentChar - 'a';
            if (alphabetIndices[index] == -1) {
                alphabetIndices[index] = i;
            }
        }
        StringBuilder result = new StringBuilder();
        for (int alphabetIndex : alphabetIndices) {
            result.append(alphabetIndex).append(" ");
        }
        System.out.println(result.toString().trim());
    }
}