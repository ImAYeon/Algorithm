package silverIII;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_단어뒤집기2_17413 {

	public static void main(String[] args) throws Exception{	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] s = br.readLine().toCharArray();
		
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack =  new Stack<Character>();
		
		int index = 0;
		while(true) {
			if(s[index] == '<') {
				sb.append(s[index]); 
				while(true) {
					index++;
					if(s[index] == '>') {
						sb.append(s[index]);
						if(index != s.length -1) index++;
						break;
					}
					sb.append(s[index]);
				}
				continue; // 사실 계속 실행해도 괜찮고 다시 while을 처음부터 돌아도 괜찮다 ('< >''< >' 이런형태로 태그가 두번이상 올 수도 있기 때문에 처음부터 그냥 돌겠다.)
			}
			
			if(Character.isDigit(s[index]) || Character.isAlphabetic(s[index])) {
				String word = "";
				while(true) {
					word += s[index];
					if(index == s.length-1) {
						StringBuilder sbTemp = new StringBuilder(word);
						sb.append(sbTemp.reverse());
						break;
					}
					index++;
					if(s[index] == ' ') {
						StringBuilder sbTemp = new StringBuilder(word);
						sb.append(sbTemp.reverse() + " ");
						index++;
						break;
					}
					if(s[index] == '<') {
						StringBuilder sbTemp = new StringBuilder(word);
						sb.append(sbTemp.reverse());
						break;
					}
				}
			}
			if(index == s.length -1) break;
		}
		
		System.out.println(sb.toString());
		
	}

}
