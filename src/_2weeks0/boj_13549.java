package _2weeks0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj_13549 {
    static final int MAX_SIZE = 100_000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        System.out.println(dijkstra(n, k));
        br.close();
    }

    static int dijkstra(int n, int k) {
        int[] dist = new int[MAX_SIZE + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[n] = 0;

        boolean[] visited = new boolean[MAX_SIZE + 1];

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparing(i -> dist[i]));
        pq.add(n);

        while (!pq.isEmpty()) {
            int current = pq.poll();
            if (current == k) {
                break;
            }

            if (visited[current]) {
                continue;
            }
            visited[current] = true;
            for (int i = 0; i < 3; i++) {
                int next;
                int weight;
                if (i == 0) {
                    next = current - 1;
                    weight = 1;
                } else if (i == 1) {
                    next = current + 1;
                    weight = 1;
                } else {
                    next = 2 * current;
                    weight = 0;
                }
                if (0 <= next && next <= MAX_SIZE && !visited[next] && dist[current] + weight < dist[next]) {
                    dist[next] = dist[current] + weight;
                    pq.add(next);
                }
            }
        }
        return dist[k];
    }
}
