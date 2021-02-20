package bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_분수찾기_1193 { // SWEA 1493. 수의 새로운 연산과 비슷

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int X = Integer.parseInt(br.readLine());
		
		int k = 1;
		boolean flag = false;
		int x = 0, y = 0;
		int num = 0;
		
		while(true) {
			// 출발위치
			if(flag) { 
				x = 0; y = k+1;
			}else {
				x = k+1; y = 0;
			}
			
			for(int i = 0; i < k; i++) { // 1번, 2번, 3번, ,,,,반복
				if(flag) {
					x++; y--;
				}else {
					x--; y++;
				}
				num++;
				if(num == X) {
					System.out.println(x + "/" + y);
					return;
				}
			}
			flag = !flag;
			k++;
			
		}
		
		
	}

}
