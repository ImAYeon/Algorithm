package d2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA_패턴마디의길이_2007_other2 {
	
	static final int LENTH = 30;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= TC; tc++) {
			String s = br.readLine();
			
			for(int i = 1; i <= LENTH; i++) {
				String pattern = s.substring(0, i);
				String tmp = s.substring(i, i+i);
				if(pattern.equals(tmp)) {
					System.out.println("#" + tc + " " + pattern.length());
					break;
				}
			}
		}

	}

}
