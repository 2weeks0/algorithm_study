package _2weeks0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class boj_17471 {
    static int answer = Integer.MAX_VALUE;
    static List<Integer>[] graph;
    static int[] nums;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        nums = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }


        graph = new LinkedList[n + 1];
        for (int from = 1; from <= n; from++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            graph[from] = new LinkedList<>();
            for (int i = 0; i < k; i++) {
                graph[from].add(Integer.parseInt(st.nextToken()));
            }
        }

        int[] arr= new int[n];
        for (int i = 1; i < n; i++) {
            combination(n, i, arr, 0, 0);
        }

        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
        br.close();
    }

    static void combination(int n, int r, int[] arr, int cnt, int idx) {
        if (cnt != 0 && arr[0] != 1) {
            return;
        }
        if (cnt == r) {
            boolean[] visited = new boolean[n + 1];
            boolean[] side = new boolean[n + 1];
            for (int i = 0; i < r; i++) {
                side[arr[i]] = true;
            }

            List<Integer> list = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                if (!visited[i]) {
                    list.add(dfs(n, i, visited, side));
                }
            }

            if (list.size() == 2) {
                answer = Math.min(answer, Math.abs(list.get(1) - list.get(0)));
            }
            return;
        }

        for (int i = idx; i <= n; i++) {
            arr[cnt] = i;
            combination(n, r, arr, cnt + 1, i+ 1);
        }
    }


    static int dfs(int n, int current, boolean[] visited, boolean[] side) {
        visited[current] = true;

        int cnt = nums[current];
        for (int next : graph[current]) {
            if (!visited[next] && side[current] == side[next]) {
                cnt += dfs(n, next, visited, side);
            }
        }
        return cnt;
    }
}
