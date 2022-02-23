package _2weeks0;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;

public class boj_2780 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        LinkedList<Integer>[] links = new LinkedList[10];
        for (int i = 0; i < 10; i++) {
            links[i] = new LinkedList<>();
        }
        links[1].add(2);
        links[1].add(4);
        links[2].add(1);
        links[2].add(3);
        links[2].add(5);
        links[3].add(2);
        links[3].add(6);
        links[4].add(1);
        links[4].add(5);
        links[4].add(7);
        links[5].add(2);
        links[5].add(4);
        links[5].add(6);
        links[5].add(8);
        links[6].add(3);
        links[6].add(5);
        links[6].add(9);
        links[7].add(4);
        links[7].add(8);
        links[7].add(0);
        links[8].add(5);
        links[8].add(7);
        links[8].add(9);
        links[9].add(6);
        links[9].add(8);
        links[0].add(7);

        int[][] dp = new int[10][1001];
        for (int i = 0; i < 10; i++) {
            dp[i][1] = 1;
        }

        for (int l = 2; l <= 1000; l++) {
            for (int i = 0; i < 10; i++) {
                for (int j : links[i]) {
                    dp[i][l] += dp[j][l - 1];
                    dp[i][l] %= 1_234_567;
                }
            }
        }


        int t = Integer.parseInt(br.readLine());
        for (int i = 1; i <= t; i++) {
            int n = Integer.parseInt(br.readLine());

            int answer = 0;
            for (int j = 0; j < 10; j++) {
                answer += dp[j][n];
            }

            bw.append(String.valueOf(answer% 1_234_567)).append('\n');
        }

        bw.close();
        br.close();
    }
}
