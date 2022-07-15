package _2weeks0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class boj_1686 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken()) * 60;
        int m = Integer.parseInt(st.nextToken());

        List<double[]> list = new ArrayList<>();
        String str;
        while ((str = br.readLine()) != null && !str.isEmpty()) {
            st = new StringTokenizer(str);
            list.add(new double[]{
                    Double.parseDouble(st.nextToken()),
                    Double.parseDouble(st.nextToken())
            });
        }

        int cnt = bfs(v, m, list);
        if (cnt == -1) {
            System.out.println("No.");
        } else {
            System.out.printf("Yes, visiting %d other holes.\n", cnt);
        }
        br.close();
    }

    static int bfs(int v, int m, List<double[]> list) {
        Queue<double[]> queue = new ArrayDeque<>();
        queue.add(list.get(0));
        int[] visited = new int[list.size()];

        while (!queue.isEmpty()) {
            double[] current = queue.poll();
            int index = list.indexOf(current);
            if (getDistance(current, list.get(1)) < (v * m) * (v * m)) {
                return index == -1 ? 0 : visited[index];
            }

            for (int i = 2; i < list.size(); i++) {
                if (visited[i] != 0 || (v * m) * (v * m) <= getDistance(current, list.get(i))) {
                    continue;
                }

                visited[i] += (index == -1 ? 0 : visited[index]) + 1;
                queue.add(list.get(i));
            }
        }
        return -1;
    }

    static double getDistance(double[] from, double[] to) {
        return (from[0] - to[0]) * (from[0] - to[0]) + (from[1] - to[1]) * (from[1] - to[1]);
    }
}
