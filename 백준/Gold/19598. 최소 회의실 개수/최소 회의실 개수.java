/*
    * Domain: Baekjoon Online Judge
    * Problem Number: 19598
    * Problem Name: 최소 회의실 개수
    *
    * Date: 2026-02-01
    *
*/

import java.io.*;
import java.math.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[][] meetings = new int[N][2]; // 회의에 대한 배열 [시작시간, 종료시간]

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            meetings[i][0] = Integer.parseInt(st.nextToken());
            meetings[i][1] = Integer.parseInt(st.nextToken());
        }

        // 회의 시작 시간을 기준으로 오름차순 정렬
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        // 최소 힙을 사용하여 회의실 종료 시간을 관리
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            int start = meetings[i][0];
            int end = meetings[i][1];

            // 현재 회의의 시작 시간이 가장 빨리 끝나는 회의실의 종료 시간보다 크거나 같으면
            // 해당 회의실을 재사용할 수 있으므로 힙에서 제거
            if (!minHeap.isEmpty() && minHeap.peek() <= start) {
                minHeap.poll();
            }

            // 현재 회의의 종료 시간을 힙에 추가
            minHeap.offer(end);
        }

        // 힙에 남아있는 원소의 개수가 필요한 최소 회의실 개수
        sb.append(minHeap.size()).append('\n');
        System.out.print(sb);
    }
}