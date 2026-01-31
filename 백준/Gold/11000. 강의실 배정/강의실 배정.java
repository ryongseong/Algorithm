/*
    * Domain: Baekjoon Online Judge
    * Problem Number: 11000
    * Problem Name: 강의실 배정
    *
    * Date: 2026-01-31
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

        int[][] lectures = new int[N][2]; // 강의 시간에 대해 저장할 배열 [시작 시간, 종료 시간]

        while (N --> 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            lectures[N] = new int[]{start, end};
        }

        // 강의 시작 시간을 기준으로 오름차순 정렬, 시작 시간이 같다면 종료 시간을 기준으로 오름차순 정렬
        Arrays.sort(lectures, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 종료 시간을 저장할 우선순위 큐
        pq.offer(lectures[0][1]); // 첫 번째 강의의 종료 시간을 큐에 추가
        for (int i = 1; i < lectures.length; i++) {
            // 현재 강의의 시작 시간이 가장 빨리 끝나는 강의의 종료 시간보다 크거나 같다면
            if (lectures[i][0] >= pq.peek()) {
                pq.poll(); // 가장 빨리 끝나는 강의 제거
            }
            pq.offer(lectures[i][1]); // 현재 강의의 종료 시간을 큐에 추가
        }

        sb.append(pq.size()); // 최소 강의실 개수는 우선순위 큐의 크기
        System.out.println(sb);
    }
}