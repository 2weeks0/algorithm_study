package _2weeks0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class boj_19542 {
    static int cnt = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken()) - 1;
        int d = Integer.parseInt(st.nextToken());

        List<Integer>[] lists = new List[n];
        for (int i = 0; i < n; i++) {
            lists[i] = new LinkedList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1;
            lists[u].add(v);
            lists[v].add(u);
        }

        recursive(lists, d, new int[n], new boolean[n], s, -1);

        System.out.println(2 * (n - 1 - cnt));
        br.close();
    }

    static void recursive(List<Integer>[] lists, int d, int[] height, boolean[] visited, int current, int previous) {
        visited[current] = true;
        for (int next : lists[current]) {
            if (visited[next]) {
                continue;
            }
            recursive(lists, d, height, visited, next, current);
        }

        if (previous != -1) {
            height[previous] = Math.max(height[previous], height[current] + 1);
            if (height[current] < d) {
                cnt++;
            }
        }
    }
}
