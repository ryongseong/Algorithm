/*
    * Domain: Baekjoon Online Judge
    * Problem Number: 2493
    * Problem Name: 탑
    *
    * Date: 2026-01-25
    *
*/

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 탑의 수 N
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 탑들에 대한 정보를 담을 스택 (높이, 인덱스)
        Stack<int[]> tops = new Stack<>();

        for (int i = 1; i <= N; i++) {
            int height = Integer.parseInt(st.nextToken());

            // 현재 탑보다 높은 탑이 나올 때까지 스택에서 팝
            while (!tops.isEmpty()) {
                // 현재 탑보다 높은 탑을 찾으면 그 탑의 인덱스를 결과에 추가
                if (tops.peek()[0] >= height) {
                    // 높은 탑의 인덱스 추가
                    sb.append(tops.peek()[1]).append(" ");
                    break;
                }
                // 현재 탑보다 낮은 탑은 팝
                tops.pop();
            }
            // 스택이 비어있다면 0 추가
            if (tops.isEmpty()) {
                sb.append("0 ");
            }
            // 현재 탑을 스택에 추가
            tops.push(new int[]{height, i});
        }
        System.out.println(sb);
    }
}