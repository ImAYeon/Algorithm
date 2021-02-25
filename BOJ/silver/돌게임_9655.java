package silverV;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_돌게임_9655 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		boolean flag = false; //flag = true -> 상근이가 가져감 , flag = false -> 창영이가 가져감
		while(N > 0) {
			if(N >=3) {
				N -= 3;
				flag = !flag;
			}
			else {
				N -= 1;
				flag = !flag;
			}
		}

		if(flag) System.out.println("SK");
		else System.out.println("CY");
	}

}
