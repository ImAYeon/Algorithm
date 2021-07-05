package d2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA_패턴마디의길이_2007_other1 {
	
	static final int LENTH = 30;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= TC; tc++) {
			char[] input = br.readLine().toCharArray();
			
			int j = 0;
			int i = 1;
			for(;i < LENTH; i++) {
				//System.out.println("i : " + i + ", input[i] = " + input[i] + ", j : " + j + ", input[j]" + input[j]);
				if(input[i] == input[j]) {
					j++;
				}else {
					j = 0;
				}
			}
			
			System.out.println("#" + tc + " " + (i-j));
		}

	}

}
