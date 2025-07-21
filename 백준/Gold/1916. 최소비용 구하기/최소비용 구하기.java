import java.io.*;
import java.util.*;

public class Main {
    static long INF = Long.MAX_VALUE;
    static int N, M;
    static long[] dist;
    static List<Node>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());

        dist = new long[N+1];
        Arrays.fill(dist, INF);

        graph = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            long cost = Long.parseLong(st.nextToken());

            graph[start].add(new Node(end, cost));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dijkstra(start);

        System.out.println(dist[end]);

        br.close();
    }

    static void dijkstra(int st) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[st] = 0;
        pq.offer(new Node(st, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (cur.cost > dist[cur.num]) continue;

            for (Node next : graph[cur.num]) {
                long newCost = dist[cur.num] + next.cost;
                if (newCost < dist[next.num]) {
                    dist[next.num] = newCost;
                    pq.offer(new Node(next.num, newCost));
                }
            }
        }
    }


    static class Node implements Comparable<Node> {
        int num;
        long cost;

        Node (int num, long cost) {
            this.num = num;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node other) {
            return Long.compare(cost, other.cost);
        }
    }
}