package _2weeks0;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class boj_1484_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int g = Integer.parseInt(br.readLine());

        boolean findAnswer = false;
        for (long i = (int) Math.ceil(Math.sqrt(g)); 2 * i - 1 <= g; i++) {
            double sqrt = Math.sqrt(i * i - g);
            if (sqrt != 0 && Math.floor(sqrt) == sqrt) {
                bw.append(String.valueOf(i)).append('\n');
                findAnswer = true;
            }
        }

        if (!findAnswer) {
            bw.append("-1");
        }

        bw.close();
        br.close();
    }
}
