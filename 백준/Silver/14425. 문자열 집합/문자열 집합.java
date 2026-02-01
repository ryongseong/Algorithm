/*
 * Domain: Baekjoon Online Judge
 * Problem Number: 14425
 * Problem Name: 문자열 집합
 *
 * Date: 2026-02-02
 *
 */

import java.io.*;
import java.util.*;

public class Main {
    static int count = 0; // 일치하는 문자열 개수 (문제에서 요구하는 출력값)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 문자열 개수
        int M = Integer.parseInt(st.nextToken()); // 검사할 문자열 개수

        Set<String> stringSet = new HashSet<>(); // 문자열 집합

        while (N --> 0) { stringSet.add(br.readLine()); } // N개의 문자열을 집합에 추가

        while (M --> 0) {
            String query = br.readLine(); // 검사할 문자열
            if (stringSet.contains(query)) { // 집합에 존재하는지 확인
                count++; // 존재하면 개수 증가
            }
        }

        System.out.println(count); // 결과 출력
    }
}