import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JUNGOL_최대공약수최소공배수_1002 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int gcd, lcm;
		gcd = lcm = arr[0];
		for(int i = 1; i < N; i++) {
			gcd = GCD(gcd, arr[i]);
			lcm = (lcm * arr[i]) / GCD(lcm,arr[i]);
		}
		
		System.out.println(gcd + " " + lcm);
	}
	
	static int GCD(int u, int v) {
		if(v == 0) return u;
		
		return GCD(v, u % v);
	}

}
