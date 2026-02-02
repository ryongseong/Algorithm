/*
 * Domain: Baekjoon Online Judge
 * Problem Number: 2096
 * Problem Name: 내려가기
 *
 * Date: 2026-02-02
 *
 */

import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int n; // 행의 수
    static int maxValue = Integer.MIN_VALUE; // 최대값 (초기값은 최소값으로 설정)
    static int minvalue = Integer.MAX_VALUE; // 최소값 (초기값은 최대값으로 설정)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][3]; // 입력 배열, 3열 고정

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] maxDp = new int[n][3];
        int[][] minDp = new int[n][3];

        for (int j = 0; j < 3; j++) {
            maxDp[0][j] = arr[0][j];
            minDp[0][j] = arr[0][j];
        }

        for (int i = 1; i < n; i++) {
            maxDp[i][0] = Math.max(maxDp[i - 1][0], maxDp[i - 1][1]) + arr[i][0]; // 0열은 0,1열에서만 올 수 있음
            maxDp[i][1] = Math.max(Math.max(maxDp[i - 1][0], maxDp[i - 1][1]), maxDp[i - 1][2]) + arr[i][1]; // 1열은 0,1,2열에서 올 수 있음
            maxDp[i][2] = Math.max(maxDp[i - 1][1], maxDp[i - 1][2]) + arr[i][2]; // 2열은 1,2열에서만 올 수 있음

            minDp[i][0] = Math.min(minDp[i - 1][0], minDp[i - 1][1]) + arr[i][0]; // 0열은 0,1열에서만 올 수 있음
            minDp[i][1] = Math.min(Math.min(minDp[i - 1][0], minDp[i - 1][1]), minDp[i - 1][2]) + arr[i][1]; // 1열은 0,1,2열에서 올 수 있음
            minDp[i][2] = Math.min(minDp[i - 1][1], minDp[i - 1][2]) + arr[i][2]; // 2열은 1,2열에서만 올 수 있음
        }

        for (int j = 0; j < 3; j++) {
            maxValue = Math.max(maxValue, maxDp[n - 1][j]); // 마지막 행에서 최대값 찾기
            minvalue = Math.min(minvalue, minDp[n - 1][j]); // 마지막 행에서 최소값 찾기
        }

        sb.append(maxValue).append(" ").append(minvalue); // 결과 문자열에 최대값과 최소값 추가
        System.out.println(sb);
    }
}