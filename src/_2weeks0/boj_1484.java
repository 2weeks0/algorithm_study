package _2weeks0;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class boj_1484 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int g = Integer.parseInt(br.readLine());

        int[] diff = new int[(g - 1) / 2 + 1];
        for (int i = 1; i < diff.length; i++) {
            diff[i] = 2 * i + 1;
        }
        long[] sum = new long[diff.length];
        for (int i = 1; i < sum.length; i++) {
            sum[i] = diff[i] + sum[i - 1];
        }

        int left = 0;
        int right = 0;
        boolean findAnswer= false;
        while (left < sum.length && right < sum.length) {
            if (sum[right] - sum[left] < g) {
                right++;
            } else if (sum[right] - sum[left] == g) {
                left++;
                bw.append(String.valueOf(right + 1)).append('\n');
                findAnswer = true;
            } else {
                left++;
            }
        }

        if (!findAnswer) {
            bw.append("-1");
        }

        bw.close();
        br.close();
    }
}
