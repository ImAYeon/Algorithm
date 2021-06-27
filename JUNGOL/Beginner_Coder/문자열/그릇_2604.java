import java.io.BufferedReader;
import java.io.InputStreamReader;

public class JUNGOL_그릇_2604 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] cArr = br.readLine().toCharArray();
		
		int sum = 10;
		char prev = cArr[0];
		
		for(int i = 1; i < cArr.length; i++) {
			if(cArr[i] == prev) {
				sum += 5;
			}else {
				sum += 10;
			}
			prev = cArr[i];
		}
		
		System.out.println(sum);
		
	}

}
