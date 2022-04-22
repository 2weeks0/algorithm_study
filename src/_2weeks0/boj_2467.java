package _2weeks0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2467 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int min = Integer.MAX_VALUE;
        int a = 0;
        int b = 0;
        for (int i = 0; i < n - 1; i++) {
            int idx = binarySearch(arr, i + 1, n - 1, arr[i]);
            if (i != idx && Math.abs(arr[i] + arr[idx]) < min) {
                min = Math.abs(arr[i] + arr[idx]);
                a = arr[i];
                b = arr[idx];
            }
            if (0 <= idx - 1 && i != idx - 1 && Math.abs(arr[i] + arr[idx - 1]) < min) {
                min = Math.abs(arr[i] + arr[idx - 1]);
                a = arr[i];
                b = arr[idx - 1];
            }
            if (idx + 1 < n && i != idx + 1 && Math.abs(arr[i] + arr[idx + 1]) < min) {
                min = Math.abs(arr[i] + arr[idx + 1]);
                a = arr[i];
                b = arr[idx + 1];
            }
        }

        System.out.printf("%d %d\n", a, b);
        br.close();
    }

    static int binarySearch(int[] arr, int left, int right, int value) {
        if (right <= left) {
            return right;
        }

        int mid = (left + right) / 2;
        if (arr[mid] + value == 0) {
            return mid;
        } else if (0 < arr[mid] + value) {
            return binarySearch(arr, left, mid - 1, value);
        } else {
            return binarySearch(arr, mid + 1, right, value);
        }
    }
}
