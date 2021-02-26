package silverV;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_나무조각_2947 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] input = new int[5];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i =0; i < 5; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] ans = {1, 2, 3, 4, 5};
		
		while(true) {
			for(int i = 0; i < 4; i++) {
				if(input[i] > input[i+1]) {
					int temp = input[i];
					input[i] = input[i+1];
					input[i+1] = temp;
					for(int k = 0;k < 5; k++) {
						System.out.print(input[k] + " ");
					}
					System.out.println();
				}
			}
			
			boolean check = true;
			for(int i = 0; i < 5; i++) {
				if(input[i] != ans[i]) {
					check = false;
					break;
				}
			}
			if(check) break;
			
		}
		
		
	}

}
