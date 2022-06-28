package _2weeks0;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class boj_7682 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str;
        outer:
        while (!(str = br.readLine()).equals("end")) {
            int[] cnts = new int[2];
            char winner = 'n';

            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if (ch == 'X') {
                    cnts[0]++;
                } else if (ch == 'O') {
                    cnts[1]++;
                }
            }

            if (cnts[0] < cnts[1]) {
                bw.append("invalid\n");
                continue;
            }

            // 대각선 빙고 찾기 우하
            char ch = str.charAt(0);
            if (ch != '.') {
                if (str.charAt(4) == ch && str.charAt(8) == ch) {
                    winner = ch;
                }
            }

            // 대각선 빙고 찾기 좌상
            ch = str.charAt(2);
            if (ch != '.') {
                if (str.charAt(4) == ch && str.charAt(6) == ch) {
                    if (winner != 'n' && winner != ch) {
                        bw.append("invalid\n");
                        continue;
                    }
                    winner = ch;
                }
            }

            // 가로/세로 빙고 찾기
            for (int i = 0; i < 3; i++) {
                ch = str.charAt(3 * i);
                if (ch != '.') {
                    if (str.charAt(3 * i + 1) == ch && str.charAt(3 * i + 2) == ch) {
                        if (winner != 'n' && winner != ch) {
                            bw.append("invalid\n");
                            continue outer;
                        }
                        winner = ch;
                    }
                }

                ch = str.charAt(i);
                if (ch != '.') {
                    if (str.charAt(i + 3) == ch && str.charAt(i + 6) == ch) {
                        if (winner != 'n' && winner != ch) {
                            bw.append("invalid\n");
                            continue outer;
                        }
                        winner = ch;
                    }
                }
            }

            if ((winner == 'O' && cnts[0] == cnts[1])
                    || (winner == 'X' && cnts[0] == cnts[1] + 1)
                    || (winner == 'n' && cnts[0] == 5 && cnts[1] == 4)) {
                bw.append("valid\n");
            } else {
                bw.append("invalid\n");
            }

        }
        bw.close();
        br.close();
    }
}
