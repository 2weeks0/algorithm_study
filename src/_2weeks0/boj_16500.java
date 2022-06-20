package _2weeks0;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj_16500 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n = Integer.parseInt(br.readLine());
        String[] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = br.readLine();
        }

        System.out.println(recursive(s, n, a, new boolean[s.length()][n], 0) ? 1 : 0);
        br.close();
    }

    static boolean recursive(String s, int n, String[] a, boolean[][] visited, int idx) {
        if (idx == s.length()) {
            return true;
        }

        outer: for (int i = 0; i < n; i++) {
            if (visited[idx][i]) {
                continue;
            }
            visited[idx][i] = true;

            String temp = a[i];
            if (s.length() < temp.length() + idx) {
                continue;
            }

            for (int j = 0; j < temp.length(); j++) {
                if (s.charAt(j + idx) != temp.charAt(j)) {
                    continue outer;
                }
            }

            if (recursive(s, n, a, visited, idx + temp.length())) {
                return true;
            }
        }
        return false;
    }
}
