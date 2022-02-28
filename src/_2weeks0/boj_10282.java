package _2weeks0;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class boj_10282 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tc = Integer.parseInt(br.readLine());
        for (int t = 1; t <= tc; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken()) - 1;

            List<Edge>[] graph = new List[n];
            for (int i = 0; i < n; i++) {
                graph[i] = new LinkedList<>();
            }
            for (int i = 0; i < d; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken()) - 1;
                int b = Integer.parseInt(st.nextToken()) - 1;
                int s = Integer.parseInt(st.nextToken());
                graph[b].add(new Edge(a, s));
            }

            int[] dist = dijkstra(n, graph, c);
            int cnt = 0;
            int maxDist = 0;
            for (int i : dist) {
                if (i != Integer.MAX_VALUE) {
                    cnt++;
                    maxDist = Math.max(maxDist, i);
                }
            }
            bw.append(String.valueOf(cnt)).append(' ').append(String.valueOf(maxDist)).append('\n');
        }
        bw.close();
        br.close();
    }

    static int[] dijkstra(int n, List<Edge>[] graph, int start) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparing(i -> dist[i]));
        pq.add(start);

        while (!pq.isEmpty()) {
            int current = pq.poll();
            for (Edge edge : graph[current]) {
                if (dist[current] + edge.weight < dist[edge.to]) {
                    dist[edge.to] = dist[current] + edge.weight;
                    pq.add(edge.to);
                }
            }
        }

        return dist;
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
