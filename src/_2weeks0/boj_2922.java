package _2weeks0;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj_2922 {
    static long answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();

        recursive(arr, 0, 0, 1, false);

        System.out.println(answer);
        br.close();
    }

    static void recursive(char[] arr, int idx, int cntVowel, long cnt, boolean hasL) {
        if (Math.abs(cntVowel) == 3) {
            return;
        } else if (idx == arr.length) {
            if (hasL) {
                answer += cnt;
            }
            return;
        }

        if (arr[idx] == '_') {
            recursive(arr, idx + 1, cntVowel < 0 ? 1 : cntVowel + 1, cnt * 5, hasL);
            if (hasL) {
                recursive(arr, idx + 1, cntVowel < 0 ? cntVowel - 1 : -1, cnt * 21, true);
            } else {
                recursive(arr, idx + 1, cntVowel < 0 ? cntVowel - 1 : -1, cnt * 20, false);
                recursive(arr, idx + 1, cntVowel < 0 ? cntVowel - 1 : -1, cnt, true);
            }
        } else if (isVowel(arr[idx])) {
            recursive(arr, idx + 1, cntVowel < 0 ? 1 : cntVowel + 1, cnt, hasL);
        } else {
            recursive(arr, idx + 1, cntVowel < 0 ? cntVowel - 1 : -1, cnt, hasL | arr[idx] == 'L');
        }
    }

    static boolean isVowel(char c) {
        return c == 'I' || c == 'A' || c == 'E' || c == 'O' || c == 'U';
    }
}
