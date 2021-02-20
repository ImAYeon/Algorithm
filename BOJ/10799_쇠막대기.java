package silverIII;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_쇠막대기_10799 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] input = br.readLine().toCharArray();
		Stack<Character> s = new Stack<>();
		int flag = 0, ans = 0;
		
		for(char c : input) {
			if(c == '(') {
				s.push(c);
				flag = 0;
				continue;
			}
			s.pop();
			if(flag++ == 0) { // flag가 0이면 앞에 '('라는뜻, 그리구 flag를 1로 바꿔줌
				ans += s.size();
			}else { //flag가 1이면 앞에 ')'라는 뜻
				ans += 1; // 한개의 막대기가 끝나는걸 뜻하기 때문
			}
			
			
		}
		System.out.println(ans);

	}

}
