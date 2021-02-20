package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_3대측정_20299 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken()); 
		int M = Integer.parseInt(st.nextToken()); 

		int cnt = 0; 
		
		int[] x1 = new int[N];
		int[] x2 = new int[N];
		int[] x3 = new int[N];
		
		
		boolean[] check = new boolean[N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			x1[i] = Integer.parseInt(st.nextToken());
			x2[i] = Integer.parseInt(st.nextToken());
			x3[i] = Integer.parseInt(st.nextToken());
			
		}
		for(int i = 0; i < N; i++) {
			if(x1[i] + x2[i] + x3[i] >= S && x1[i] >= M && x2[i] >= M && x3[i] >= M) { 
				cnt++; 
				check[i] = true;
			}
		}

		System.out.println(cnt);
		
		for(int i = 0; i < N; i++) {
			if(check[i]) {
				System.out.print(x1[i] + " " + x2[i] + " " + x3[i] + " ");
			}
				
		}
		
	}


}
