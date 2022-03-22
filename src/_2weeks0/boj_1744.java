package _2weeks0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class boj_1744 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr, (i1, i2) -> {
            if (0 <= i1 * i2) {
                return Integer.compare(Math.abs(i2), Math.abs(i1));
            } else if (0 < i1) {
                return -1;
            } else {
                return 1;
            }
        });

        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (i == n - 1) {
                answer += arr[i];
            } else if (arr[i] + arr[i + 1] < arr[i] * arr[i + 1]) {
                answer += arr[i] * arr[i + 1];
                i++;
            } else {
                answer += arr[i];
            }
        }

        System.out.println(answer);
        br.close();
    }
}
