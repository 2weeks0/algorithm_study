package _2weeks0;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj_9241 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String before = br.readLine();
        String after = br.readLine();

        int left = 0;
        int right = 0;

        int min = Math.min(before.length(), after.length());
        for (int i = 0; i < min; i++) {
            if (before.charAt(i) != after.charAt(i)) {
                break;
            }
            left++;
        }

        for (int i = 0; i < min - left; i++) {
            if (before.charAt(before.length() - 1 - i) != after.charAt(after.length() - 1 - i)) {
                break;
            }
            right++;
        }

        System.out.println(after.length() - left - right);
        br.close();
    }
}
