package day_0207;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1051 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s);
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int [][] arr = new int[N][M];
		for(int i=0; i<N; i++) {
			s = br.readLine();
			for(int j=0; j<M; j++) {
				arr[i][j] = s.charAt(j) - '0';
			}
		}
		int max = 0;
		for(int i=0; i<N-1; i++) {
			for(int j=0; j<M-1; j++) {
				for(int k=0; k<Math.min(N, M); k++) {
					if(i+k < N && j+k < M && 
							arr[i][j] == arr[i+k][j+k] && arr[i][j] == arr[i+k][j] 
							&& arr[i][j] == arr[i][j+k]) {
						max = Math.max(max, (k+1)*(k+1));
					}
				}
			}
		}
		if(max == 0) {
			System.out.println(1);
		}else {
			System.out.println(max);
		}

	}

}
