import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_스택수열_1874 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N+1];
		for(int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();
		
		int idx = 1;
		for(int n = 1; n <= N; n++) {
			stack.push(n);
			sb.append('+').append('\n');
			while(!stack.isEmpty()) {
				if(stack.peek() == arr[idx]) {
					stack.pop();
					sb.append('-').append('\n');
					idx++;
				}else if(arr[idx] < stack.peek()){
					System.out.println("NO");
					System.exit(0);
				}
				else break;
			}
			
		}
		
		System.out.println(sb.toString());
		
	}

}
