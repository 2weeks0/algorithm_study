package _2weeks0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_1041 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[6];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 6; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long answer;
        int[] arrAsc = Arrays.stream(arr).sorted().toArray();
        if (n == 1) {
            answer = Arrays.stream(arrAsc).sum() - arrAsc[5];
        } else {
            int[] arrTopAsc = Arrays.stream(new int[]{arr[2], arr[3]}).sorted().toArray();
            int[] arrSideAsc = Arrays.stream(new int[]{arr[0], arr[1], arr[4], arr[5]}).sorted().toArray();
            int[] arrSide2Asc = Arrays.stream(new int[]{
                    arr[0] + arr[1],
                    arr[1] + arr[5],
                    arr[5] + arr[4],
                    arr[4] + arr[0]
            }).sorted().toArray();

            int min = arrAsc[0];
            int min2 = Math.min(arrSide2Asc[0], arrTopAsc[0] + arrSideAsc[0]);
            int minTopSide2 = arrTopAsc[0] + arrSide2Asc[0];

            answer = ((4L * (n - 2)) * min + 4L * min2) * (n - 1)
                    + (4L * (n - 2)) * min2
                    + 4L * minTopSide2
                    + (long) (n - 2) * (n - 2) * min;
        }
        System.out.println(answer);
        br.close();
    }
}
