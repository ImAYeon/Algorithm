package d2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_시각덧셈_1976 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int TC = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= TC; tc++) {
			st = new StringTokenizer(br.readLine());
			int hour1 = Integer.parseInt(st.nextToken());
			int min1 = Integer.parseInt(st.nextToken());
			int hour2 = Integer.parseInt(st.nextToken());
			int min2 = Integer.parseInt(st.nextToken());
			
			int hour = 0;
			int min = min1 + min2;
			if(min >= 60) {
				hour += 1;
				min -= 60;
			}
			hour += (hour1 + hour2) % 12;
			
			System.out.println("#" + tc + " " + hour + " " + min);
		}

	}

}
