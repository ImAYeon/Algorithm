package 도형만들기2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class JUNGOL_달팽이삼각형_1337 {

	static int[] dy = {1, 0, -1};
	static int[] dx = {1, -1, 0}; 
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[N+2][N+2];
		
		
		
		for(int i = 0; i < N+2; i++) {
			for(int j = 0; j < N+2; j++) {
				if(i == 0 || j == 0 || i == N+1 || j == N+1 || i < j) arr[i][j] = 0;
				else arr[i][j] = -1;
			}
		}
		
		int dir = 0, ny, nx;
		int cy = 1, cx =1, num = 0;
		while(true) {
			arr[cy][cx] = num;

			ny = cy + dy[dir];
			nx = cx + dx[dir];
			
			if(arr[ny][nx] != -1) {
				dir = (dir + 1) % 3;
				if(arr[ cy+dy[dir] ][ cx+dx[dir] ] != -1) // cy,cx가 아닌 ny,nx 쓰는거 조심
					break; // 방향을 바꾼후에도 이미 채워져있으면 break;
			}
			
			cy += dy[dir];
			cx += dx[dir];
			num = (num + 1) % 10;
		}
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= i; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

}
