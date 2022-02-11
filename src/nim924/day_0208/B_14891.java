package day_0208;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class B_14891 {
	
	static ArrayList<ArrayList<Integer>> arr;
	static ArrayList<ArrayList<Integer>> temp_arr;
	static boolean isCheck[];
	static int [][]dir;
	static int[]isTurn;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		arr = new ArrayList<ArrayList<Integer>>();

		for (int i = 0; i < 4; i++) {
			String s = br.readLine();
			ArrayList<Integer> list = new ArrayList<>();
			for (int j = 0; j < 8; j++) {
				list.add(s.charAt(j) - '0');
			}
			arr.add(list);
		}

		int n = Integer.parseInt(br.readLine());

		int[][] dir = new int[n][2];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 2; j++) {
				dir[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<n; i++) {
			temp_arr = new ArrayList<ArrayList<Integer>>();
			for(int j=0; j<4; j++) {
				ArrayList<Integer> temp;
				temp = (ArrayList<Integer>) arr.get(j).clone();
				temp_arr.add(temp);
			}

			isCheck = new boolean[4];
			isTurn = new int[4];
			
//			System.out.println(dir[i][0] -1);
			isTurn[dir[i][0] -1 ] = dir[i][1];
			recur(dir[i][0] -1);
			
			for(int j=0; j<4; j++) {
				if(isTurn[j] == 1) {
					int val = temp_arr.get(j).get(7);
					temp_arr.get(j).remove(7);
					temp_arr.get(j).add(0,val);
				}else if(isTurn[j] == -1) {
					int val = temp_arr.get(j).get(0);
					temp_arr.get(j).remove(0);
					temp_arr.get(j).add(7,val);
				}
			}
			arr = temp_arr;
//			for(int j=0; j<4; j++) {
//				for(int k=0; k<8; k++) {
//					System.out.print(arr.get(j).get(k));
//				}
//				System.out.println();
//			}
//			System.out.println();
			
			
		}
		int sum = 0;
		if(arr.get(0).get(0) == 1) {
			sum += 1;
		}
		if(arr.get(1).get(0) == 1) {
			sum += 2;
		}
		if(arr.get(2).get(0) == 1) {
			sum += 4;
		}
		if(arr.get(3).get(0) == 1) {
			sum += 8;
		}
		
		System.out.println(sum);
		

		

	}
	
	public static void recur(int idx) {
		
		if(idx < 0 || idx ==4) {
			return ;
		}
		if(isCheck[idx]) {
			return;
		}
		
		if(!(idx - 1 >= 0 && arr.get(idx).get(6) == arr.get(idx-1).get(2))){
			if(idx-1 >=0) {
				isTurn[idx-1] = isTurn[idx] * -1;
			}
		}
		if(!(idx + 1 < 4 && arr.get(idx).get(2) == arr.get(idx+1).get(6))) {
			if(idx+1 < 4) {
				
				isTurn[idx+1 ] = isTurn[idx]* -1;
			}
		}
		
		isCheck[idx]= true;
		
		recur(idx-1);
		recur(idx+1);
		
	}

}
