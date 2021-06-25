package 수학1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class JUNGOL_숫자의개수_1430 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());
		
		int res = A*B*C;
		
		int[] arr = new int[10]; // 0 ~ 9
		
		while(res > 0) {
			arr[res%10]++;
			res /= 10;
		}
		
		for(int i = 0; i < 10; i++) {
			System.out.println(arr[i]);
		}
	}

}
