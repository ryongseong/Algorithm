import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Deque<Integer> dq = new ArrayDeque<>();

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;

        while (N --> 0) {
            st = new StringTokenizer(br.readLine(), " ");

            switch (st.nextToken()) {
                case "push":
                    dq.offer(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    Integer popValue = dq.poll();
                    if (popValue == null) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(popValue).append("\n");
                    }
                    break;
                case "size":
                    sb.append(dq.size()).append("\n");
                    break;
                case "empty":
                    if (dq.isEmpty()) {
                        sb.append(1).append("\n");
                    } else {
                        sb.append(0).append("\n");
                    }
                    break;
                case "front":
                    Integer frontValue = dq.peek();
                    if (frontValue == null) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(frontValue).append("\n");
                    }
                    break;
                case "back":
                    Integer backValue = dq.peekLast();
                    if (backValue == null) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(backValue).append("\n");
                    }
                    break;
            }
        }
        System.out.print(sb);
    }
}