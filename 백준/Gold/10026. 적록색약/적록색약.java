import java.io.*;
import java.util.*;


public class Main {

    static int[][] directions = {{0, 1}, {1,  0}, {0, -1}, {-1, 0}};
    static char[][] matrix;
    static boolean[][] visited;
    static int N;
    static String line;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        matrix = new char[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            line = br.readLine();
            for (int j = 0; j < N; j++) {
                matrix[i][j] = line.charAt(j);
            }
        }

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    dfs(i, j);
                    cnt++;
                }
            }
        }
        int normalCount = cnt;
        cnt = 0;
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (matrix[i][j] == 'G') {
                    matrix[i][j] = 'R';
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    dfs(i, j);
                    cnt++;
                }
            }
        }
        
        System.out.println(normalCount + " " + cnt);
    }

    public static void dfs(int r, int c) {
        visited[r][c] = true;
        char currentColor = matrix[r][c];

        for (int i = 0; i < 4; i++) {
            int newR = r + directions[i][0];
            int newC = c + directions[i][1];

            if (newR < 0 || newC < 0 || newR >= N || newC >= N) continue;
            if (!visited[newR][newC] && matrix[newR][newC] == currentColor) {
                dfs(newR, newC);
            }
        }

    }
}