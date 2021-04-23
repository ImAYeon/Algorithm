package swtest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/*
 * 1번 배열 index 2와 2번 배열 index 6과 짝
 * 2번 배열 index 2와 3번 배열 index 6과 짝
 * 3번 배열 index 2와 4번 배열 index 6과 짝
 * 회전방향 - 시계방향 : 1 , 반시계방향 : -1
 * 자성 - N극 : 0, S극 : 1
 */

public class SWEA_특이한자석_4013 {
	
	static int K, ans;
	static int[][] input;
	static int[][] magnet; // i = 0은 dum
	static boolean[][] check; // (1,2), (2,3), (3,4) 접촉해 있는 부분 자성 다른지 체크 (true : 자성다른거, false : 자성같은거 )
	static boolean[] visit; // 돌렸는지 체크
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			K = Integer.parseInt(br.readLine());
			magnet = new int[5][8];
			input = new int[K][2];
			check = new boolean[4][5]; // (1,2), (2,3), (3,4) 이렇게 쓸거임
			
			for(int i = 1; i <= 4; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j= 0; j < 8; j++) {
					magnet[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i = 0; i < K; i++) { // 입력을 미리 받아놔야 시간이 더 빠름 (배열에 담지않고 바로 처리하는 코드랑 시간 비교해보기)
				st = new StringTokenizer(br.readLine());
				input[i][0] = Integer.parseInt(st.nextToken());
				input[i][1] = Integer.parseInt(st.nextToken());
			}
			
			int num = 0, dir = 0;
			for(int i = 0; i < K; i++) {
				num = input[i][0]; // 회전시키려는 자석의 번호
				dir = input[i][1]; // 자석의 회전 방향 ( 시계방향 : 1, 반시계방향 : -1)
				
				visit =  new boolean[5];
				check();
				
				solve(num, dir);
			}
			
			ans = magnet[1][0] + magnet[2][0] * 2 + magnet[3][0] * 4 + magnet[4][0] * 8;
			
			System.out.println("#" + tc + " " + ans);
		}
	}


	private static void check() {
		for(int i = 1; i <= 3; i++) {
			if(magnet[i][2] != magnet[i+1][6]) check[i][i+1] = true;
			else check[i][i+1] = false;
		}
		
	}


	static void solve(int num, int dir) { // ex) num == 1인 경우 -> 2번 체크 ( check true이면 2번도 회전 -> 3번도 체크해서 회전 -> 4번도 체크해서 회전 )
		rotate(num, dir);
		visit[num] = true; // 돌렸는지 체크
		
		if(num - 1 >= 1 && check[num - 1][num] && !visit[num-1]) solve(num - 1, -dir);
		if(num + 1 <= 4 && check[num][num + 1] && !visit[num+1]) solve(num + 1, -dir);
	}
	
	static void rotate(int num, int dir) {
		if(dir == 1) { // 시계방향 ( 7 -> 0, 0 -> 1, 1 -> 2, 2 -> 3,,,)
			int temp = magnet[num][7];
			for(int i = 6; i >= 0; i--) {
				magnet[num][i+1] = magnet[num][i];
			}
			magnet[num][0] = temp;
		}else if(dir == -1) { // 반시계방향 ( 0 -> 7, 1 -> 0, 2 -> 1, 3 -> 2 ,,,)
			int temp = magnet[num][0];
			for(int i = 1; i < 8; i++) {
				magnet[num][i-1] = magnet[num][i];
			}
			magnet[num][7] = temp;
		}
	}
}
