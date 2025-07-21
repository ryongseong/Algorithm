import java.io.*;
import java.util.*;

public class Main {
    static final long INF = Long.MAX_VALUE;
    static int V, E, K;
    static long[] dist;
    static List<Node>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());

        dist = new long[V + 1];
        Arrays.fill(dist, INF);

        graph = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            long cost = Long.parseLong(st.nextToken());

            graph[from].add(new Node(to, cost));
        }

        dijkstra(K);

        for (int i = 1; i <= V; i++) {
            if (dist[i] == INF) {
                bw.write("INF\n");
            } else {
                bw.write(dist[i]+"\n");
            }
        }
        bw.flush();
        bw.close();
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
            return Long.compare(this.cost, other.cost);
        }
    }
}