import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr;
    static boolean[] visited;
    static List<Integer> ans = new ArrayList<>();

    static void sol() {
        if (ans.size() == M) {
            for (Integer an : ans) {
                System.out.print(an + " ");
            }
            System.out.println();
            return;
        }

        int check = 0;
        for (int i = 0; i< N; i++) {
            if (check != arr[i] && !visited[i]) {
                ans.add(arr[i]);
                visited[i] = true;
                check = arr[i];
                sol();
                visited[i] = false;
                ans.remove(ans.size() - 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        visited = new boolean[N];

        st  = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        sol();
    }
}


