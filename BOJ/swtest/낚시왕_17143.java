package swtest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_낚시왕_17143 {
	
	static int R, C, M, ans;
	static ArrayList<Shark>[][] sharkState;
	static int[] dy = {-1, 1, 0, 0}; // 위, 아래, 오른쪽, 왼쪽 (index 0은 dummy)
	static int[] dx = {0, 0, 1, -1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		ans = 0;
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		sharkState = new ArrayList[R+1][C+1];
		
		for(int i = 1; i <= R; i++) {
			for(int j = 1; j <= C; j++) {
				sharkState[i][j] = new ArrayList<Shark>();
			}
		}
		
		int r, c, s, d, z;
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			s = Integer.parseInt(st.nextToken()); // 속력
			d = Integer.parseInt(st.nextToken()); // 이동 방향
			z = Integer.parseInt(st.nextToken()); // 크기
			sharkState[r][c].add(new Shark(r,c,s,d-1,z));
		}
		
		// 1. 낚시왕이 오른쪽으로 한 칸 이동
		for(int loc = 1; loc <= C; loc++) {
			// 2. 낚시왕이 있는 열에 있는 상어 중 땅과 제일 가까운 상어를 잡음. 상어를 잡으면 격자판에서 상어는 사라짐
			for(int k = 1; k <= R; k++) {
				if(sharkState[k][loc].size() > 0) {
					ans += sharkState[k][loc].get(0).z;
					sharkState[k][loc].remove(0);
					break;
				}
			}
			
			// 3. 상어 이동
			goShark();
			
			// 4. 같은 칸 상어 크기가 가장 큰 상어가 나머지 상어 잡아먹음
			removeShark();
		}
		
		System.out.println(ans );
		
		
	}
	
	private static void removeShark() {
		for(int i = 1; i <= R; i++) {
			for(int j = 1; j <= C; j++) {
				while(sharkState[i][j].size() >= 2) {
					if(sharkState[i][j].get(0).z > sharkState[i][j].get(1).z) sharkState[i][j].remove(1);
					else sharkState[i][j].remove(0);
				}
			}
		}
		
	}

	private static void goShark() {
		ArrayList<Shark> temp = new ArrayList<Shark>();
		for(int i= 1; i <= R; i++) {
			for(int j = 1; j <= C; j++) {
				if(sharkState[i][j].isEmpty()) continue;
				Shark shark = sharkState[i][j].get(0);
				sharkState[i][j].remove(0);
				
				int r = shark.r;
				int c = shark.c;
				int s = shark.s;
				int d = shark.d;
				
				switch(shark.d){
				case 0: // 위
				case 1: // 아래
					s = s % ( R*2 - 2);
					for(int k = 0; k < s; k++) {
						if( r == 1 ) d = 1;
						else if ( r == R ) d = 0;
						r += dy[d];
					}
					shark.r = r;
					shark.d = d;
					break;
				case 2: // 우 
				case 3: // 좌
					s = s % ( C*2 - 2);
					for(int k = 0; k < s; k++) {
						if( c == 1 ) d = 2;
						else if( c == C ) d = 3;
						c += dx[d];
					}
					shark.c = c;
					shark.d = d;
					break;
				}
				
				temp.add(shark); 
			}
		}
		
		for(Shark shark : temp) {
			sharkState[shark.r][shark.c].add(shark);
		}
		
	}

	static class Shark{
		int r; // 행 위치
		int c; // 열 위치
		int s; // 속력
		int d; // 이동 방향
		int z; // 크기
		
		public Shark(int r, int c, int s, int d, int z) {
			super();
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}
	}

}
