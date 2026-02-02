/*
 * Domain: Baekjoon Online Judge
 * Problem Number: 16953
 * Problem Name: A -> B
 *
 * Date: 2026-02-02
 *
 */

import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int result = -1; // 결과값을 -1로 초기화

    static void bfs(int A, int B) {
        Queue<long[]> queue = new LinkedList<>(); // 큐에 long 배열을 저장 (값과 연산 횟수)
        queue.add(new long[]{A, 1}); // 시작 값과 연산 횟수 1로 초기화

        while (!queue.isEmpty()) {
            long[] current = queue.poll(); // 현재 값과 연산 횟수
            long value = current[0]; // 현재 값
            int count = (int) current[1]; // 현재 연산 횟수

            if (value == B) { // 목표 값에 도달했을 때
                if (result == -1 || count < result) { // 최소 연산 횟수 갱신
                    result = count; // 결과값 업데이트
                }
                return; // 탐색 종료
            }

            if (value * 2 <= B) { // 값이 B를 넘지 않는 경우에만 연산 수행
                queue.add(new long[]{value * 2, count + 1}); // 2를 곱하는 연산
            }
            if (value * 10 + 1 <= B) { // 값이 B를 넘지 않는 경우에만 연산 수행
                queue.add(new long[]{value * 10 + 1, count + 1}); // 1을 추가하는 연산
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        bfs(A, B);
        System.out.println(result);
    }
}