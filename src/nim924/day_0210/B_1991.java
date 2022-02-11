package day_0210;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1991 {

	static int N;
	static int [][] tree;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		tree = new int[N][3];
		for (int n = 0; n < N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int temp = st.nextToken().charAt(0) - 65;
			tree[temp][1] = st.nextToken().charAt(0) - 65;
			tree[temp][2] = st.nextToken().charAt(0) - 65;
		}
		preOrder(0);
		System.out.println();
		inOrder(0);
		System.out.println();
		postOrder(0);

	}

	public static void preOrder(int cur) {
		if(cur < 0) {
//			System.out.println(cur);
//			System.out.println(cur);
			return;
		}
		System.out.print((char)(cur+65));
		preOrder(tree[cur][1]);
		preOrder(tree[cur][2]);
		

	}

	public static void inOrder(int cur) {
		if(cur < 0) {
//			System.out.println(cur);
			return;
		}
		
		inOrder(tree[cur][1]);
		System.out.print((char)(cur+65));
		inOrder(tree[cur][2]);
	}

	public static void postOrder(int cur) {
		if(cur < 0) {
//			System.out.println(cur);
			return;
		}
		
		postOrder(tree[cur][1]);
		postOrder(tree[cur][2]);
		System.out.print((char)(cur+65));
	}

}
