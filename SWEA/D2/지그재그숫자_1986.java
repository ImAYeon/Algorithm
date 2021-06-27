package d2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA_지그재그숫자_1986 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= TC; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			System.out.println("#" + tc + " " + ( N % 2 == 0 ? -1*(N/2) : -1*(N/2)+N ));
		}
		
	}

}
