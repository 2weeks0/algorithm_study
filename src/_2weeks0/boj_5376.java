package _2weeks0;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class boj_5376 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());

        for (int t = 0; t < tc; t++) {
            String line = br.readLine();

            long top;
            long bot;
            int idx = line.indexOf('(');
            if (idx == -1) {
                top = Long.parseLong(line.substring(2));
                bot = 1;
                for (int i = 0; i < line.length() - 2; i++) {
                    bot *= 10;
                }
            } else {
                long left;
                if (idx == 2) {
                    left = 0;
                } else {
                    left = Long.parseLong(line.substring(2, idx));
                }
                long right = Long.parseLong(line.substring(idx + 1, line.length() - 1));
                top = Long.parseLong(String.valueOf(left) + right) - left;

                bot = 0;
                for (int i = 0; i < line.length() - idx - 2; i++) {
                    bot = 10 * bot + 9;
                }
                for (int i = 0; i < idx - 2; i++) {
                    bot *= 10;
                }
            }

            long gcd = gcd(top, bot);
            bw.append(String.valueOf(top / gcd)).append("/").append(String.valueOf(bot / gcd)).append('\n');
        }
        bw.close();
        br.close();
    }

    static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
