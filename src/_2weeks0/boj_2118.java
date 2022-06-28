package _2weeks0;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj_2118 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            arr[i] = Integer.parseInt(br.readLine()) + arr[i - 1];
        }

        int left = 0;
        int right = 1;
        int answer = 0;
        int temp;
        while (right < n && left < right) {
            temp = getDist(arr, left, right);
            answer = Math.max(answer, temp);

            int next = getDist(arr, left, right + 1);
            if (temp < next) {
                right++;
            } else {
                left++;
            }
        }

        System.out.println(answer);
        br.close();
    }

    static int getDist(int[] arr, int left, int right) {
        int temp = arr[right] - arr[left];
        return Math.min(arr[arr.length - 1] - temp, temp);
    }
}
