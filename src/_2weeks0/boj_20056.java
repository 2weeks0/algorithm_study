package _2weeks0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj_20056 {
    static final int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
    static final int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<Fireball> fireballList = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int mm = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            fireballList.add(new Fireball(r, c, mm, s, d));
        }


        for (int i = 0; i < k; i++) {
            int[][] board = new int[n][n];
            for (Fireball fireball : fireballList) {
                fireball.move(n);
                board[fireball.r][fireball.c]++;
            }

            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    if (board[r][c] <= 1) {
                        continue;
                    }

                    int cnt = 0;
                    int sumM = 0;
                    int sumS = 0;
                    int cntOdd = 0;
                    int size = fireballList.size();
                    for (int j = size - 1; 0 <= j; j--) {
                        Fireball fireball = fireballList.get(j);
                        if (!(fireball.r == r && fireball.c == c)) {
                            continue;
                        }
                        cnt++;
                        sumM += fireball.m;
                        sumS += fireball.s;
                        cntOdd += (fireball.d % 2) == 1 ? 1 : 0;
                        fireballList.remove(j);
                    }

                    if (sumM / 5 == 0) {
                        continue;
                    }

                    if (cntOdd == 0 || cntOdd == cnt) {
                        for (int d = 0; d < 8; d += 2) {
                            fireballList.add(new Fireball(r, c, sumM / 5, sumS / cnt, d));
                        }
                    } else {
                        for (int d = 1; d < 8; d += 2) {
                            fireballList.add(new Fireball(r, c, sumM / 5, sumS / cnt, d));
                        }
                    }
                }
            }
        }

        int answer = 0;
        for (Fireball fireball : fireballList) {
            answer += fireball.m;
        }
        System.out.println(answer);
        br.close();
    }

    static class Fireball {
        int r;
        int c;
        int m;
        int s;
        int d;

        public Fireball(int r, int c, int m, int s, int d) {
            this.r = r;
            this.c = c;
            this.m = m;
            this.s = s;
            this.d = d;
        }

        void move(int n) {
            r = (r + dr[d] * s) % n;
            if (r < 0) {
                r += n;
            }
            c = (c + dc[d] * s) % n;
            if (c < 0) {
                c += n;
            }
        }
    }
}
