package _2weeks0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class boj_16925 {
    static char[] answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[2 * (n - 1)];
        for (int i = 0; i < 2 * (n - 1); i++) {
            arr[i] = br.readLine();
        }

        String[] temp = arr.clone();
        Arrays.sort(temp, Comparator.comparingInt(String::length));

        for (int i = 0; i < 2 * (n - 1); i++) {
            for (int j = 2 * (n - 1) - 1; 0 <= j; j--)  {
                solve(n, temp[i] + temp[j], arr);
                if (answer != null) {
                    printAnswer(temp[i] + temp[j]);
                    br.close();
                    return;
                }
            }
        }
    }

    static void solve(int n, String str, String[] arr) {
        char[] temp = new char[2 * (n - 1)];
        boolean[] useP = new boolean[n];
        for (int i = 0; i < arr.length; i++) {
            if (str.startsWith(arr[i]) && !useP[arr[i].length()]) {
                temp[i] = 'P';
                useP[arr[i].length()] = true;
            } else if (str.endsWith(arr[i])) {
                temp[i] = 'S';
            } else {
                return;
            }
        }
        answer = temp;
    }

    static void printAnswer(String str) {
        System.out.println(str);
        for (char c : answer) {
            System.out.print(c);
        }
    }
}
