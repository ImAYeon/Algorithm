package 도형만들기2;

import java.util.Scanner;

public class JUNGOL_별삼각형1_1523 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		if(n < 1 || n > 100 || m < 1 || m > 3) {
			System.out.println("INPUT ERROR!");
			System.exit(1);
		}
		
		if(m == 1) {
			for(int i = 1; i <= n; i++) {
				for(int j = 1; j <= i; j++) {
					System.out.print("*");
				}
				System.out.println();
			}
		}else if(m == 2) {
			for(int i = 0; i < n; i++) {
				for(int j = 1; j <= n-i; j++) {
					System.out.print("*");
				}
				System.out.println();
			}
		}else if(m == 3) {
			for(int i = 1; i <= n; i++) {
				// 4 3 2 1 0 -> " "
				for(int j = 1; j <= n-i; j++) {
					System.out.print(" ");
				}
				// 1 3 5 7 9 "*"
				for(int j = 1; j <= 2*i-1; j++) {
					System.out.print("*");
				}
				System.out.println();
			}
		}
		
	}

}
