import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_괄호_9012 {
    
    public static void main(String[] args) throws Exception{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            boolean check = true;
            char[] input = br.readLine().toCharArray();
            Stack<Character> stack = new Stack<Character>();
            for(int i = 0; i < input.length; i++){
                if(input[i] == '(') stack.add('(');
                else{ // input[i] == ')'
                    if(stack.isEmpty()){
                        check = false;
                        break;
                    }
                    stack.pop();
                }
            }
            if(!stack.isEmpty()) check = false;
            
            if(check){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
    
    
}
