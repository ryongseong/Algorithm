/*
 * Domain: Baekjoon Online Judge
 * Problem Number: 11382
 * Problem Name: 꼬마 정민
 *
 * Date: 2026-03-28
 *
 */

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long c = Long.parseLong(st.nextToken());
        
        sb.append(a + b + c);

        System.out.print(sb);
    }
}