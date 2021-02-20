package boj.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 골드 IV

/*
 * 생각 정리
 * 일단 map은 [N+1][M] 배열로 (성도 표시해야함) 
 * 궁수의 위치는 M(행)개중에 3개를 뽑는 조합을 구해야 한다 -> 궁수의 위치는 알아야함([N+1][i] 형태)
 * 궁수와 가장 가까운 위치의 적을 구할 때는 while문으로 배열을 
 * 맨왼쪽아래([N-1][0]~[N-1][M-1]~[N-1][1] ~ [0][M-1])부터 차례대로 검사하고
 * 
 * 
 */

// 코드가 너무 더럽다...............
public class BOJ_캐슬디펜스_17135 {

	static int N, M, D, cnt, C; // C : 적이 내려온 횟수
	static int[][] map;
	static int[] P;
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String[] s = br.readLine().split(" ");
		int ans = Integer.MIN_VALUE;
		
		N = Integer.parseInt(s[0]); // 행의 수
		M = Integer.parseInt(s[1]); // 열의 수
		D = Integer.parseInt(s[2]); // 궁수의 공격 거리 제한
		
		map = new int[N][M];
		
		P = new int[M]; // M = 5라면 P index는 0 ~ 4 까지
		
		int c = 0;
		while(++c <= 3) P[M-c] = 2;
		
		for(int i = 0; i < N; i++) { // 마지막 행의 궁수위치는 np에서 값 줄거기 때문에 N-1까지만
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 궁수 배치 할 수 있는 모든 조합 반복
		while(true) { 

			int[][] temp = new int[N+1][M];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					temp[i][j] = map[i][j];
				}
			}
			
			int[] index = new int[3]; //궁수가 있는 자리 
			for(int i = 0, k = 0; i < M; i++){
				if(P[i] == 2) {
					temp[N][i] = 2;
					index[k] = i;
					k++;
				}else {
					temp[N][i] = 0;
				}
			}
			
			
			
			cnt = 0;
			C = 0;
			while(C < N) {

				
				// 궁수 공격
				int[] row = new int[3]; // 궁수들마다 공격한 적의 위치 기억 -> 나중에 0으로 바꿔줌
				int[] col = new int[3];
				int[] flag = new int[3];
				for(int i = 0 ; i < 3; i++) { // 궁수 3명 공격
					int[] min = new int[3];
					min[0] = Integer.MAX_VALUE;
					min[1] = Integer.MAX_VALUE;
					min[2] = Integer.MAX_VALUE;
					for(int m = 0; m < M; m++) { // 여기가 계속 잘못되었던게  1행-> 2행 ---> 5행 순으로 열마다 검사를 하니까 맨 왼쪽에 있는 적을 죽이지 않게 됨
						// 열단위로 1열 (1행~5행)--> 2열 (1행~5행)--> 이렇게 봐야지 맨 왼쪽부터 죽임
						for(int n = N-1; n >= C; n--) {
							if(temp[n][m] == 0) continue;
							// 0이아니면 적이 있는 곳이기 때문에 궁수와 적 거리계산
							int d = Math.abs(N - n) + Math.abs(index[i] - m);
							
							if(min[i] > d && d <= D) {
								flag[i] = 1;
								min[i] = d;
								row[i] = n; // 거리가 최소인 적 자리의 행 기억
								col[i] = m; // 거리가 최소인 적 자리의 열 기억
							}
						}
					}
				}
				
				// 궁수에게 맞은 적 0으로 바꿔줌
				for(int k = 0; k <3; k++) {
					for(int i = 0; i < N; i++) {
						for(int j = 0; j < M; j++) {
							if(i == row[k] && j == col[k] && temp[i][j] == 1 && flag[k] == 1) {
								temp[i][j] = 0;
								cnt++; // 공격한 적 카운트
							}
						}
					}
				}
				
				// 적 한칸씩 내려옴
				C++;
				for(int i = N-1; i >= C; i--) {
					for(int j = 0; j < M; j++) {
						temp[i][j] = temp[i-1][j];
					}
				}
				for(int j = 0; j < M; j++) {
					temp[C-1][j] = 0;
				}
				
			}

			//cnt가 젤 큰거 찾기 ( 제거한 적의 최대 수 )
			ans = Math.max(ans, cnt);
			
			if(!np()) break;
		}
		
		System.out.println(ans);
		
		
	}



	private static boolean np() {

		int i = P.length - 1;
		while( i>0 && P[i-1]>=P[i] ) --i;
		
		if( i == 0 ) return false;
		
		int j = P.length - 1;
		while(P[i-1]>=P[j])	--j;
		swap(P,i-1,j);
		
		// reverse
		int k = P.length - 1;
		while(i<k) {
			swap(P,i++,k--);			
		}
		return true;
	}
	
	
	private static void swap(int numbers[],int i,int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}
}
