package _2weeks0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class boj_20055 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[2*n];
        for (int i =0;i<2 *n;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        List<Integer> robots = new ArrayList<>();
        while (true) {
            answer++;
            moveBelt(arr, robots);
            moveRobot(arr, robots);
            putRobot(arr, robots);
            if (k <= Arrays.stream(arr).filter(i -> i == 0).count()) {
                break;
            }
        }

        System.out.println(answer);
        br.close();
    }

    static void moveBelt(int[] arr, List<Integer> robots) {
        int temp = arr[arr.length - 1];
        for (int i = arr.length - 2; 0 <= i; i--) {
            arr[i + 1] = arr[i];
        }
        arr[0] = temp;

        for (int i = 0; i < robots.size(); i++) {
            int idxRobot = robots.get(i);
            int idxToMove = (idxRobot + 1) % arr.length;
            if (idxToMove == arr.length / 2 - 1) {
                robots.remove(i);
                i--;
                continue;
            }
            robots.set(i, idxToMove);

        }
    }

    static void moveRobot(int[] arr, List<Integer> robots) {
        for (int i = 0; i < robots.size(); i++) {
            int idxRobot = robots.get(i);
            int idxToMove = (idxRobot + 1) % arr.length;
            if (0 < arr[idxToMove] && !robots.contains(idxToMove)) {
                arr[idxToMove]--;
                if (idxToMove == arr.length / 2 - 1) {
                    robots.remove(i);
                    i--;
                    continue;
                }
                robots.set(i, idxToMove);
            }
        }
    }

    static void putRobot(int[] arr, List<Integer> robots) {
        if (0 < arr[0]) {
            robots.add(0);
            arr[0]--;
        }
    }
}
