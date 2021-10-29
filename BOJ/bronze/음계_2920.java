import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_음계_2920 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] input = new int[8];
		for(int i = 0; i < 8; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		String s = " ";
		for(int i = 1; i < 8; i++) {
			if(input[i] == input[i-1] + 1) s = "ascending";
			else if(input[i] == input[i-1] - 1) s = "descending";
			else {
				s = "mixed";
				break;
			}
		}
		
		System.out.println(s);
	}

}
