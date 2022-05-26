package _2weeks0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_16432 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            arr[i] = new int[m];
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();

        int[] order = new int[n];
        boolean[][] visited = new boolean[n][10];
        if (recursive(n, arr, visited, order, 0)) {
            StringBuilder sb = new StringBuilder();
            for (int j : order) {
                sb.append(j).append('\n');
            }
            System.out.println(sb);
        } else {
            System.out.println(-1);
        }
    }

    static boolean recursive(int n, int[][] arr, boolean[][] visited, int[] order, int depth) {
        if (depth == n) {
            return true;
        }
        for (int i = 0; i < arr[depth].length; i++) {
            if ((depth != 0 && arr[depth][i] == order[depth - 1]) || visited[depth][arr[depth][i]]) {
                continue;
            }
            order[depth] = arr[depth][i];
            visited[depth][arr[depth][i]] = true;
            if (recursive(n, arr, visited, order, depth + 1)) {
                return true;
            }
        }
        return false;
    }
}
