package swtest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_마법사상어와파이어볼_20056 {

	static int N, M, K;
	static int[][] map;
	static int[] dy = { -1, -1, 0, 1, 1, 1, 0, -1 }; // 7방향
	static int[] dx = { 0, 1, 1, 1, 0, -1, -1, -1 };
	static LinkedList<Fire>[][] state;
	static LinkedList<Fire>[][] temp_state;

	static class Fire {
		int r; // 위치 (행) 1 ≤ ri, ci ≤ N
		int c; // 위치 (열)
		int m; // 질량 1 ≤ mi ≤ 1,000
		int s; // 속력 1 ≤ si ≤ 1,000
		int d; // 방향 0 ≤ di ≤ 7

		public Fire(int r, int c, int m, int s, int d) {
			super();
			this.r = r;
			this.c = c;
			this.m = m;
			this.s = s;
			this.d = d;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 격자크기 4 ≤ N ≤ 50
		M = Integer.parseInt(st.nextToken()); // 파이어볼 갯수 0 ≤ M ≤ N2
		K = Integer.parseInt(st.nextToken()); // 이동 명령 횟수 1 ≤ K ≤ 1,000

		state = new LinkedList[N + 1][N + 1];
		temp_state = new LinkedList[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				state[i][j] = new LinkedList<Fire>();
				temp_state[i][j] = new LinkedList<Fire>();
			}
		}

		
		int r, c, m, s, d;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			s = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			Fire fire = new Fire(r, c, m, s, d);
			state[r][c].offer(fire);
		}

		while (K-- > 0) {
			// 모든 파이어볼이 이동
			move();

			// 2개 이상의 파이어볼이 있는 칸 수행
			solve();
		}

		// 남아 있는 파이어볼 질량 합 구하기
		int sum = 0;
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				for(int k = 0; k < state[i][j].size(); k++) {
					sum += state[i][j].get(k).m;
				}
			}
		}

		System.out.println(sum);
	}

	/*
	 * 9 -> 5 -> 1 10 -> 6 -> 2 11 -> 7 -> 3 3+ 6 % 4 12 -> 8 -> 4
	 * 
	 */

	static void move() {
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				int size = state[i][j].size();
				//System.out.println("state["+i+"]["+j+"].size : " + state[i][j].size());
				for(int k = 0; k < size; k++) {
					Fire fire = state[i][j].poll();

					//System.out.print("fire.r : " + fire.r + ", fire.c : "  + fire.c + ", M : " + fire.m + ", S : " + fire.s + ", d : " + fire.d);
					
					fire.r = ( fire.r + (dy[fire.d] * (fire.s % N)) + N ) % N;
					fire.c = ( fire.c + (dx[fire.d] * (fire.s % N)) + N ) % N;
					
					//System.out.println(" , nr : " + fire.r + ", nc : " + fire.c);
					
					if(fire.r == 0) fire.r = N;
					if(fire.c == 0) fire.c = N;
					
					temp_state[fire.r][fire.c].offer(fire);

					//System.out.println("temp_state["+fire.r+"]["+fire.c+"].size : " + temp_state[fire.r][fire.c].size());
				}
			}
		}

	}

	static void solve() {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				int size = temp_state[i][j].size();
				if(size == 0) continue;
				else if(size == 1) {
					Fire fire = temp_state[i][j].poll();
					state[i][j].offer(fire);
				}
				else if(size >= 2) {
					//System.out.println("===================i:"+i + ", j:" +j + "'s size : " + size);
					Fire temp = temp_state[i][j].poll();
					int totalM = temp.m, totalS = temp.s;
					int preD = (temp.d) % 2 == 0 ? 2 : 1; // 맨 첫번째꺼로 초기화
					int currD = preD;
					boolean totalD = true; // (홀수 짝수 하나라도 틀리면 false로)
					
					for(int k = 1; k < size; k++) {
						temp = temp_state[i][j].poll();
						totalM += temp.m;
						totalS += temp.s;
						currD = temp.d % 2 == 0 ? 2 : 1; // 짝수면 2, 홀수면 1
						if(preD != currD) totalD = false;
						preD = currD;
					}
				
					totalM /= 5;	// 질량 => 모든 파이어볼 질량 합 / 5 (소수점 버림)
					if(totalM == 0) {
						continue; // 질량이 0인 파이어볼은 소멸되어 없어진다.
					}
					totalS /= size; // 속력 => 합쳐진 파이어볼 속력의 합 / 합쳐진 파이어볼의 개수
					int start = totalD == true ? 0 : 1; // 방향 => 모두 홀수거나 짝수이면 0, 2, 4, 6 / 그렇지 않으면 1, 3, 5, 7
					for(int k = start; k <= start+6; k += 2) {
						temp = new Fire(i, j, totalM, totalS, k);
						//System.out.println("i : " + i + ", j : "  + j + ", totalM : " + totalM + ", totalS : " + totalS + ", k : " + k);
						state[i][j].offer(temp);
					}
				}
			}
		}

	}

}
