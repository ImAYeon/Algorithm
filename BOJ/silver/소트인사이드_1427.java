import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_소트인사이드_1427 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] arr = br.readLine().toCharArray();
		
		Arrays.sort(arr);
		
//		String s = "";
//		for(int i = arr.length-1; i >= 0; i--) s += arr[i];
//		System.out.println(s);
		
		StringBuilder sb = new StringBuilder();
		for(int i = arr.length-1; i>=0; i--) sb.append(arr[i]);
		System.out.println(sb.toString());
	}

}
