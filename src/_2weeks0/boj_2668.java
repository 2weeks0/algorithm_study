package _2weeks0;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj_2668 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine()) - 1;
        }

        int[] visited = new int[n];
        for (int i = 0; i < n; i++) {
            if (visited[i] != 0) {
                continue;
            }
            recursive(arr, visited, i);
        }

        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (visited[i] == 2) {
                cnt++;
                sb.append(i + 1).append('\n');
            }
        }

        System.out.println(cnt);
        System.out.println(sb);
        br.close();
    }

    static void recursive(int[] arr, int[] visited, int current) {
        if (visited[current] == 2 || visited[current] == -1) {
            return;
        }
        visited[current]++;

        recursive(arr, visited, arr[current]);
        if (visited[current] == 1) {
            visited[current] = -1;
        }
    }
}
