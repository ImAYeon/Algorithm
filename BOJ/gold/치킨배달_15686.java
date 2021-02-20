package boj.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 생각 정리
 * 치킨집을 먼저 M개 고르는 조합을 푼다
 * M개를 고를 때 치킨집의 행과 열을 저장하는 배열 필요
 * 그리고 나서 map을 탐색하면서 집일때 그 M개의 치킨집을 담은 배열과의 거리 계산을 한다.
 * cnt1Cm -> 치킨집갯수중에 m고르기
 */

// 코드 개더럽다,,,,,,, 버리자,,,,,,
public class BOJ_치킨배달_15686 {
	
	static int N,M;
	static int cnt1,cnt2; //cnt1은 치킨집 갯수, cnt2는 집 갯수
	static int[] P;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]); // 치킨집 최대 갯수
		
		int[][] map = new int[N+1][N+1];
		
		StringTokenizer st;
		
		cnt1 = 0; cnt2= 0;
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) cnt1++; // 치킨집 갯수 알기위해
				if(map[i][j] == 1) cnt2++; // 집 갯수 알기위해
			}
		}

		int[][] chicken = new int[cnt1][2]; //치킨집의 행과열 저장할 배열
		int[][] house = new int[cnt2][2]; //집의 행과열 저장할 배열
		
		// 치킨집 위치 담기
		int n = 0, m =0;
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				if(map[i][j] == 2) {
					chicken[n][0] = i; // 행을 담음
					chicken[n][1] = j; // 열을 담음
					n++;
				}else if(map[i][j] == 1) {
					house[m][0] = i; // 행
					house[m][1] = j; // 열
					m++;
				}
			}
		}
		
		P = new int[cnt1]; // cnt1 크기의 flag 배열
		
		int t = 0;
		while(++t <= M) P[cnt1-t] = 1;
		

		int minAll = Integer.MAX_VALUE; // 도시의 치킨 거리의 최솟값
		while(true) {
			int[] c = new int[M];
			for(int i = 0, num = 0; i < cnt1; i++) {
				if(P[i] == 1) { // 골라진 치킨집
					c[num++] = i;
				}
			}
			
			// 전체 치킨 거리의 합 구하기
			int sumAll = 0;
			for(int i = 0 ; i < house.length; i++) { // 집마다 돌기
				int min = Integer.MAX_VALUE;
				int d = 0;
				for(int j = 0; j < c.length; j++) { //치킨 거리가 더 가까운걸로 
					int ci = chicken[c[j]][0]; //치킨집의 행가져오기
					int cj = chicken[c[j]][1]; //치킨집의 열가져오기
					
					d = Math.abs(house[i][0] - ci) + Math.abs(house[i][1] - cj); //집과 치킨사이 거리 구하기
					
					min = Math.min(min, d); // 집과 가장 가까운 거리 구하기
				}
				sumAll += min; // 집의 치킨거리를 구했으면 도시의 치킨 거리 sum에 더해줌
			}
			
			// 전체 도시의 치킨 거리 중 최솟값 찾기
			minAll = Math.min(minAll, sumAll);
			
			
			if(!np(P)) break;
		}
		
		System.out.println(minAll);
	}
	
	private static boolean np(int[] arr) {
		
		// STEP 1
		int i = cnt1-1;
		
		while( i > 0 && arr[i-1] >= arr[i] ) --i;
		
		// 더이상 앞자리가 없는 상황 : 현 순열의 상태가 가장 큰순열(마지막 순열)
		if(i == 0) return false;
		
		// STEP 2
		int j = cnt1 - 1;
		while(arr[i-1] >= arr[j]) --j;
		
		// STEP 3
		swap(arr, i-1, j);
		
		// STEP 4
		int k = cnt1 -1;
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

}
