package supplement.day05;

import java.util.Scanner;

public class SWEA_수의새로운연산풀기_1493_Sol {
	static int[] getCoor(int target) {
		int cnt = 1;
		for(int i = 1; ;i++) { // 무한반복
			for(int x = 1, y = i; x <= i; x++,y--) {
				if(cnt == target) {
					return new int[] {x,y};
				}
				cnt++;
			}
		}
	}
	
	static int getValue(int nx, int ny) {
		int cnt = 1;
		for(int i = 1; ;i++) { // 무한반복
			for(int x = 1, y = i; x <= i; x++,y--) {
				if(x == nx && y == ny) {
					return cnt;
				}
				cnt++;
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			int ans = 0;
			int[] p = getCoor(sc.nextInt());
			int[] q = getCoor(sc.nextInt());
			int x = p[0] + q[0];
			int y = p[1] + q[1];
			
			ans = getValue(x, y);
			
			System.out.println("#" + t + " " + ans);
		}
	}
}
