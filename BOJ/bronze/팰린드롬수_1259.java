import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_팰린드롬수_1259 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input;
		
		while(!(input=br.readLine()).equals("0")) {
			String result = "yes";
			for(int i = 0; i < input.length()/2; i++) {
				if(input.charAt(i) != input.charAt(input.length()-i-1)) {
					result = "no";
					break;
				}
			}
			System.out.println(result);
		}
		
	}

}
