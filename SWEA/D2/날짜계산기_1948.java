package d2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_날짜계산기_1948 {
	
	static int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			int result = 0;
			st = new StringTokenizer(br.readLine());
			
			int startMonth = Integer.parseInt(st.nextToken());
			int startDay = Integer.parseInt(st.nextToken());
			int endMonth = Integer.parseInt(st.nextToken());
			int endDay = Integer.parseInt(st.nextToken());
			
			if(startMonth == endMonth) {
				result = endDay - startDay + 1;
			}else {
				result += days[startMonth] - startDay + 1 + endDay;
				for(int i = startMonth+1; i < endMonth; i++) {
					result += days[i];
				}
			}
			
			
			System.out.println("#" + tc + " " + result);
		}
		
	}
	
}
