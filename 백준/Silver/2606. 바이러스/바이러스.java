import java.io.*;
import java.util.*;

public class Main {
    static boolean[] visited;
    static int[][] arr;
    static int count = 0;

    static int n, m;

    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        arr = new int[n + 1][n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = 1;
            arr[b][a] = 1;
        }

        dfs(1);
        System.out.println(count - 1);
    }

    public static void dfs(int start) {
        visited[start] = true;
        count++;

        for (int i = 0; i <= n; i++) {
            if (arr[start][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }

}