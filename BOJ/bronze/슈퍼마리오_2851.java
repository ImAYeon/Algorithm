package bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_슈퍼마리오_2851 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int sum = 0;
		for(int i = 0; i < 10; i++) {
			int mr = Integer.parseInt(br.readLine());
			if( (Math.abs(sum-100)) >= (Math.abs(sum+mr-100))) sum += mr;
			else break;
		}
		System.out.println(sum);
	}

}
