package swtest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 기준점 (x, y)와 경계의 길이 d1, d2를 정한다. (d1, d2 >= 1, 1 <= x < x+d1+d2 <= N, 1 <= y-d1 < y < y+d2 <= N)
 * 다음 칸은 경계선이다.
 * (x, y), (x + 1, y - 1), ... , (x + d1, y - d1)
 * (x, y), (x + 1, y + 1), ... , (x + d2, y + d2)
 * (x + d1, y - d1), (x + d1 + 1, y - d1 + 1), ... , (x + d1 + d2, y - d1 + d2)
 * (x + d2, y + d2), (x + d2 + 1, y + d2 - 1), ... , (x + d2 + d1, y + d2 - d1)
 * 경계선과 경계선의 안에 포함되어 있는 곳은 5번 선거구이다.
 * 5번 선거구에 포함되지 않은 구역(r, c)의 선거구 번호는 다음 기준을 따른다.
 * 1번 선거구 : 1 <= r <= x + d1, 1 <= c <= y
 * 2번 선거구 : 1 <= r <= x + d2, y < c <= N
 * 3번 선거구 : x + d1 <= r <= N, 1 <= c < y-d1+d2
 * 4번 선거구 : x + d2 < r <= N, y-d1+d2 <= c <= N
 */



public class BOJ_게리맨더링2_17779 {
	
	static int N, totalSum, min;
	static boolean[][] checkFive;
	static int[][] A;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		A = new int[N+1][N+1];
		checkFive = new boolean[N+1][N+1];
		totalSum = 0; min = Integer.MAX_VALUE;
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
				totalSum += A[i][j]; // 총합
			}
		}
		
//		mapFive(3, 3, 1, 1);
//		for(int i = 1; i <= N; i++) {
//			for(int j = 1; j <= N; j++) {
//				System.out.print(checkFive[i][j]==true ? 5+" " : 0+ " ");
//			}
//			System.out.println();
//		}
//		System.exit(0);
		
		
		//(d1, d2 >= 1, 1 <= x < x+d1+d2 <= N, 1 <= y-d1 < y < y+d2 <= N)
		for(int x = 1; x <= N; x++) {
			for(int y = 1; y <= N; y++) {
				for(int d1 = 1; d1 <= N; d1++) {
					for(int d2 = 1; d2 <= N; d2++) {
						if( ((x+d1+d2) > N) || ((y-d1) < 1) || ( (y+d2) > N) ) continue;
						checkFive = new boolean[N+1][N+1];
						mapFive(x, y, d1, d2);
						min = Math.min(min, solve(x, y, d1, d2));
					}
				}
			}
		}
		
		System.out.println(min);     
	}


	private static void mapFive(int x, int y, int d1, int d2) {
		
//		// 1번 구역쪽 경계선
//		int i = x, j = y;
//		while(true) {
//			if(i == (x+d1) && j == (y-d1)) break;
//			checkFive[i][j] = true;
//			i += 1; j -= 1;
//		}
//		
//		//3번 구역쪽 경계선
//		i = x+d1; j = y-d1;
//		while(true) {
//			if(i == (x+d1+d2+1) && j == (y-d1+d2+1)) break;
//			checkFive[i][j] = true;
//			i += 1; j += 1;
//		}
//		
//		// 2번 구역쪽 경계선
//		i = x; j = y;
//		while(true) {
//			if(i == (x+d2) && j == (y+d2)) break;
//			checkFive[i][j] = true;
//			i += 1; j += 1;
//		}
//		
//		// 4번 구역쪽 경계선
//		i = x+d2; j = y+d2;
//		while(true) {
//			if(i == (x+d2+d1) && j == (y+d2-d1)) break;
//			checkFive[i][j] = true;
//			i += 1; j -= 1;
//		}
		
		
//		(x, y), (x + 1, y - 1), ... , (x + d1, y - d1)
//		(x + d2, y + d2), (x + d2 + 1, y + d2 - 1), ... , (x + d2 + d1, y + d2 - d1)
		checkFive[x][y] = true;
		for(int i = 1; i <= d1; i++) {
			checkFive[x + i][y - i] = true;
			checkFive[x + d2 + i][y + d2 - i] = true;
		}
		
//		(x, y), (x + 1, y + 1), ... , (x + d2, y + d2)
//		(x + d1, y - d1), (x + d1 + 1, y - d1 + 1), ... , (x + d1 + d2, y - d1 + d2)		
		for(int i = 1; i <= d2; i++) {
			checkFive[x + i][y + i] = true;
			checkFive[x + d1 + i][y - d1 + i] = true;
		}
		
	}


	private static int solve(int x, int y, int d1, int d2) {
		int one = 0, two = 0, three = 0, four = 0;
		
		// 1번 선거구
		for(int r = 1; r < x+d1; r++) {
			for(int c = 1; c <= y; c++) {
				if(checkFive[r][c] == true) break;
				one += A[r][c];
			}
		}
		// 2번 선거구
		for(int r = 1; r <= x + d2; r++) {
			for(int c = N; c > y; c--) {
				if(checkFive[r][c] == true) break;
				two += A[r][c];
			}
		}
		
		// 3번 선거구
		for(int r = x+d1; r <= N; r++) {
			for(int c = 1; c < y-d1+d2; c++) {
				if(checkFive[r][c] == true) break;
				three += A[r][c];
			}
		}
		
		// 4번 선거구
		for(int r = x + d2 + 1; r <= N; r++) {
			for(int c = N; c >= y-d1+d2; c--) {
				if(checkFive[r][c] == true) break;
				four += A[r][c];
			}
		}
		
		int five = totalSum - (one+two+three+four);
		
		int maxP = Math.max(one, Math.max(two, Math.max(three, Math.max(four, five))));
		int minP = Math.min(one, Math.min(two, Math.min(three, Math.min(four, five))));
		
		return maxP-minP;
	}

}
