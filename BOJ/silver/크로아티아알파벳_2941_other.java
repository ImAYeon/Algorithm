package silverV;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_크로아티아알파벳_2941_other {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		String[] croatia = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

		int cnt = 0;
		for(String c : croatia) {
			while(input.contains(c)) {
				input = input.replaceFirst(c, " "); // replaceFirst - 바꾸고자 하는 문자열이 처음으로 해당할때만 치환
			}
		}

		System.out.println(input.length());
	}

}
