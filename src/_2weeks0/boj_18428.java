package _2weeks0;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj_18428 {
    static final char STUDENT = 'S';
    static final char TEACHER = 'T';
    static final char OBJECT = 'O';
    static final char EMPTY = 'X';

    static boolean canHide = false;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        char[][] map = new char[n][];
        for (int r = 0; r < n; r++) {
            map[r] = br.readLine().replace(" ", "").toCharArray();
        }

        recursive(n, map, 0, 0);

        System.out.println(canHide ? "YES" : "NO");
        br.close();
    }

    static void recursive(int n, char[][] map, int idx, int cnt) {
        if (canHide) {
            return;
        } else if (cnt == 3) {
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    if (map[r][c] == TEACHER && !canHide(n, map, r, c)) {
                        return;
                    }
                }
            }
            canHide = true;
            return;
        }

        for (int i = idx; i < n * n; i++) {
            int r = i / n;
            int c = i % n;
            if (map[r][c] == EMPTY) {
                map[r][c] = OBJECT;
                recursive(n, map, i + 1, cnt + 1);
                map[r][c] = EMPTY;
            }
        }
    }

    static boolean canHide(int n, char[][] map, int r, int c) {
        int temp = r;
        while (isInRange(n, --temp, c)) {
            if (map[temp][c] == OBJECT) {
                break;
            } else if (map[temp][c] == STUDENT) {
                return false;
            }
        }
        temp = r;
        while (isInRange(n, ++temp, c)) {
            if (map[temp][c] == OBJECT) {
                break;
            } else if (map[temp][c] == STUDENT) {
                return false;
            }
        }
        temp = c;
        while (isInRange(n, r, --temp)) {
            if (map[r][temp] == OBJECT) {
                break;
            } else if (map[r][temp] == STUDENT) {
                return false;
            }
        }
        temp = c;
        while (isInRange(n, r, ++temp)) {
            if (map[r][temp] == OBJECT) {
                break;
            } else if (map[r][temp] == STUDENT) {
                return false;
            }
        }
        return true;
    }

    static boolean isInRange(int n, int r, int c) {
        return 0 <= r && r < n && 0 <= c && c < n;
    }
}
