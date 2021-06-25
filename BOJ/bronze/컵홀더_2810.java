package bronze;

import java.util.*;
import java.io.*;

public class BOJ_컵홀더_2810 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		char[] cArr = new char[N];
		
		cArr = br.readLine().toCharArray();
		
		int cntS = 0, cntL = 0;
		
		for(char c : cArr) {
			if(c == 'S') cntS++;
			else if(c == 'L') cntL++;
		}
		
		cntL /= 2; // 커플 수 (커플은 한묶음으로 생각)
		
		
		// 자신의 왼쪽 컵홀더에 놓는다고 생각한다
		// 처음 만난 커플 한명은 왼쪽 한명은 오른쪽에 놓는다고 생각
		// 그 뒤로는 자신의 오른쪽 컵홀더에 놓는다고 생각
		// 따라서 여러 커플중 한커플은 두명 모두 컵홀더를 가질수 있기 때문에 1을 더해주는 것
		int ans = 0;
		if(cntL == 0) ans = cntS;
		else {
			ans = cntS + cntL + 1;
		}
		System.out.println(ans);
	}

}
