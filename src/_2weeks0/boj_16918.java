package _2weeks0;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class boj_16918 {
    static final int[] dr = {0, 0, 1, 0, -1};
    static final int[] dc = {0, 1, 0, -1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[][] map = new int[r][c];
        for (int cr = 0; cr < r; cr++) {
            String line = br.readLine();
            for (int cc = 0; cc < c; cc++) {
                if (line.charAt(cc) == 'O') {
                    map[cr][cc] = 2;
                }
            }
        }

        for (int t = 1; t < n; t++) {
            Set<int[]> set = new HashSet<>();
            for (int cr = 0; cr < r; cr++) {
                for (int cc = 0; cc < c; cc++) {
                    if (map[cr][cc] == 0) {
                        continue;
                    } else if (--map[cr][cc] == 0) {
                        set.add(new int[]{cr, cc});
                    }
                }
            }
            setBomb(r, c, map);
            bomb(r, c, map, set);
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int cr = 0; cr < r; cr++) {
            for (int cc = 0; cc < c; cc++) {
                bw.append(map[cr][cc] == 0 ? '.' : 'O');
            }
            bw.newLine();
        }

        bw.close();
        br.close();
    }

    static void setBomb(int r, int c, int[][] map) {
        for (int cr = 0; cr < r; cr++) {
            for (int cc = 0; cc < c; cc++) {
                if (map[cr][cc] == 0) {
                    map[cr][cc] = 3;
                }
            }
        }
    }

    static void bomb(int r, int c, int[][] map, Set<int[]> set) {
        for (int[] point : set) {
            for (int d = 0; d < dr.length; d++) {
                int nr = point[0] + dr[d];
                int nc = point[1] + dc[d];
                if (0 <= nr && nr < r && 0 <= nc && nc < c) {
                    map[nr][nc] = 0;
                }
            }
        }
    }
}
