import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_2609_최대공약수와최소공배수 {

	public static void main(String[] args) throws Exception{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		
		String s[] = br.readLine().split(" ");
		
		int A = Integer.parseInt(s[0]);
		int B = Integer.parseInt(s[1]);
		
		// 유클리드 호제법
		// A를 B로 나눈 몫을 Q,나머지를 R이라고 할 때
		// gcd(A,B) = gcd(B,R)
		// 이 과정을 계속 반복하여, 어느 한 쪽이 나누어질때까지 반복, 직전 얻은 나머지가 최대 공약수
		
		int a = A, b = B;
		if(B > A) {// 더 큰수가 a에 오게 만듬
			int temp = b;
			b = a;
			a = temp;
		}
		
		int max = 0, min = 0; // 최대공약수, 최소공배수
		while(true) {
			int temp = a;
			a = b;
			b = temp % b;
			
			if(b == 0) {
				max = a;
				break;
			}
		}
		
		min = max * (A / max) * (B /max);//최소공배수
		
		System.out.println(max);
		System.out.println(min);
	}

}
