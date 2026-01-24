/*
    * Domain: Baekjoon Online Judge
    * Problem Number: 2504
    * Problem Name: 괄호의 값
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

        String input = br.readLine();
        Stack<Character> stack = new Stack<>();
        int result = 0;

        int temp = 1;
        boolean isValid = true;

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if (ch == '(') {
                stack.push(ch);
                temp *= 2;
            } else if (ch == '[') {
                stack.push(ch);
                temp *= 3;
            } else if (ch == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    isValid = false;
                    break;
                }
                if (input.charAt(i - 1) == '(') {
                    result += temp;
                }
                stack.pop();
                temp /= 2;
            } else if (ch == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    isValid = false;
                    break;
                }
                if (input.charAt(i - 1) == '[') {
                    result += temp;
                }
                stack.pop();
                temp /= 3;
            }
        }

        if (!isValid || !stack.isEmpty()) {
            sb.append(0);
        } else {
            sb.append(result);
        }
        System.out.println(sb);
    }
}