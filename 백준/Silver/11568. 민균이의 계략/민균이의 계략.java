/*
 * Domain: Baekjoon Online Judge
 * Problem Number: 11568
 * Problem Name: 민균이의 계략
 *
 * Date: 2026-02-03
 *
 */

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        int[] dp = new int[N];

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = 1;

        for (int i = 1; i < N; i++) {
            dp[i] = 1;
            for(int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int result = Arrays.stream(dp).max().getAsInt();

        System.out.println(result);
        
    }
}