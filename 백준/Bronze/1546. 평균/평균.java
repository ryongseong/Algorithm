import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] scores = br.readLine().split(" ");

        double maxScore = 0;
        double sum = 0;
        for (String score : scores) {
            double currentScore = Double.parseDouble(score);
            if (currentScore > maxScore) {
                maxScore = currentScore;
            }
            sum += currentScore;
        }
        double average = (sum / maxScore) * 100 / n;
        System.out.printf("%.2f%n", average);
    }
}