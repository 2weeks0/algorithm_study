package _2weeks0;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class boj_9205 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());

        for (int t = 0; t < tc; t++) {
            int n = Integer.parseInt(br.readLine());

            Point[] points = new Point[n + 2];
            for (int i = 0; i < n + 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                Point point = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
                points[i] = point;
            }

            boolean[][] success = new boolean[n + 2][n + 2];
            for (int k = -1; k < n + 2; k++) {
                for (int r = 0; r < n + 2; r++) {
                    for (int c = 0; c < n + 2; c++) {
                        if (k == -1) {
                            success[r][c] = points[r].distanceTo(points[c]) <= 1000;
                        } else if (!success[r][c]){
                            success[r][c] = success[r][k] && success[k][c];
                        }
                    }
                }
            }

            bw.append(success[0][n + 1] ? "happy" : "sad");
            bw.newLine();
        }
        bw.close();
        br.close();
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int distanceTo(Point other) {
            return Math.abs(x - other.x) + Math.abs(y - other.y);
        }
    }
}
