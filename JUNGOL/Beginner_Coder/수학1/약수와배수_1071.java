package 수학1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JUNGOL_약수와배수_1071 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[n];
		
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int num = Integer.parseInt(br.readLine());
		
		int sDiv = 0, sMul = 0;
		
		for(int i = 0; i < n; i++) {
			if(num % arr[i] == 0) sDiv += arr[i];
			if(arr[i] % num == 0) sMul += arr[i];
		}
		
		System.out.println(sDiv);
		System.out.println(sMul);
	}

}
