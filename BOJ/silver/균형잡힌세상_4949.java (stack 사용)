import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_균형잡힌세상_4949 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			char[] sentence = br.readLine().toCharArray();
			if(sentence[0] == '.') break;
			
			Stack<Character> stack = new Stack<Character>();
			
			int flag = 0;
			int len = sentence.length;
			for(int i = 0; i < len; i++) {
				if(sentence[i] == '[') stack.push('[');
				else if(sentence[i] == '(') stack.push('(');
				else if(sentence[i] == ']') {
					if(!stack.isEmpty() && stack.peek() == '[') stack.pop();
					else {
						flag = 1;
						break;
					}
				}
				else if(sentence[i] == ')') {
					if(!stack.isEmpty() && stack.peek() == '(') stack.pop();
					else {
						flag = 1;
						break;
					}
				}
			}
			
			if(!stack.isEmpty()) flag = 1;
			
			if(flag == 0) System.out.println("yes");
			else System.out.println("no");
			
		}
	}

}
