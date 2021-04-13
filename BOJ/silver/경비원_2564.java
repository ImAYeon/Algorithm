package silverI;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_경비원_2564 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int C = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		int N = Integer.parseInt(br.readLine());
		 
		int[][] store = new int[N][2];
		 
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			store[i][0] = Integer.parseInt(st.nextToken());
			store[i][1] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int dir = Integer.parseInt(st.nextToken());
		int loc = Integer.parseInt(st.nextToken());
		
		int ans = 0;
		for(int i = 0; i < N; i++) {
			int tdir = store[i][0];
			int tloc = store[i][1];
			
			switch(dir) {
			case 1:
				switch(tdir) {
				case 1:
					ans += Math.abs(loc - tloc);
					break;
				case 2:
					if((C - loc) >= tloc) {
						ans += R + loc + tloc;
					}else { // (C - loc) <= tloc
						ans += R + (C - loc) + (C - tloc);
					}
					break;
				case 3:
					ans += loc + tloc;
					break;
				case 4:
					ans += (C - loc) + tloc;
					break;
				}
				break;
			case 2:
				switch(tdir) {
				case 1:
					if((C - loc) >= tloc) {
						ans += R + loc + tloc;
					}else { // (C - loc) <= tloc
						ans += R + (C - loc) + (C - tloc);
					}
					break;
				case 2:
					ans += Math.abs(loc - tloc);
					break;
				case 3:
					ans += loc + (R-tloc);
					break;
				case 4:
					ans += (C-loc) + (R-tloc);
					break;
				}
				break;
			case 3:
				switch(tdir) {
				case 1:
					ans += loc + tloc;
					break;
				case 2:
					ans += (R-loc) + tloc;
					break;
				case 3:
					ans += Math.abs(loc - tloc);
					break;
				case 4:
					if((R - loc) >= tloc) {
						ans += C + loc + tloc;
					}else { 
						ans += C + (R - loc) + (R - tloc);
					}
					break;
				}
				break;
			case 4:
				switch(tdir) {
				case 1:
					ans += loc + (C - tloc);
					break;
				case 2:
					ans += (R - loc) + (C- tloc);
					break;
				case 3:
					if((R - loc) >= tloc) {
						ans += C + loc + tloc;
					}else { 
						ans += C + (R - loc) + (R - tloc);
					}
					break;
				case 4:
					ans += Math.abs(loc - tloc);
					break;
				}
				break;
			}
		}
		
		System.out.println(ans);
	}

}
