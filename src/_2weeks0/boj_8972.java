package _2weeks0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class boj_8972 {
    static final int[] dr = {1, 1, 1, 0, 0, 0, -1, -1, -1};
    static final int[] dc = {-1, 0, 1, -1, 0, 1, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        Point me = null;
        List<Point> enemies = new ArrayList<>();
        char[][] board = new char[r][c];
        for (int cr = 0; cr < r; cr++) {
            String line = br.readLine();
            for (int cc = 0; cc < c; cc++) {
                board[cr][cc] = line.charAt(cc);
                if (board[cr][cc] == 'I') {
                    me = new Point(cr, cc);
                } else if (board[cr][cc] == 'R') {
                    enemies.add(new Point(cr, cc));
                }
            }
        }
        assert me != null;

        int cnt = 0;
        String directions = br.readLine();
        br.close();
        Set<Point> toDelete = new HashSet<>();
        for (int i = 0; i < directions.length(); i++) {
            cnt++;
            int d = directions.charAt(i) - '0' - 1;
            board[me.r][me.c] = '.';
            me.r += dr[d];
            me.c += dc[d];
            if (board[me.r][me.c] == 'R') {
                System.out.printf("kraj %d", cnt);
                return;
            }
            board[me.r][me.c] = 'I';

            for (Point enemy : enemies) {
                d = getEnemyDirection(enemy, me) - 1;
                board[enemy.r][enemy.c] = '.';
                enemy.r += dr[d];
                enemy.c += dc[d];
                if (board[enemy.r][enemy.c] == 'I') {
                    System.out.printf("kraj %d", cnt);
                    return;
                }
            }
            for (Point enemy : enemies) {
                if (board[enemy.r][enemy.c] == 'R') {
                    toDelete.add(new Point(enemy.r, enemy.c));
                } else {
                    board[enemy.r][enemy.c] = 'R';
                }
            }

            for (Point del : toDelete) {
                board[del.r][del.c] = '.';
                enemies.removeIf(it -> it.equals(del));
            }
            toDelete.clear();
        }

        StringBuilder sb = new StringBuilder();
        for (int cr = 0; cr < r; cr++) {
            for (int cc = 0; cc < c; cc++) {
                sb.append(board[cr][cc]);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    static int getEnemyDirection(Point enemy, Point me) {
        if (enemy.r < me.r) {
            return enemy.c == me.c ? 2 : (enemy.c < me.c ? 3 : 1);
        } else if (enemy.r == me.r) {
            return enemy.c == me.c ? 5 : (enemy.c < me.c ? 6 : 4);
        } else {
            return enemy.c == me.c ? 8 : (enemy.c < me.c ? 9 : 7);
        }
    }

    static class Point {
        int r;
        int c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Point)) {
                return false;
            }
            return hashCode() == o.hashCode();
        }

        @Override
        public int hashCode() {
            return 100 * r + c;
        }
    }
}
