/*
    * Domain: Baekjoon Online Judge
    * Problem Number: 10799
    * Problem Name: 쇠막대기
    *
    * Date: 2026-01-24
    *
*/

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 쇠막대기와 레이저의 배치를 나타내는 문자열 입력
        String input = br.readLine();

        // 스택을 사용하여 쇠막대기의 상태를 추적
        Stack<Character> stack = new Stack<>();
        // 쇠막대기의 총 조각 수를 저장할 변수
        int totalPieces = 0;

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);

            // 여는 괄호 '('인 경우 스택에 추가
            if (currentChar == '(') {
                stack.push(currentChar);
            }
            // 닫는 괄호 ')'인 경우
            else {
                // 바로 이전 문자가 '('인 경우 레이저
                if (input.charAt(i - 1) == '(') {
                    stack.pop(); // 레이저는 막대기를 자르므로 스택에서 제거
                    totalPieces += stack.size(); // 현재 스택 크기만큼 조각 추가
                }
                // 바로 이전 문자가 ')'인 경우 막대기의 끝
                else {
                    stack.pop(); // 막대기의 끝이므로 스택에서 제거
                    totalPieces += 1; // 막대기의 끝 조각 추가
                }
            }
        }
        // 최종 조각 수 출력
        System.out.println(totalPieces);
    }
}