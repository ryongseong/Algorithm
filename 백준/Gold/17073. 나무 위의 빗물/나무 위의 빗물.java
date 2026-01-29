/*
 * Domain: Baekjoon Online Judge
 * Problem Number: 17073
 * Problem Name: 나무 위의 빗물
 *
 * Date: 2026-01-29
 *
 */

import java.io.*;
import java.util.*;

public class Main {

    static int leafCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        // 트리의 노드의 수 N과 빗물의 양 W 입력
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        // 트리의 인접 리스트 표현
        List<Integer>[] tree = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        // 트리의 간선 정보 입력
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            tree[u].add(v);
            tree[v].add(u);
        }
        for (int i = 2; i <= n; i++) {
            if (tree[i].size() == 1) {
                leafCount++;
            }
        }

        System.out.printf("%.10f", (double) w / leafCount);
    }
}