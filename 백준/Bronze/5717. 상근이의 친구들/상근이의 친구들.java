/*
    * Domain: Baekjoon Online Judge
    * Problem Number: 5717
    * Problem Name: 상근이의 친구들
    *
    * Date: 2026-01-24
    *
*/

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a == 0 && b == 0) break;
            sb.append(a + b).append('\n');
        }

        System.out.print(sb);
    }
}