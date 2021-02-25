package bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_나머지_3052 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] arr = new int[10];
		
		for(int i = 0; i < 10; i++) {
			arr[i] = ( Integer.parseInt( br.readLine() ) ) % 42;
		}
		
		Arrays.sort(arr);
		
		int ans = 10;
		for(int i = 1; i < 10; i++) {
			if(arr[i] == arr[i-1]) ans--; // 나머지들을 담은 배열을 정렬을 시켜서 그전과 똑같은 숫자면 중복이니까 10개중에서 계속 하나씩 빼준다
		}
		
		System.out.println(ans);
	}

}
