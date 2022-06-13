package _2weeks0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_1092 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] cranes = new Integer[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            cranes[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        br.close();
        Arrays.sort(cranes, (a, b) -> Integer.compare(b, a));
        Arrays.sort(arr, (a, b) -> Integer.compare(b, a));

        if (cranes[0] < arr[0]) {
            System.out.println(-1);
            return;
        }

        int answer = 0;
        int cnt = 0;
        outer: while (cnt != m) {
            answer++;
            int i = 0;
            for (int j = 0; j < m; j++) {
                if (arr[j] != -1 && arr[j] <= cranes[i]) {
                    cnt++;
                    i++;
                    arr[j] = -1;
                }

                if (i == n) {
                    continue outer;
                }
            }
        }

        System.out.println(answer);
    }
}
