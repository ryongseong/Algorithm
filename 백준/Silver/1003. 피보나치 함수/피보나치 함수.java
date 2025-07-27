import java.io.*;
import java.util.*;

public class Main {
    static int zeroCount;
    static int oneCount;
    static int zeroPlusOne;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            fibonacci(N);
            sb.append(zeroCount).append(" ").append(oneCount).append("\n");
        }
        System.out.println(sb);
    }

    public static void fibonacci(int n) {
        zeroCount = 1;
        oneCount = 0;
        zeroPlusOne = 1;

        for (int i = 0; i < n; i++) {
            zeroCount = oneCount;
            oneCount = zeroPlusOne;
            zeroPlusOne = zeroCount + oneCount;
        }
    }
}