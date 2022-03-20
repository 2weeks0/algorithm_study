package _2weeks0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class boj_2504 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        br.close();

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '(' || c == '[') {
                stack.add(getKey(c));
                continue;
            }

            int temp = 0;
            while (true) {
                if (stack.isEmpty()) {
                    System.out.println(0);
                    return;
                }

                int current = stack.pop();
                if (0 < current) {
                    temp += current;
                } else if (current != getKey(c)) {
                    System.out.println(0);
                    return;
                } else {
                    stack.add(-1 * getKey(c) * (temp == 0 ? 1 : temp));
                    break;
                }
            }
        }

        int answer = 0;
        for (int i : stack) {
            if (i < 0) {
                answer = 0;
                break;
            }
            answer += i;
        }
        System.out.println(answer);
    }

    static int getKey(char c) {
        if (c == '(' || c == ')') {
            return -2;
        } else {
            return -3;
        }
    }
}
