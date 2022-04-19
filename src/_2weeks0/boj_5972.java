package _2weeks0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class boj_5972 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Edge>[] edgeList = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            edgeList[i] = new LinkedList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken());
            edgeList[a].add(new Edge(b, c));
            edgeList[b].add(new Edge(a, c));
        }
        System.out.println(dijkstra(n, edgeList));
        br.close();
    }

    static int dijkstra(int n, List<Edge>[] edgeList) {
        int[] visited = new int[n];
        Arrays.fill(visited, Integer.MAX_VALUE);
        visited[0] = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(it -> visited[it]));
        pq.add(0);

        while (!pq.isEmpty()) {
            int node = pq.poll();
            if (node == n - 1) {
                return visited[n - 1];
            }
            for (Edge edge : edgeList[node]) {
                if (visited[node] + edge.weight < visited[edge.to]) {
                    visited[edge.to] = visited[node] + edge.weight;
                    pq.add(edge.to);
                }
            }
        }
        return -1;
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
