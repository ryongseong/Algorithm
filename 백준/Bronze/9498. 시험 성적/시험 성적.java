import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        if (N / 10 >= 9) {
            System.out.println("A");
        } else if (N / 10 >= 8) {
            System.out.println("B");
        } else if (N / 10 >= 7) {
            System.out.println("C");
        } else if (N / 10 >= 6) {
            System.out.println("D");
        } else {
            System.out.println("F");
        }
    }
}