package _2weeks0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class boj_1916 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        List<Edge>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new LinkedList<>();
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;
            int weight = Integer.parseInt(st.nextToken());
            graph[from].add(new Edge(to, weight));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken()) - 1;
        int end = Integer.parseInt(st.nextToken()) - 1;

        System.out.println(dijkstra(n, graph, start, end));
        br.close();
    }

    static int dijkstra(int n, List<Edge>[] graph, int start, int end) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        boolean[] visited = new boolean[n];

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparing(i -> dist[i]));
        pq.add(start);

        while (!pq.isEmpty()) {
            int current = pq.poll();
            if (visited[current]) {
                continue;
            }
            visited[current] = true;
            // 1 2 5
            // 1 2 10
            for (Edge edge : graph[current]) {
                if (!visited[edge.to] && dist[current] + edge.weight < dist[edge.to]) {
                    dist[edge.to] = dist[current] + edge.weight;
                    pq.add(edge.to);
                }
            }
        }

        return dist[end];
    }

    static class Edge {
        int to;
        int weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
}
