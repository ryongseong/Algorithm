import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        sb.append("<");

        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            dq.push(i);
        }

        while (true) {
            for (int i = 0; i < K - 1; i++) {
                dq.addFirst(dq.pollLast());
            }
            sb.append(dq.pollLast());
            if (dq.isEmpty()) {
                sb.append(">");
                break;
            } else {
                sb.append(", ");
            }
        }
        System.out.println(sb);
    }
}