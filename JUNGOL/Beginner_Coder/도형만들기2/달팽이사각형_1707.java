package 도형만들기2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class JUNGOL_달팽이사각형_1707 {
	
	static int[] dy = {0, 1, 0, -1};
	static int[] dx = {1, 0, -1, 0};
	
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		int n= sc.nextInt();
		
		int[][] arr = new int[n+2][n+2];
		for(int k = 0; k < n+2; k++) arr[0][k] = arr[n+1][k] = arr[k][0] = arr[k][n+1] = 1;
		
		int dir = 0, num = 1;
		int cy = 1, cx = 1, ny = 0, nx = 0;
		while(num <= n*n) {
			arr[cy][cx] = num++;
			
			ny = cy + dy[dir];
			nx = cx + dx[dir];
			
			if(arr[ny][nx] != 0) dir = (dir + 1) % 4;
			
			cy += dy[dir];
			cx += dx[dir];
		}
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		
	}

}
