import java.util.Scanner;

public class JUNGOL_최대공약수와최소공배수_1658 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		System.out.println( gcd(a,b) ); //gcd
		System.out.println( (a*b)/gcd(a,b) ); //lcm
		

	}
	
	static int gcd(int u, int v) {
		if(v == 0) return u;
		
		return gcd(v, u % v);
	}

}
