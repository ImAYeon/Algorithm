package silverV;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_크로아티아알파벳_2941 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] input = br.readLine().toCharArray();
		
		int index = 0;
		int cnt = 0;
		while(index < input.length) {
			if(index == input.length-1) {
				cnt++;
				break;
			}
			char letter = input[index];
			if( letter == 'c' && (input[index+1] == '=' || input[index+1] == '-') ) {
				cnt++;
				index += 2;
				continue;
			}else if( letter == 'd' && input[index+1] == '-'  ) {
				cnt++;
				index += 2;
				continue;
			}else if( letter == 'd' && index+2 < input.length && input[index+1] == 'z' && input[index+2] == '=' ) {
				cnt++;
				index += 3;
				continue;
			}else if( letter == 'l' && input[index+1] == 'j') {
				cnt++;
				index += 2;
				continue;
			}else if( letter == 'n' && input[index+1] == 'j') {
				cnt++;
				index += 2;
				continue;
			}else if( letter == 's' && input[index+1] == '=') {
				cnt++;
				index += 2;
				continue;
			}else if( letter == 'z' && input[index+1] == '=') {
				cnt++;
				index += 2;
				continue;
			}
			cnt++;
			index++;
		}
		
		System.out.println(cnt);
	}

}
