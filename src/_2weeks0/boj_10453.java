package _2weeks0;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class boj_10453 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());

        for (int t = 0; t < tc; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String left = st.nextToken();
            String right = st.nextToken();

            if (left.length() != right.length()) {
                bw.append("-1\n");
                continue;
            }

            int[] leftBIdx = new int[left.length() / 2];
            int[] rightBIdx = new int[right.length() / 2];

            int idx = 0;
            for (int i = 0; i < left.length(); i++) {
                if (left.charAt(i) == 'b') {
                    leftBIdx[idx++] = i;
                }
            }

            idx = 0;
            for (int i = 0; i < right.length(); i++) {
                if (right.charAt(i) == 'b') {
                    rightBIdx[idx++] = i;
                }
            }

            int answer = 0;
            for (int i = 0; i < leftBIdx.length; i++) {
                answer += Math.abs(rightBIdx[i] - leftBIdx[i]);
            }

            bw.append(String.valueOf(answer)).append('\n');
        }
        bw.close();
        br.close();
    }
}
