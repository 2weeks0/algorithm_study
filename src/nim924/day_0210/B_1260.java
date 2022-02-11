package day_0210;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class B_1260 {
	
	static int[][] graph;
	static int N,M,V;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());

		graph = new int[N][N];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			graph[v1-1][v2-1] = 1;
			graph[v2-1][v1-1] = 1;
		}
		
//		for (int i = 0; i < graph.length; i++) {
//			for (int j = 0; j < graph.length; j++) {
//				System.out.print(graph[i][j]);
//			}
//			System.out.println();
//		}
		boolean isVisit[] = new boolean[N];
		dfs(V-1,isVisit);
		System.out.println();
		bfs(V-1);

	}
	
	public static void bfs(int current) {
		
		Queue<Integer> queue = new LinkedList<>();
		boolean[] isVisit = new boolean[N];
		queue.offer(current);
		isVisit[current] = true;
		while(!queue.isEmpty()) {
			current = queue.poll();
			System.out.print(current+1+ " ");
			for(int i=0; i<N; i++) {
				if(graph[current][i] == 1 && !isVisit[i]) {
					queue.offer(i);
					isVisit[i] = true;
				}
			}
		}
	}
	
	public static void dfs(int current, boolean[] isVisit) {
		if(isVisit[current]) return ;
		
		
		System.out.print(current+1+ " ");
		isVisit[current] = true;
		for(int i=0; i<N; i++) {
			if(graph[current][i] == 1 && !isVisit[i]) {
				dfs(i, isVisit);
			}
		}
		
	}

}
