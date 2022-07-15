package _2weeks0;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj_5525 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        String str = br.readLine();

        int[] arr = new int[m];
        for (int i = 0; i < m; i++) {
            if (str.startsWith("IOI", i)) {
                arr[i]++;
                i++;
            }
        }

        for (int i = m - 1; 0 <= i; i--) {
            if (arr[i] != 0 && 0 <= i - 2 && arr[i - 2] != 0) {
                arr[i - 2] += arr[i];
            }
        }

        int answer = 0;
        for (int i = 0; i < m; i++) {
            if (n <= arr[i]) {
                answer++;
            }
        }

        System.out.println(answer);
        br.close();
    }
}
