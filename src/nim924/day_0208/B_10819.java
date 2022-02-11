package day_0208;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_10819 {
	
	static int n, arr[], numbers[], max;
	static boolean isSelected[];

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		arr = new int[n];
		numbers = new int[n];
		isSelected = new boolean[n];
		max = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		per(0);
		System.out.println(max);
		
		
	}
	
	public static void per(int cnt) {
		
		if(cnt == n) {
			int sum=0;
			for(int i=0; i<n-1; i++) {
				sum += Math.abs((numbers[i] - numbers[i+1]));
			}
			if(sum > max) {
				max = sum;
				return;
			}
		}
		for(int i=0; i<n; i++) {
			
			if(isSelected[i]) continue;
			
			numbers[cnt] = arr[i];
			isSelected[i] = true;
			per(cnt+1);
			isSelected[i] = false;
		}
	}

}
