package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_2493_탑 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Stack<Integer> stack = new Stack<Integer>();
		Stack<Integer> index = new Stack<Integer>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		stack.push(Integer.parseInt(st.nextToken())); // 처음값 push
		index.push(1); //인덱스 번호 관리
		sb.append("0 "); // 처음 값 결과는 무조건 0출력
		
		for(int i = 2; i <= N; i++) {
			
			int current = Integer.parseInt(st.nextToken());
			
			if(stack.peek() >= current) { // current보다 top이 클 경우
			
				sb.append(index.peek() + " "); // top 출력
			
			}else { // current보다 top이 작을경우
				
				stack.pop(); // 지금 top을 pop해주고
				index.pop(); // 지금 top의 index도 필요없으므로 pop
				
				while(!stack.isEmpty()) { // current보다 더 큰 녀석 만날때까지 비교&pop() 반복
					if(stack.peek() >= current) { // pop하고나서 다음의 top이 current보다 클 경우
						sb.append(index.peek() + " ");
						break;
					}
					stack.pop(); // 다음의 top도 current보다 작을 경우 pop
					index.pop(); // 그 이후로도 스택이 empty일때까지 반복
				}
				// 여기까지 내려왔다는거는 stack이 empty이거나, top이 current보다 켜서 break;가 걸린경우
				if(stack.isEmpty())sb.append("0 "); // empty일때만 0추가
			}
			
			stack.push(current);
			index.push(i);
		}
		
		sb.setLength(sb.length()-1);
		System.out.println(sb.toString());

	}

}
