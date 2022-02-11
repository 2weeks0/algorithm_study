package _2weeks0;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class boj_1991 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node('A' + i);
        }


        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int idx = st.nextToken().charAt(0) - 'A';
            int leftIdx = st.nextToken().charAt(0) - 'A';
            if (0 <= leftIdx) {
                nodes[idx].left = nodes[leftIdx];
            }
            int rightIdx = st.nextToken().charAt(0) - 'A';
            if (0 <= rightIdx) {
                nodes[idx].right = nodes[rightIdx];
            }
        }

        preOrder(nodes[0], bw);
        bw.newLine();
        inOrder(nodes[0], bw);
        bw.newLine();
        postOrder(nodes[0], bw);
        bw.newLine();

        bw.flush();
        bw.close();
        br.close();
    }

    static void preOrder(Node current, BufferedWriter bw) throws Exception {
        if (current == null) {
            return;
        }

        bw.append((char) current.value);
        preOrder(current.left, bw);
        preOrder(current.right, bw);
    }

    static void inOrder(Node current, BufferedWriter bw) throws Exception {
        if (current == null) {
            return;
        }

        inOrder(current.left, bw);
        bw.append((char) current.value);
        inOrder(current.right, bw);
    }

    static void postOrder(Node current, BufferedWriter bw) throws Exception {
        if (current == null) {
            return;
        }

        postOrder(current.left, bw);
        postOrder(current.right, bw);
        bw.append((char) current.value);
    }

    static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }
}
