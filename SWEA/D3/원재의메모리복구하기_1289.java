package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA_1289 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T ; t++) {
			String str = br.readLine();
			char[] input = str.toCharArray();
			
			int result = 0;
			if(input[0] == '1') result++;
			for(int i= 0 ; i < input.length - 1; i++) {
				if(input[i] != input[i+1]) result++;
			}
			System.out.println("#" + t + " " + result);
			
		}
	}
}
