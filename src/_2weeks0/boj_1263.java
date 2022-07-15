package _2weeks0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_1263 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][2];
        int max = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            arr[i][0] = t;
            arr[i][1] = s;
            max = Math.max(max, Math.max(t, s));
        }

        Arrays.sort(arr, (a, b) -> Integer.compare(b[1], a[1]));

        int answer = 0;
        boolean[] time = new boolean[max];
        outer: for (int i = 0; i < n; i++) {
            int temp = arr[i][1] - 1;
            for (int j = 0; j < arr[i][0]; j++) {
                if (temp == -1) {
                    answer = -1;
                    break outer;
                }

                if (time[temp]) {
                    temp--;
                    j--;
                } else {
                    answer = temp;
                    time[temp--] = true;
                }
            }
        }

        System.out.println(answer);
        br.close();
    }
}
