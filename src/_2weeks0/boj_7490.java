package _2weeks0;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class boj_7490 {
    static final char[] op = {' ', '+', '-'};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(br.readLine());
            int[] nums = new int[value];
            for (int j = 0; j < value; j++) {
                nums[j] = j + 1;
            }

            recursive(nums, new char[value - 1], 0, bw);
            bw.newLine();
        }
        bw.close();
        br.close();
    }

    static void recursive(int[] nums, char[] ops, int depth, BufferedWriter bw) throws Exception {
        if (depth == ops.length) {
            if (calculate(nums, ops) == 0) {
                for (int i = 0; i < depth; i++) {
                    bw.append(String.valueOf(nums[i])).append(ops[i]);
                }
                bw.append(String.valueOf(nums[nums.length - 1]));
                bw.newLine();
            }
            return;
        }

        for (int i = 0; i < op.length; i++) {
            ops[depth] = op[i];
            recursive(nums, ops, depth + 1, bw);
        }
    }

    static int calculate(int[] nums, char[] ops) {
        int left = 0;
        int right = nums[0];
        for (int i = 0; i < ops.length; i++) {
            char op = ops[i];
            if (op == ' ') {
                right *= 10;
                if (right < 0) {
                    right -= nums[i + 1];
                } else {
                    right += nums[i + 1];
                }
            } else {
                left += right;
                if (op == '+') {
                    right = nums[i + 1];
                } else {
                    right = -nums[i + 1];
                }
            }
        }
        return left + right;
    }
}
