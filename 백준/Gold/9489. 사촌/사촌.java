/*
 * Domain: Baekjoon Online Judge
 * Problem Number: 9489
 * Problem Name: 사촌
 *
 * Date: 2026-02-02
 *
 */

import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int n, k, kIdx, groupNum;
    static int[] arr, parent;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken()); // 노드의 수
            k = Integer.parseInt(st.nextToken()); // 찾고자 하는 노드

            if (n == 0 && k == 0) break;

            kIdx = 0; // k의 인덱스
            arr = new int[n+1]; // 노드 배열
            parent = new int[n+1]; // 부모 그룹 배열
            groupNum = -1; // 그룹 번호
            arr[0] = -1; // 첫 번째 노드의 부모는 없음
            parent[0] = -1; // 첫 번째 노드의 부모 그룹은 없음

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                if (arr[i] == k) { // k 노드 찾기
                    kIdx = i; // k의 인덱스 저장
                }
                if (arr[i] != arr[i-1] + 1) { // 부모가 바뀌는 경우
                    groupNum++; // 새로운 그룹 시작
                }
                parent[i] = groupNum; // 부모 그룹 저장
            }
            result = 0;
            for(int i=1; i<=n; i++){ // 사촌 노드 찾기
                if(parent[i] != parent[kIdx] && parent[parent[i]] == parent[parent[kIdx]]) { // 부모가 다르고 조부모가 같은 경우
                    result++; // 사촌 노드 개수 증가
                }
            }
            sb.append(result).append('\n');
        }
        System.out.print(sb);
    }
}