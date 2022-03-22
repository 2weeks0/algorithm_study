package _2weeks0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class boj_16235 {
    static final int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
    static final int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] land = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(land[i], 5);
        }

        int[][] arr = new int[n][n];
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int r = 0; r < n; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < n; c++) {
                map.put(parseToKey(r, c), new ArrayList<>());
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }


        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int z = Integer.parseInt(st.nextToken());
            map.get(parseToKey(x, y)).add(z);
        }

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                Collections.sort(map.get(parseToKey(r, c)));
            }
        }

        for (int i = 0; i < k; i++) {
            spring(n, land, map);
            sfw(n, land, map, arr);
        }

        int answer = 0;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                answer += map.get(parseToKey(r, c)).size();
            }
        }
        System.out.println(answer);
        br.close();
    }

    static int parseToKey(int r, int c) {
        return 10 * r + c;
    }

    static void spring(int n, int[][] land, Map<Integer, ArrayList<Integer>> map) {
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                List<Integer> list = map.get(parseToKey(r, c));

                int size = list.size();
                for (int i = 0; i < size; i++) {
                    int value = list.get(i);
                    if (value <= land[r][c]) {
                        land[r][c] -= value;
                        list.set(i, value + 1);
                    } else {
                        list.set(i, (-1) * value);
                    }
                }
            }
        }
    }

    static void sfw(int n, int[][] land, Map<Integer, ArrayList<Integer>> map, int[][] arr) {
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                List<Integer> list = map.get(parseToKey(r, c));
                for (int i = list.size() - 1; 0 <= i; i--) {
                    int value = list.get(i);
                    if (value < 0) {
                        list.remove(i);
                        land[r][c] -= value / 2;
                    } else if (value % 5 == 0) {
                        for (int d = 0; d < dr.length; d++) {
                            int nr = r + dr[d];
                            int nc = c + dc[d];
                            if (nr < 0 || n <= nr || nc < 0 || n <= nc) {
                                continue;
                            }
                            map.get(parseToKey(nr, nc)).add(0, 1);
                        }
                    }
                }
                land[r][c] += arr[r][c];
            }
        }
    }
}
