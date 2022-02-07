package study.d0207;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1051 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer NM = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(NM.nextToken()) , M = Integer.parseInt(NM.nextToken());
		int ans = 0;
		char[][] map = new char[N][];
		for(int i=0;i<N;i++) map[i] = br.readLine().toCharArray();
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				for(int k=ans;k<50;k++) {
					int I = i+k , J = j+k;
					if(I>=N || J>=M) break;
					if(map[i][j]==map[I][j] && map[i][j]==map[i][J] && map[i][j]==map[I][J]) ans = Math.max(ans, k);
				}
			}
		}
		System.out.print((ans+1)*(ans+1));
	}
}
