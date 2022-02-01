import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_제로_19773 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int K = Integer.parseInt(br.readLine());
		
		int size = 0;
		int[] num = new int[K];
		
		for(int i = 0; i < K; i++) {
			int n = Integer.parseInt(br.readLine());
			if(n != 0) {
				num[size++] = n;
			}
			else if(n == 0) size--; //  n == 0
		}
		
		int sum = 0;
		for(int i = 0; i < size; i++) {
			sum += num[i];
		}
		
		System.out.println(sum);
		
	}

}
