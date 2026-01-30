/*
    * Domain: Baekjoon Online Judge
    * Problem Number: 5347
    * Problem Name: LCM
    *
    * Date: 2026-01-30
    *
*/

import java.io.*;
import java.math.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        while (n --> 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());

            long gcd = BigInteger.valueOf(a).gcd(BigInteger.valueOf(b)).longValue();
            long lcm = (a / gcd) * b;

            sb.append(lcm).append('\n');
        }
        System.out.print(sb);
    }
}