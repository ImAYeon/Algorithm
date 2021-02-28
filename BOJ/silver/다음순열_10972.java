import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 실버 III
public class BOJ_다음순열_10972 {

	static int N;
	static int[] input;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		input = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		
		boolean check = np();
		
		if(check) {
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < N; i++) {
				System.out.print(input[i] + " ");
			}
		}else {
			System.out.println(-1);
		}
		
	}
	
	static boolean np() {
		
		int i = N-1;
		
		while(i > 0 && input[i-1] >= input[i]) --i;
		
		if(i == 0) {
			return false;
		}
		
		int j = N-1;
		while(input[i-1] >= input[j]) --j;
		
		swap(i-1,j);
		
		int k = N-1;
		while(i < k) swap(i++, k--);
		return true;
	}
	
	static void swap(int i, int j) {
		int temp = input[i];
		input[i] = input[j];
		input[j] = temp;
		return;
	}

}
