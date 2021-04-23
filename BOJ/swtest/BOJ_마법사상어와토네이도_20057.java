package swtest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_마법사상어와토네이도_20057 {
	
	static int N, totalSum, sandSum;
	static int sand, seven, ten, five, two, one; // left(), right(), up(), down()에서 쓰일 변수
	static int[][] map;
	static int[] dy = {0, 1, 0, -1}; // 왼쪽->아래->오른쪽->위
	static int[] dx = {-1, 0, 1, 0};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N+1][N+1];
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				totalSum += map[i][j];
			}
		}
		
		int x = N/2 + 1;
		int y = x;
		int k = 1;
		boolean isBreak = false;
		int dir = 0;
		while(true) {
			if(dir==4) dir = 0;
			for(int i = 0; i < k; i++) { // k = N 일때 첫번재 for문 돌다가 (1,1) 도달
				y += dy[dir];
				x += dx[dir];
				switch(dir) {
				case 0: left(y,x);
				case 1: down(y,x);
				case 2: right(y,x);
				case 3: up(y,x);
				}
				
				if(x == 1 && y == 1) { isBreak = true; break; }
			}

			if(isBreak) break;
			dir++;
			
			for(int i = 0; i < k; i++) {
				y += dy[dir];
				x += dx[dir];
				switch(dir) {
				case 0: left(y,x);
				case 1: down(y,x);
				case 2: right(y,x);
				case 3: up(y,x);
				}
			}
			
			dir++;
			k++;
		}
		
		System.out.println(sandSum);
	}
	
	
	static void left(int y, int x) { // 여기서 (y,x)는 y를 듯함
		sand = map[y][x];
		ten = (int)(0.1 * sand);
		seven = (int) (0.07 * sand);
		five = (int)(0.05 * sand);
		two = (int)(0.02 * sand);
		one = (int)(0.01 * sand);
		sand = sand - (2*seven + 2*ten + 2*two + 2*one + five);
		if(isIn(y-1,x, seven)) map[y-1][x] += seven;
		if(isIn(y+1,x, seven)) map[y+1][x] += seven;
		if(isIn(y-2,x, two)) map[y-2][x] += two; 	
		if(isIn(y+2,x, two)) map[y+2][x] += two;	
		if(isIn(y-1,x-1, ten)) map[y-1][x-1] += ten;
		if(isIn(y+1,x-1, ten)) map[y+1][x-1] += ten;
		if(isIn(y-1,x+1, one)) map[y-1][x+1] += one;
		if(isIn(y+1,x+1, one)) map[y+1][x+1] += one;
		if(isIn(y, x-2, five)) map[y][x-2] += five;	
		if(isIn(y,x-1, sand)) map[y][x-1] += sand;	
		map[y][x] = 0;                            
	}                                             
	
	static void down(int y, int x) {
		sand = map[y][x];
		ten = (int)(0.1 * sand);
		seven = (int) (0.07 * sand);
		five = (int)(0.05 * sand);
		two = (int)(0.02 * sand);
		one = (int)(0.01 * sand);
		sand = sand - (2*seven + 2*ten + 2*two + 2*one + five);
		if(isIn(y,x-1, seven)) map[y][x-1] += seven;
		if(isIn(y,x+1, seven)) map[y][x+1] += seven;
		if(isIn(y,x-2, two)) map[y][x-2] += two;    
		if(isIn(y,x+2, two)) map[y][x+2] += two;    
		if(isIn(y+1,x-1, ten)) map[y+1][x-1] += ten;
		if(isIn(y+1,x+1, ten)) map[y+1][x+1] += ten;
		if(isIn(y-1,x-1, one)) map[y-1][x-1] += one;
		if(isIn(y-1,x+1, one)) map[y-1][x+1] += one;
		if(isIn(y+2,x, five)) map[y+2][x] += five;  
		if(isIn(y+1,x, sand)) map[y+1][x] += sand;   
		map[y][x] = 0;

	}
	
	static void right(int y, int x) {
		sand = map[y][x];
		ten = (int)(0.1 * sand);
		seven = (int) (0.07 * sand);
		five = (int)(0.05 * sand);
		two = (int)(0.02 * sand);
		one = (int)(0.01 * sand);
		sand = sand - (2*seven + 2*ten + 2*two + 2*one + five);
		if(isIn(y-1,x, seven)) map[y-1][x] += seven; 
		if(isIn(y+1,x, seven)) map[y+1][x] += seven; 
		if(isIn(y-2,x, two)) map[y-2][x] += two;     
		if(isIn(y+2,x, two)) map[y+2][x] += two;     
		if(isIn(y-1,x+1, ten)) map[y-1][x+1] += ten; 
		if(isIn(y+1,x+1, ten)) map[y+1][x+1] += ten; 
		if(isIn(y-1,x-1, one)) map[y-1][x-1] += one; 
		if(isIn(y+1,x-1, one)) map[y+1][x-1] += one; 
		if(isIn(y,x+2, five)) map[y][x+2] += five;   
		if(isIn(y,x+1, sand)) map[y][x+1] += sand;   
		map[y][x] = 0;
	}
	
	static void up(int y, int x) {
		sand = map[y][x];
		ten = (int)(0.1 * sand);
		seven = (int) (0.07 * sand);
		five = (int)(0.05 * sand);
		two = (int)(0.02 * sand);
		one = (int)(0.01 * sand);
		sand = sand - (2*seven + 2*ten + 2*two + 2*one + five);
		if(isIn(y,x-1, seven)) map[y][x-1] += seven; 
		if(isIn(y,x+1, seven)) map[y][x+1] += seven; 
		if(isIn(y,x-2, two)) map[y][x-2] += two;     
		if(isIn(y,x+2, two)) map[y][x+2] += two;     
		if(isIn(y-1,x-1, ten)) map[y-1][x-1] += ten; 
		if(isIn(y-1,x+1, ten)) map[y-1][x+1] += ten; 
		if(isIn(y+1,x-1, one)) map[y+1][x-1] += one; 
		if(isIn(y+1,x+1, one)) map[y+1][x+1] += one; 
		if(isIn(y-2,x, five)) map[y-2][x] += five;   
		if(isIn(y-1,x, sand)) map[y-1][x] += sand;   
		map[y][x] = 0;
	}

	static boolean isIn(int y, int x, int n) {
		if(y < 1 || x < 1 || y > N || x > N) {
			sandSum += n;
			return false;
		}
		return true;
	}
}
