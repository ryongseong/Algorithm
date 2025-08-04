import java.io.*;
import java.util.*;

public class Main {
    public static Long[] dp = new Long[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        dp[0] = 0L;
        dp[1] = 1L;
        dp[2] = 1L;
        dp[3] = 1L;

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            System.out.println(solve(N));
        }
    }

    public static long solve(int N) {
        if (dp[N] == null) {
            dp[N] = solve(N-2) + solve(N-3);
        }
        return dp[N];
    }
}