package goldII;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_색종이붙이기_17136 {
	
	static int min = Integer.MAX_VALUE;
	static int[][] map = new int[10][10];
	static int[] paper = {0, 5, 5, 5, 5, 5}; // 색종이
	
	public static void main(String[] args) throws Exception{	
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		for(int i = 0; i < 10; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 10; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0,0, 0);
		
		if(min == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(min);
		
	}
	
	static void dfs(int y, int x, int pCnt) { // pCnt : 붙인 색종이 갯수

		if(pCnt >= min) return;
		
		if(y == 10 && x == 0) { // 모든 map을 다 돌아본것 -> (9,9)인경우 dfs(10, 0)으로 보내지기 때문에
			min = pCnt;
			return;
		}
		
		
		if( x == 10 ) {
			dfs(y + 1, 0, pCnt);
			return;
		}
		
		if(map[y][x] == 1) {
			for(int k = 5; k >= 1; k--) { // 큰 수 5장부터 작은 수 1장까지 차례로 붙여본다
				if(paper[k] > 0 && isAttach(y, x, k)) { // isAttach : 붙일 수 있는 지 확인 (0이 적힌 칸에는 색종이 출력 못함) 또한 ** 중요한건 색종이가 5개씩 밖에 없다는거!!
					attach(y, x, k, 0); // 색종이 붙힘
					paper[k]--;
					dfs(y, x+1, pCnt+1);
					attach(y, x, k, 1); // 색종이 다시 뗌
					paper[k]++;
				}
			}
		}else { // 오른쪽으로 이동
			dfs(y, x + 1, pCnt);
		}
		
	}
	
	static void attach(int sy, int sx, int k, int s) {
		
		for(int i = sy; i < sy + k; i++) {
			for(int j = sx; j < sx + k; j++) {
				map[i][j] = s;
			}
		}
		
	}
	
	static boolean isAttach(int sy, int sx, int k) {
		
		
		for(int i = sy; i < sy + k; i++) {
			for(int j = sx; j < sx + k; j++) {
				
				if(i < 0 || j < 0 || i >= 10 || j >= 10 || map[i][j] == 0) return false;
				
			}
		}
		
		return true;
		
	}
	
}
