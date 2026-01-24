/*
    * Domain: Baekjoon Online Judge
    * Problem Number: 30676
    * Problem Name: 이 별은 무슨 색일까
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

        int T = Integer.parseInt(br.readLine());

        if (380 <= T && T < 425) {
            sb.append("Violet");
        } else if (425 <= T && T < 450) {
            sb.append("Indigo");
        } else if (450 <= T && T < 495) {
            sb.append("Blue");
        } else if (495 <= T && T < 570) {
            sb.append("Green");
        } else if (570 <= T && T < 590) {
            sb.append("Yellow");
        } else if (590 <= T && T < 620) {
            sb.append("Orange");
        } else {
            sb.append("Red");
        }
        System.out.println(sb);
    }
}