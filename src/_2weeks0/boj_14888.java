package _2weeks0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_14888 {
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int[] ops = new int[4];
        for (int i = 0; i < 4; i++) {
            ops[i] = Integer.parseInt(st.nextToken());
        }

        recursive(n, nums, ops, 0, nums[0]);

        System.out.println(max);
        System.out.println(min);
        br.close();
    }

    static void recursive(int n, int[] nums, int[] ops, int depth, int sum) {
        if (depth == n - 1) {
            max = Math.max(max, sum);
            min = Math.min(min, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (ops[i] == 0) {
                continue;
            }
            ops[i]--;
            recursive(n, nums, ops, depth + 1, operate(i, sum, nums[depth + 1]));
            ops[i]++;
        }
    }

    static int operate(int opIdx, int a, int b) {
        switch (opIdx) {
            case 0:
                return a + b;
            case 1:
                return a - b;
            case 2:
                return a * b;
            default:
            case 3:
                return a / b;
        }
    }
}
