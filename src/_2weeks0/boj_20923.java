package _2weeks0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class boj_20923 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Deque<Integer> dodo = new ArrayDeque<>();
        Deque<Integer> su = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            dodo.addLast(Integer.parseInt(st.nextToken()));
            su.addLast(Integer.parseInt(st.nextToken()));
        }
        br.close();

        Deque<Integer> groundDo = new ArrayDeque<>();
        Deque<Integer> groundSu = new ArrayDeque<>();

        for (int i = 0; i < m; i++) {
            if (dodo.size() == 1) {
                System.out.println("su");
                return;
            }
            groundDo.addFirst(dodo.pollLast());
            assert !groundDo.isEmpty();
            if (groundDo.peekFirst() == 5) {
               winDo(dodo, groundDo, groundSu);
            } else if (!groundSu.isEmpty() && groundDo.peekFirst() + groundSu.peekFirst() == 5) {
                winSu(su, groundDo, groundSu);
            }

            i++;
            if (i == m) {
                break;
            }

            if (su.size() == 1) {
                System.out.println("do");
                return;
            }
            groundSu.addFirst(su.pollLast());
            assert !groundSu.isEmpty();
            if (groundSu.peekFirst() == 5) {
                winDo(dodo, groundDo, groundSu);
            } else if (!groundDo.isEmpty() && groundDo.peekFirst() + groundSu.peekFirst() == 5) {
                winSu(su, groundDo, groundSu);
            }

        }

        if (dodo.size() == su.size()) {
            System.out.println("dosu");
        } else if (dodo.size() < su.size()) {
            System.out.println("su");
        } else {
            System.out.println("do");
        }
    }

    static void winDo(Deque<Integer> dodo, Deque<Integer> groundDo, Deque<Integer> groundSu) {
        while (!groundSu.isEmpty()) {
            dodo.addFirst(groundSu.pollLast());
        }
        while (!groundDo.isEmpty()) {
            dodo.addFirst(groundDo.pollLast());
        }
    }

    static void winSu(Deque<Integer> su, Deque<Integer> groundDo, Deque<Integer> groundSu) {
        while (!groundDo.isEmpty()) {
            su.addFirst(groundDo.pollLast());
        }
        while (!groundSu.isEmpty()) {
            su.addFirst(groundSu.pollLast());
        }
    }
}
