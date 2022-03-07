package _2weeks0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_1446 {
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        Edge[] edges = new Edge[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(from, to, distance);
        }

        Arrays.sort(edges);
        recursive(n, d, edges, 0, 0, 0);

        System.out.println(answer);
        br.close();
    }

    static void recursive(int n, int d, Edge[] edges, int idx, int pos, int distance) {
        if (idx == n) {
            answer = Math.min(answer, distance + d - pos);
            return;
        }

        Edge edge = edges[idx];
        if (edge.to <= d && pos <= edge.from) {
            recursive(n, d, edges, idx + 1, edge.to, distance + edge.distance + edge.from - pos);
        }
        recursive(n, d, edges, idx + 1, pos, distance);
    }

    static class Edge implements Comparable<Edge> {
        int from;
        int to;
        int distance;

        public Edge(int from, int to, int distance) {
            this.from = from;
            this.to = to;
            this.distance = distance;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(from, o.from);
        }
    }
}
