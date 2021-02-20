package swea.swtest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 먼저 반으로 나누는 경우의 수 계산 (조합)
// 그리고 각자 그룹을 따로 계산
// 그룹의 차이를 min과 계산 

public class SWEA_요리사_4012 {
	
	static int min, N;
	static int[][] syn;
	static int[] ingredient, P;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			min = Integer.MAX_VALUE;
			N = Integer.parseInt(br.readLine());
			syn = new int[N+1][N+1]; // 식재료 인덱스 1부터 쓰기 위해서
			
			for(int i = 1; i <= N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 1; j <= N; j++) {
					syn[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			ingredient = new int[N]; //식재료 순서인 숫자 담김(N=4 -> 1, 2, 3, 4)
			for(int i = 0; i < N; i++) {
				ingredient[i] = i+1;
			}
			
			int cnt = 0;
			P = new int[N];
			while(++cnt <= (N/2)) P[N-cnt] = 1;
			
			int[] arr1 = new int[N/2];
			int[] arr2 = new int[N/2];
			
			do {
				int cnt1 = 0, cnt2 = 0;
				for(int i = 0; i < N; i++) { // 2개의 배열로 쪼개기
					if(P[i] == 1) {
						arr1[cnt1] = ingredient[i];
						cnt1++;
					}
					if(P[i] == 0) {
						arr2[cnt2] = ingredient[i];
						cnt2++;
					}
				}
				
				int s1 = synSum(arr1);
				int s2 = synSum(arr2);
				
				min = Math.min(min, Math.abs(s1-s2));
				
			}while(np(P));
			
			System.out.println("#" + t + " " + min);
		}

	}
	
	private static boolean np(int[] arr) { // N개를 2개로 쪼갬
		
		// STEP 1
		int i = N-1;
		
		while( i > 0 && arr[i-1] >= arr[i] ) --i;
		
		// 더이상 앞자리가 없는 상황 : 현 순열의 상태가 가장 큰순열(마지막 순열)
		if(i == 0) return false;
		
		// STEP 2
		int j = N - 1;
		while(arr[i-1] >= arr[j]) --j;
		
		// STEP 3
		swap(arr, i-1, j);
		
		// STEP 4
		int k = N-1;
		while(i < k) {
			swap(arr, i++, k--); // i, k 넘기고 그다음에 증감
		}
		
		return true;
		
	}
	
	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	
	
	static int synSum(int[] arr) {
		
		int sum = 0;
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr.length; j++) {
				sum += syn[arr[i]][arr[j]];
			}
		}
		
		return sum;
	}
	
	
}
