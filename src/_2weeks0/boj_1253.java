package _2weeks0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class boj_1253 {
    static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        recursive(n, arr, set, map, 0, 0, 0, 0);

        System.out.println(answer);
        br.close();
    }

    static void recursive(int n, int[] arr, Set<Integer> set, Map<Integer, Integer> indexMap, int idx, int cnt, int sum, int cnt0) {
        if (cnt == 2) {
            if (indexMap.containsKey(sum) && !set.contains(sum)) {
                if (cnt0 == 2 && indexMap.get(0) == 2) {
                    return;
                } else if (cnt0 == 1 && indexMap.get(sum) == 1) {
                    return;
                }
                set.add(sum);
                answer += indexMap.get(sum);
            }
            return;
        }

        for (int i = idx; i < n; i++) {
            recursive(n, arr, set, indexMap, i + 1, cnt + 1, sum + arr[i], cnt0 + (arr[i] == 0 ? 1 : 0));
        }
    }
}
