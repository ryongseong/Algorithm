import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T --> 0) {
            String input = br.readLine();
            Deque<Character> dq = new ArrayDeque<>();
            boolean isValid = true;

            for (char ch : input.toCharArray()) {
                if (ch == '(') {
                    dq.addLast(ch);
                } else {
                    if (dq.isEmpty()) {
                        isValid = false;
                        break;
                    } else {
                        dq.removeLast();
                    }
                }
            }

            if (isValid && dq.isEmpty()) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
        }
        System.out.print(sb);
    }
}