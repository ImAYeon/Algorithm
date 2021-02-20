package swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 도착 지점을 시작점으로 역순으로 거슬로 올라간다.
// delta 를 활용하여 방향을 이동하되, delta 는 순서가 필요함
// - 위로 이동하는 경우 : 좌,우가 우선 없으면 위로 계속
// - 좌, 우로 이동하는 경우 : 위가 우선, 위로 갈 수 없으면 진행 방향으로 계속 감
// 테케별로 동일한 크기의 배열 ladder 초기화 - 배열 재생성? 반복문으로 초기화?
// - 수행시간에 차이가 없다면 초기화로!!
// - Arrays.fill() : 1차원 배열 
public class SWEA_1210_Ladder1 {
	//왼-오-위
	static int[] dx = { -1,  1,  0};
	static int[] dy = {  0,  0, -1};
	
	static int[][] ladder = new int[100][100];
	
	// 시작 좌표
	static int sx;
	static int sy;
	
	// 정답
	static int ans = 0;
	
	public static void main(String[] args) throws Exception{
		
		System.setIn(new FileInputStream("SW_1210_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long start = System.nanoTime();
		for ( int t = 1; t <= 10; t++ ) {
			
			// 초기화 1 : 새로 배열 객체 생성
			//ladder = new int[100][100];
					
			// 초기화 2 : 기존 객체의 값 초기화 (Array.fill -> 1차원배열에만 적용가능)
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					ladder[i][j] = 0;
				}
			}
			
			br.readLine();
			
			for (int i = 0; i < 100; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					
					ladder[i][j] = Integer.parseInt(st.nextToken());
					
					// 시작좌표 확보
					if(ladder[i][j] == 2 ) {
						sy = i;
						sx = j;
					}
				}
			}

			//탐색 시작
			
			int dir = 2; // 위 방향으로 시작
			
			while(true) {

				// 위로 갈 경우 왼쪽 오른쪽을 먼저 고려 없으면 계속 위로
				if( dir == 2 ) {
					
					// 왼 - 오 - 위 순으로 탐색
					for( int d=0; d<dx.length; d++ ) {
						
						int nx = sx + dx[d];
						int ny = sy + dy[d];
						
						// 범위 안에서  1 이면 새 좌표로 이동하고 바로 나옴.
						if( ny >= 0 && ny < 100 && nx >= 0 && nx < 100 && ladder[ny][nx] == 1 ) {
							
							sy = ny;
							sx = nx;							
							dir = d;
							break;
						}
					}
					
				// 왼쪽 또는 오른쪽으로 이동 중에는 위로 가는 것을 먼저 고려~
				}else if ( dir == 0 || dir == 1 ) {
					
					// 위로 가는 좌표
					int nx = sx + dx[2];
					int ny = sy + dy[2];
					
					// 범위 안에서  1 이면 새 좌표로 이동하고 바로 나옴.
					if( ny >= 0 && ny < 100 && nx >= 0 && nx < 100 && ladder[ny][nx] == 1 ) {
						sy = ny; 
						sx = nx;
						dir = 2;
					}else {
						sy = sy + dy[dir];
						sx = sx + dx[dir];
					}
				}

				// y가 첫 줄까지 왔으면, x가 답 
				if( sy == 0 ) {
					ans = sx;
					break;
				}
			}
			
			System.out.println("#" + t + " "+ ans);
			
		}
		long end = System.nanoTime();
        System.out.println("duration : " + (end-start));
	}
}
