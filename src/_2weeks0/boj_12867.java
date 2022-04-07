package _2weeks0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class boj_12867 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        long[] arr = new long[m];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        String line = br.readLine();
        for (int i = 0; i < m; i++) {
            if (line.charAt(i) == '-') {
                arr[i] *= -1;
            }
        }

        System.out.println(traverse(arr));
        br.close();
    }

    static int traverse(long[] arr) {
        Set<Map<Long, Long>> visited = new HashSet<>();
        Map<Long, Long> pos = new HashMap<>();
        visited.add(new HashMap<>(pos));

        for (long l : arr) {
            long idx = Math.abs(l);
            long current = pos.getOrDefault(idx, 0L) + (0 < l ? 1 : -1);
            if (current == 0) {
                pos.remove(idx);
            } else {
                pos.put(idx, current);
            }

            if (visited.contains(pos)) {
                return 0;
            }
            visited.add(new HashMap<>(pos));
        }
        return 1;
    }
}
