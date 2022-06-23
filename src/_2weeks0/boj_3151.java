package _2weeks0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_3151 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        br.close();

        int idxMinus = 0;
        int idxPlus = n;
        for (int i = 0; i < n; i++) {
            if (arr[i] < 0) {
                idxMinus = i;
            } else if (0 < arr[i]) {
                idxPlus = i;
                break;
            }
        }

        long answer = 0;

        for (int i = 0; i <= idxMinus; i++) {
            for (int j = i + 1; j <= idxMinus; j++) {
                int ub = upperBound(arr, idxPlus, n, -(arr[i] + arr[j]));
                int lb = lowerBound(arr, idxPlus, n, -(arr[i] + arr[j]));
                answer += ub - lb;
            }
        }
        for (int i = idxMinus + 1; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int ub = upperBound(arr, 0, idxMinus + 1, -(arr[i] + arr[j]));
                int lb = lowerBound(arr, 0, idxMinus + 1, -(arr[i] + arr[j]));
                answer += ub - lb;
            }
        }

        int cntZero = idxPlus - idxMinus - 1;
        if (0 < cntZero) {
            long[][] dp = new long[cntZero + 1][3 + 1];
            dp[0][0] = 1;
            for (int i = 1; i <= cntZero; i++) {
                for (int j = 0; j <= 3; j++) {
                    if (j == 0) {
                        dp[i][0] = 1;
                    } else {
                        dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
                    }
                }
            }

            answer += dp[cntZero][3];
        }
        System.out.println(answer);
    }

    static int lowerBound(int[] arr, int left, int right, int value) {
        if (right <= left) {
            return left;
        }

        int mid = (left + right) / 2;
        if (arr[mid] < value) {
            return lowerBound(arr, mid + 1, right, value);
        } else {
            return lowerBound(arr, left, mid, value);
        }
    }

    static int upperBound(int[] arr, int left, int right, int value) {
        if (right <= left) {
            return left;
        }

        int mid = (left + right) / 2;
        if (arr[mid] <= value) {
            return upperBound(arr, mid + 1, right, value);
        } else {
            return upperBound(arr, left, mid, value);
        }
    }
}
