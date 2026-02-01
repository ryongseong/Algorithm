/*
 * Domain: Baekjoon Online Judge
 * Problem Number: 22193
 * Problem Name: Multiply
 *
 * Date: 2026-02-02
 *
 */

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());

        int result = A * B;

        System.out.println(result);
    }
}