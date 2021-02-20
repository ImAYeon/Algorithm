package swea.d204;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class SWEA_1218_괄호짝짓기 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t = 1; t <= 10; t++) {
			Stack<Character> stack = new Stack<>();
			int result = 0;
			int L = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			char top = ' ';

			for(int i = 0; i < L; i++) {
				char bracket = s.charAt(i);
				if(bracket == '{' || bracket == '[' || bracket == '(' || bracket == '<') {
					stack.push(bracket);
				}else {
					top = stack.pop();
					if(bracket == '}' && top != '{') {		
						 result = 0;
						 break;
					}else if(bracket == ']' && top != '[') {	
						 result = 0;
						 break;
					}else if(bracket == ')' && top != '(') {	
						 result = 0;
						 break;
						
					}else if(bracket == '>' && top != '<') {	
						 result = 0;
						 break;
						
					}
				}
			}
			if(!stack.empty()) result = 0;
			else result = 1;
			
			
			System.out.println("#" + t + " " + result);
		}
	}

}
