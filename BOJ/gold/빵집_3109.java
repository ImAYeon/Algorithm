package boj.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 골드 II
public class BOJ_빵집_3109 {
	
	static int R, C, ans;
	static boolean[][] isAvailable;
	static int flag;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s[] = br.readLine().split(" ");
		R = Integer.parseInt(s[0]);
		C = Integer.parseInt(s[1]);

		isAvailable = new boolean[R][C];
		ans = 0;
		
		StringTokenizer st;
		for(int i = 0; i < R; i++) {
			String ss = br.readLine();
			for(int j = 0; j < C; j++) { 	
				if(ss.charAt(j) == 'x') {
					isAvailable[i][j] = false;
				}else {
					isAvailable[i][j] = true;
				}
			}
		}
		
		for(int i = 0; i < R; i++) {
			flag = 0;
			setPipe(i, 0);
		}
		System.out.println(ans);
	}
	
	public static void setPipe(int rowNo, int colNo) {

		if(!isAvailable[rowNo][colNo]) {
			return;
		}
		
		if(colNo == C-1) {
			if(isAvailable[rowNo][colNo]) {
				ans++;
				flag = 1;
			}
			return;
		}


		isAvailable[rowNo][colNo] = false;
		
		if(rowNo-1 >= 0 && flag == 0) {
			setPipe(rowNo-1, colNo+1);
		}
		if(flag == 0)setPipe(rowNo, colNo+1);
		if(rowNo + 1 < R && flag == 0) {
			setPipe(rowNo+1, colNo+1);
		}
		
	}
	
	

}
