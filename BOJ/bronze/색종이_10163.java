package bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 브론즈 I //IM시험대비

/*
 * 생각정리
 * 맨마지막색종이부터 차례대로 검색
 * 맨마지막 색종이는 무조건 다 보이기 때문에 너비 x 높이
 * 이미 색종이가 놓인 부분은 true로 표시
 * 그다음 색종이부터 너비 x 높이 - true로 표시되어 있는 부분
 */
public class BOJ_색종이_10163 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		boolean[][] check = new boolean[101][101];
		Paper[] p = new Paper[N];
		int[] ans = new int[N];
		
		for(int i = 0; i < N; i++) {
			String[] s = br.readLine().split(" ");
			p[i] = new Paper(Integer.parseInt(s[0]),Integer.parseInt(s[1]),Integer.parseInt(s[2]),Integer.parseInt(s[3]));
		}
		
		for(int k = N-1; k >= 0; k--) {
			int area = p[k].r * p[k].h;
			for(int i = p[k].y; i < p[k].y + p[k].h; i++) {
				for(int j = p[k].x; j <p[k].x + p[k].r; j++) {
					if(check[i][j]) area--;
					else check[i][j] = true;
				}
			}
			ans[k] = area;
		}
		
		for(int i = 0; i < N; i++) {
			System.out.println(ans[i]);
		}
		
	}
	
	static class Paper{
		int x;
		int y;
		int r;
		int h;
		Paper(int x, int y, int r, int h){
			this.x = x;
			this.y = y;
			this.r = r;
			this.h= h;
		}
	}
}
