package _2weeks0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class boj_2138 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        boolean[] arr = new boolean[n];
        String line = br.readLine();
        for (int i = 0; i < n; i++) {
            arr[i] = line.charAt(i) == '1';
        }

        boolean[] dest = new boolean[n];
        line = br.readLine();
        for (int i = 0; i < n; i++) {
            dest[i] = line.charAt(i) == '1';
        }

        System.out.println(solve(n, arr, dest));
        br.close();
    }

    static int solve(int n, boolean[] arr, boolean[] dest) {
        int result = 0;

        boolean[] temp = arr.clone();
        for (int i = 1; i < n; i++) {
            if (temp[i - 1] == dest[i - 1]) {
                continue;
            }
            pushButton(n, temp, i);
            result++;
        }

        if (Arrays.equals(temp, dest)) {
            return result;
        }

        temp = arr.clone();
        pushButton(n, temp, 0);
        result = 1;
        for (int i = 1; i < n; i++) {
            if (temp[i - 1] == dest[i - 1]) {
                continue;
            }
            pushButton(n, temp, i);
            result++;
        }

        if (Arrays.equals(temp, dest)) {
            return result;
        }
        return -1;
    }

    static void pushButton(int n, boolean[] arr, int idx) {
        if (idx != 0) {
            arr[idx - 1] = !arr[idx - 1];
        }
        arr[idx] = !arr[idx];
        if (idx != n - 1) {
            arr[idx + 1] = !arr[idx + 1];
        }
    }
}
