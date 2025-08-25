import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int x, y, cnt;

        public Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    static int[][] matrix;
    static boolean[][] visited;
    static int r, m;
    static int minCnt = Integer.MAX_VALUE;

    static int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        matrix = new int[r][m];
        visited = new boolean[r][m];

        for (int i = 0; i < r; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                matrix[i][j] = line.charAt(j) - '0';
            }
        }

        System.out.println(bfs());
    }

    public static int bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0, 1));
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current.x == r - 1 && current.y == m - 1) {
                return current.cnt;
            }

            for (int[] dir: directions) {
                int nx = current.x + dir[0];
                int ny = current.y + dir[1];

                if (nx >= 0 && ny >= 0 && nx < r && ny < m) {
                    if (!visited[nx][ny] && matrix[nx][ny] == 1) {
                        visited[nx][ny] = true;
                        queue.add(new Node(nx, ny, current.cnt + 1));
                    }
                }
            }
        }

        return -1;
    }
}