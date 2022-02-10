package _2weeks0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj_14891 {
    static final int CLOCKWISE = 1;
    static final int COUNTERCLOCKWISE = -1;

    static final int IDX_RIGHT = 2;
    static final int IDX_LEFT = 6;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedList<Integer>[] gears = new LinkedList[4];

        for (int i = 0; i < 4; i++) {
            gears[i] = new LinkedList<>();
            String s = br.readLine();
            for (int j = 0; j < s.length(); j++) {
                gears[i].add(s.charAt(j) - '0');
            }
        }

        Stack<int[]> rotateInfo = new Stack<>();
        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken()) - 1;
            int direction = Integer.parseInt(st.nextToken());

            calculateRotation(gears, idx, direction, rotateInfo);
            rotate(gears, rotateInfo);
        }

        int answer = 0;
        for (int i = 0; i < 4; i++) {
            answer += gears[i].peekFirst() * Math.pow(2, i);
        }
        System.out.println(answer);
    }

    static void calculateRotation(LinkedList<Integer>[] gears, int idx, int direction, Stack<int[]> rotateInfo) {
        rotateInfo.push(new int[]{idx, direction});
        int d = direction;
        for (int l = idx - 1; l >= 0; l--) {
            d *= -1;
            LinkedList<Integer> right = gears[l + 1];
            LinkedList<Integer> left = gears[l];

            if (left.get(IDX_RIGHT).equals(right.get(IDX_LEFT))) {
                break;
            }
            rotateInfo.push(new int[]{l, d});
        }

        d = direction;
        for (int r = idx + 1; r < 4; r++) {
            d *= -1;
            LinkedList<Integer> left = gears[r - 1];
            LinkedList<Integer> right = gears[r];

            if (left.get(IDX_RIGHT).equals(right.get(IDX_LEFT))) {
                break;
            }
            rotateInfo.push(new int[]{r, d});
        }
    }

    static void rotate(LinkedList<Integer>[] gears, Stack<int[]> rotateInfo) {
        while (!rotateInfo.isEmpty()) {
            int idx = rotateInfo.peek()[0];
            int direction = rotateInfo.pop()[1];
            LinkedList<Integer> gear = gears[idx];

            if (direction == CLOCKWISE) {
                gear.addFirst(gear.pollLast());
            } else {
                gear.addLast(gear.pollFirst());
            }
        }
    }
}
