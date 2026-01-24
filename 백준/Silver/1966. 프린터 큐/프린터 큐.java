/*
    * Domain: Baekjoon Online Judge
    * Problem Number: 1966
    * Problem Name: 프린터 큐 (Printer Queue)
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

        int N = Integer.parseInt(br.readLine());

        // 테스트 케이스마다 반복
        while (N --> 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            // 문서의 인덱스와 우선순위를 함께 저장
            Queue<int[]> queue = new LinkedList<>();
            // 우선순위 큐를 사용하여 현재 가장 높은 우선순위를 추적 (Collections.reverseOrder()로 내림차순)
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                int priority = Integer.parseInt(st.nextToken());
                // 인덱스와 우선순위를 함께 큐에 저장
                queue.offer(new int[]{i, priority});
                // 우선순위 큐에도 우선순위 저장
                pq.offer(priority);
            }

            int count = 0;
            while (!queue.isEmpty()) {
                // 현재 문서 확인
                int[] current = queue.poll();
                // 현재 문서의 우선순위가 가장 높다면 인쇄
                if (current[1] == pq.peek()) {
                    count++;
                    // 우선순위 큐에서 해당 우선순위 제거
                    pq.poll();
                    // 현재 문서가 우리가 찾는 문서라면 결과에 추가
                    if (current[0] == m) {
                        sb.append(count).append('\n');
                        break;
                    }
                } else {
                    // 우선순위가 낮다면 다시 큐의 뒤로 이동
                    queue.offer(current);
                }
            }
        }
        System.out.print(sb);
    }
}