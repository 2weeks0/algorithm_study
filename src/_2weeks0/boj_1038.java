package _2weeks0;

import java.util.*;

public class boj_1038 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        if (Math.pow(2, 10) - 1 <= n) {
            System.out.println(-1);
            return;
        }

        List<Long> list = new ArrayList<>((int) Math.pow(2, 10));
        recursive(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0}, list, 0, 0);

        Collections.sort(list);
        System.out.println(list.get(n + 1));
    }

    static void recursive(int[] nums, List<Long> list, int idx, long value) {
        if (idx == nums.length) {
            list.add(value);
            return;
        }

        recursive(nums, list, idx + 1, value * 10 + nums[idx]);
        recursive(nums, list, idx + 1, value);
    }
}
