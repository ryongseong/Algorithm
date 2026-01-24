/*
    * Domain: Baekjoon Online Judge
    * Problem Number: 1874
    * Problem Name: 스택 수열
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

        // 숫자 수인 N 입력
        int n = Integer.parseInt(br.readLine());

        // 스택과 현재 숫자 초기화
        Stack<Integer> stack = new Stack<>();
        int currentNumber = 1;

        for (int i = 0; i < n; i++) {
            // 목표 숫자 입력
            int targetNumber = Integer.parseInt(br.readLine());

            // 현재 숫자가 목표 숫자보다 작거나 같을 때까지 스택에 푸시
            while (currentNumber <= targetNumber) {
                // 스택에 현재 숫자 푸시
                stack.push(currentNumber++);
                // 스택에 푸시한 연산 기록
                sb.append("+\n");
            }

            // 스택의 최상단 숫자가 목표 숫자와 같으면 팝
            if (stack.peek() == targetNumber) {
                stack.pop();
                // 스택에서 팝한 연산 기록
                sb.append("-\n");
            } else {
                // 목표 숫자를 만들 수 없는 경우
                System.out.println("NO");
                return;
            }
        }
        System.out.print(sb.toString());
    }
}