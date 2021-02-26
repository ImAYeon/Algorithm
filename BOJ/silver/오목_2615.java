package silverIII;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_오목_2615 {

	static int[][] map = new int[21][21]; // 1~19바둑판에 가장자리들 계산따로 안해주기 위해 크기 1~20으로 잡음
	static int[] dx = { 1, 0, 1, 1 }; // 우, 하, 우하, 우상
	static int[] dy = { 0, 1, 1, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 1; i < 20; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j < 20; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		br.close();

		for (int i = 1; i < 20; i++) {
			for (int j = 1; j < 20; j++) {
				int currVal = map[i][j];
				if(currVal == 0) continue; // 아무것도 놓이지 않음
				
				// 흰돌 또는 검은돌이 나왔을 때
				for(int k = 0; k < 4; k++) {
					int count = 1;
					int ny = dy[k];
					int nx = dx[k];
					
					// 진행하려는 방향과 반대방향으로 바로 앞에 이미 같은 색의 돌이 있다면 앞에서 체크된 상태
					if(currVal == map[i + dy[k] * - 1][j + dx[k] * -1]) {
						continue;
					}
					
					// 같은 값이 아닐때까지 check
					while(currVal == map[i+ny][j+nx]) {
						count++;
						ny = dy[k] * count;
						nx = dx[k] * count;
					}
					
					// count - 같은 값을 가진 수를 체크
					if( count == 5 ) {
						System.out.println(currVal);
						System.out.println(i + " " + j);
						System.exit(0);
					}
				}
				
			}
		}
		System.out.println(0);

	}

}
