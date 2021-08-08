package d2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Base64;

public class SWEA_Base64Decoder_1928 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			String encode = br.readLine();
			String decode = new String(Base64.getDecoder().decode(encode));
			
			System.out.println("#" + tc+ " " + decode);
		}
	}

}
