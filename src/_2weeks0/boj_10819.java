package _2weeks0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj_10819 {
    static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        recursive(n, nums, 0, new ArrayList<>(n), new boolean[n]);

        System.out.println(answer);
    }

    static void recursive(int n, int[] nums, int idx, List<Integer> indexes, boolean[] selected) {
        if (idx == n) {
            int temp = 0;
            for (int i = 0; i < n - 1; i++) {
                temp += Math.abs(nums[indexes.get(i)] - nums[indexes.get(i + 1)]);
            }
            answer = Math.max(answer, temp);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (selected[i]) {
                continue;
            }
            selected[i] = true;
            indexes.add(i);
            recursive(n, nums, idx + 1, indexes, selected);
            indexes.remove(indexes.size() - 1);
            selected[i] = false;
        }
    }
}
