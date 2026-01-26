/*
    * Domain: Baekjoon Online Judge
    * Problem Number: 1918
    * Problem Name: 후위 표기식
    *
    * Date: 2026-01-26
    *
*/

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input = br.readLine();

        // 수식에 대한 후위 표기식 변환을 위한 스택 사용
        Stack<Character> stack = new Stack<>();
        for (char ch: input.toCharArray()) {
            // 피연산자(알파벳)는 바로 출력
            if (Character.isLetter(ch)) {
                sb.append(ch);
            } else {
                switch (ch) {
                    // 연산자 및 여는 괄호 처리
                    case '(':
                    case '+':
                    case '-':
                        if (ch == '(') {
                            // 여는 괄호는 무조건 스택에 push
                            stack.push(ch);
                        } else {
                            // +, - 연산자는 스택에 있는 모든 연산자를 pop 후 push
                            while (!stack.isEmpty() && (stack.peek() == '+' || stack.peek() == '-' || stack.peek() == '*' || stack.peek() == '/')) {
                                sb.append(stack.pop());
                            }
                            // 현재 연산자 push
                            stack.push(ch);
                        }
                        break;
                    // *, / 연산자는 같은 우선순위 연산자만 pop 후 push
                    case '*':
                    case '/' :
                        // 같은 우선순위 연산자 pop
                        while (!stack.isEmpty() && (stack.peek() == '*' || stack.peek() == '/')) {
                            sb.append(stack.pop());
                        }
                        // 현재 연산자 push
                        stack.push(ch);
                        break;
                    // 닫는 괄호는 여는 괄호 나올 때까지 pop
                    case ')':
                        while (!stack.isEmpty() && stack.peek() != '(') {
                            sb.append(stack.pop());
                        }
                        stack.pop();
                        break;
                }
            }
        }
        // 스택에 남아있는 모든 연산자 pop
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        System.out.println(sb);
    }
}