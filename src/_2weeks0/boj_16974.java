package _2weeks0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_16974 {
    static long[] cntPatty = new long[51];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        long x = Long.parseLong(st.nextToken());
        System.out.println(search(1, getHamburgerHeight(n), x, n));
        br.close();
    }

    static long search(long start, long end, long x, int n) {
        if (start == x) {
            return 0;
        } else if (end == x) {
            return cntPatty[n];
        } else if (n == 1) {
            return x - start;
        }

        long mid = (start + end) / 2;
        if (mid == x) {
            return cntPatty[n - 1] + 1;
        } else if (mid < x) {
            return cntPatty[n - 1] + 1 + search(mid + 1, end - 1, x, n - 1);
        } else {
            return search(start + 1, mid - 1, x, n - 1);
        }
    }

    static long getHamburgerHeight(int n) {
        if (n == 0) {
            cntPatty[n] = 1;
            return 1;
        }
        long result = 3 + 2 * getHamburgerHeight(n - 1);
        cntPatty[n] = 2 * cntPatty[n - 1] + 1;
        return result;
    }

}
