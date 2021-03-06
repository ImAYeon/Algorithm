package bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_2007년_1924 {
	/*
	 * 1 1 : MON
	 * 1 2 : TUE
	 * 1 3 : WED
	 * 1 4 : THU
	 * 1 5 : FRI
	 * 1 6 : SAT
	 * 1 7 : SUN
	 * 1 14 : SUN
	 * 1 21 : SUN
	 * 1 28 : SUN
	 * 1 29 : MON
	 * 1 30 : TUE
	 * 1 31 : WED
	 * 2 1 (sumDate = 32) : THU
	 */

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		int x = Integer.parseInt(input[0]); // 월
		int y = Integer.parseInt(input[1]); // 일
		
		int[] date = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; // 인덱스 1부터 시작하기 위해 0인덱스는 dummy
		
		String[] day = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
		
		
		int sumDate = 0;
		for(int i = 1; i < x; i++) { // 이전 달의 일 수 다 더해주기
			sumDate += date[i];
		}

		sumDate += y; // 지금 달의 일 수 더해주기
		
		System.out.println(day[sumDate % 7]);
		
	}

}
