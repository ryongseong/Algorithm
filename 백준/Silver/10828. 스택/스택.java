import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Integer> stack;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        stack = new ArrayList<>();

        while (N --> 0) {
            String[] cmd = br.readLine().split(" ");
            command(cmd);
        }
    }

    static void command(String[] cmd) {
        switch (cmd[0]) {
            case "push":
                int value = Integer.parseInt(cmd[1]);
                stack.add(value);
                break;
            case "pop":
                if (stack.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(stack.remove(stack.size() - 1));
                }
                break;
            case "size":
                System.out.println(stack.size());
                break;
            case "empty":
                System.out.println(stack.isEmpty() ? 1 : 0);
                break;
            case "top":
                if (stack.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(stack.get(stack.size() - 1));
                }
                break;
            default:
                System.out.println("Invalid command");
                break;
        }
    }
}