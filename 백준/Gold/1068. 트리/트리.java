/*
    * Domain: Baekjoon Online Judge
    * Problem Number: 1068
    * Problem Name: 트리
    *
    * Date: 2026-01-27
    *
*/

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 트리에 대한 인접 리스트 표현
        List<List<Integer>> tree = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            tree.add(new ArrayList<>());
        }
        int root = -1;

        // 트리 구성
        for (int i = 0; i < N; i++) {
            // 부모 노드 정보 읽기
            int parent = Integer.parseInt(st.nextToken());
            // 루트 노드 찾기
            if (parent == -1) {
                root = i;
            } else {
                // 자식 노드 추가
                tree.get(parent).add(i);
            }
        }

        // 삭제할 노드 번호 읽기
        int deleteNode = Integer.parseInt(br.readLine());

        // 삭제 후 남은 리프 노드 개수 계산
        if (deleteNode == root) {
            // 루트 노드가 삭제되는 경우 리프 노드가 없음
            sb.append(0);
        } else {
            // 리프 노드 개수 세기
            int leafCount = countLeaves(tree, root, deleteNode);
            sb.append(leafCount);
        }

        // 결과 출력
        System.out.println(sb);
    }

    // 리프 노드 개수 세기 위한 재귀 함수
    private static int countLeaves(List<List<Integer>> tree, int root, int deleteNode) {
        // 현재 노드가 리프 노드인 경우
        if (tree.get(root).isEmpty()) {
            return 1;
        }

        // 자식 노드들에 대해 재귀적으로 리프 노드 개수 세기
        int leafCount = 0;
        // 자식 노드 순회
        for (int child : tree.get(root)) {
            // 삭제할 노드가 아닌 경우에만 재귀 호출
            if (child != deleteNode) {
                // 자식 노드의 리프 노드 개수 더하기
                leafCount += countLeaves(tree, child, deleteNode);
            }
        }

        // 모든 자식 노드가 삭제된 경우 현재 노드가 리프 노드가 됨
        if (leafCount == 0) {
            return 1;
        }

        // 리프 노드 개수 반환
        return leafCount;
    }
}