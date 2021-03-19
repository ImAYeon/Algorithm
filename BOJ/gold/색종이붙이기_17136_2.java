package goldII;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_색종이붙이기_17136_2 {
	
	static int min = Integer.MAX_VALUE, totalCnt;
	static int[][] map;
	static int[] paper = {0, 5, 5, 5, 5, 5}; // 색종이
	
	public static void main(String[] args) throws Exception{	
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		map = new int[10][10];
		
		for(int i = 0; i < 10; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 10; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) totalCnt++;
			}
		}
		
		
		dfs(0,0,0,0);
		
		if(min == Integer.MAX_VALUE) min = -1;
		System.out.println(min);
		
	}
	
	static void dfs(int y, int x, int oneCnt, int pCnt) { // pCnt : 붙인 색종이 갯수, oneCnt : map에서 1의 갯수
		if(pCnt >= min) return;
		
		if(oneCnt == totalCnt) { // 모든 map을 다 돌아볼 필요없이 마지막 1까지만 탐색
			min = pCnt;
			return;
		}
		
		
		if( x == 10 ) {
			dfs(y + 1, 0, oneCnt, pCnt);
			return;
		}
		
		if(map[y][x] == 1) {
			for(int k = 5; k >= 1; k--) { // 큰 수 5장부터 작은 수 1장까지 차례로 붙여본다
				if(paper[k] > 0 && y + k <= 10 && x + k <= 10) { //y + k <=10인 이유는 그 안에서 i < y + k 이기 때무네 y + k가 10이 되야 9까지 탐색할 수 있음 (x도 마찬가지)
					boolean check = true;
					for(int i = y; i < y + k; i++) {
						for(int j = x; j < x + k; j++) {
							if(map[i][j] == 0) {
								check = false;
								break;
							}
						}
						if(!check) break;
					}
					
					if(check) {
						paper[k]--;
						for(int i = y; i < y + k; i++) {
							for(int j = x; j < x + k; j++) {
								map[i][j] = 0;
							}
						}
						dfs(y, x+1, oneCnt+(k*k), pCnt+1);
						
						paper[k]++;
						for(int i = y; i < y + k; i++) {
							for(int j = x; j < x + k; j++) {
								map[i][j] = 1;
							}
						}
					}
				}
			}
		}else { // 오른쪽으로 이동
			dfs(y, x + 1, oneCnt, pCnt);
		}
		
	}
	
	
}
