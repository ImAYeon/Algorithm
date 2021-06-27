package d2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA_초심자의회문검사_1989 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= TC; tc++) {
			int result = 1;
			
			char[] cArr = br.readLine().toCharArray();
			
			for(int i = 0; i < cArr.length/2; i++) {
				if(cArr[i] != cArr[cArr.length-i-1]) {
					result = 0;
					break;
				}
			}
			
			
			System.out.println("#" + tc + " " + result);
		}
	}

}
