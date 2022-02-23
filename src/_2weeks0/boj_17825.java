package _2weeks0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_17825 {
    static final int CNT_DICE = 10;
    static final int CNT_HORSE = 4;
    static int answer = 0;

    static Node head;
    static Node tail;
    static Node center;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] dices = new int[CNT_DICE];
        for (int i = 0; i < CNT_DICE; i++) {
            dices[i] = Integer.parseInt(st.nextToken());
        }

        createLinkedList();
        Node[] horses = new Node[]{head, head, head, head};

        move(dices, horses, 0, 0);

        System.out.println(answer);
        br.close();
    }

    static void move(int[] dices, Node[] horses, int diceIdx, int score) {
        if (diceIdx != 0 && horses[0] == head) {
            return;
        } else if (diceIdx == CNT_DICE) {
            answer = Math.max(answer, score);
            return;
        }

        outer: for (int i = 0; i < CNT_HORSE; i++) {
            Node temp = horses[i];
            Node next = horses[i].move(dices[diceIdx]);

            for (int j = 0; j < CNT_HORSE; j++) {
                if (horses[j] == next && next != tail) {
                    continue outer;
                }
            }
            horses[i] = horses[i].move(dices[diceIdx]);
            move(dices, horses, diceIdx + 1, score + horses[i].score);
            horses[i] = temp;
        }
    }

    static void createLinkedList() {
        head = new Node(0);
        Node node = head;
        for (int i = 2; i <= 40; i += 2) {
            node = addRed(node, i);
            if (i == 10) {
                Node temp = node;
                temp = addBlue(temp, 13);
                temp = addRed(temp, 16);
                temp = addRed(temp, 19);
                center = addRed(temp, 25);
            } else if (i == 20) {
                Node temp = node;
                temp = addBlue(temp, 22);
                temp = addRed(temp, 24);
                temp.redPath = center;
            } else if (i == 30) {
                Node temp = node;
                temp = addBlue(temp, 28);
                temp = addRed(temp, 27);
                temp = addRed(temp, 26);
                temp.redPath = center;
            }
        }
        Node temp = center;
        temp = addRed(temp, 30);
        temp = addRed(temp, 35);
        temp.redPath = node;
        node.redPath = new Node(0);
        tail = node.redPath;
    }

    static Node addRed(Node node, int score) {
        Node result = new Node(score);
        node.redPath = result;
        return result;
    }

    static Node addBlue(Node node, int score) {
        Node result = new Node(score);
        node.bluePath = result;
        return result;
    }

    static class Node {
        int score;
        Node redPath;
        Node bluePath;

        public Node(int score) {
            this.score = score;
        }

        Node move(int dice) {
            if (this == tail) {
                return this;
            }
            Node next = bluePath != null ? bluePath : redPath;
            for (int i = 0; i < dice - 1; i++) {
                if (next == tail) {
                    return tail;
                }
                next = next.redPath;

            }
            return next;
        }
    }
}
