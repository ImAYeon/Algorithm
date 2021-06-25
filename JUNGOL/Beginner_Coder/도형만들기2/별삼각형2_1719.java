package 도형만들기2;

import java.util.Scanner;

public class JUNGOL_별삼각형2_1719 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		if(n % 2 == 0 || n > 100 || m < 1 || m > 4) {
			System.out.println("INPUT ERROR!");
			System.exit(1);
		}

		if(m == 1) {
			for(int i = 0; i < n; i++) {
				if(i < (n/2) +1) {
					for(int j = 0; j < i+1; j++) {
						System.out.print("*");
					}
				}else {
					for(int j = 0; j < n-i ; j++) {
						System.out.print("*");
					}
				}
				System.out.println();
			}
		}else if(m == 2) {
			for(int i = 0; i < n; i++) {
				if(i < (n/2) +1) { 
					for(int j = 0; j  < n/2 - i; j++) {
						 System.out.print(" ");
					}
					for(int j = 0; j < i+1; j++) {
						System.out.print("*");
					}
				}else { // i = n/2+1 ~ n
					for(int j = 0; j < (n/2+1)-(n-i) ; j++) {
						System.out.print(" ");
					}
					for(int j = 0; j < n-i ; j++) {
						System.out.print("*");
					}
				}
				System.out.println();
			}
		}else if(m == 3) {
			for(int i = 0; i < n/2; i++) {
				for(int j = 0; j < i; j++) {
					System.out.print(" ");
				}
				for(int j = 0; j < n-2*i; j++) {
					System.out.print("*");
				}
				System.out.println();
			}
			for(int i = 0; i < n/2+1; i++) {
				for(int j =0; j < n/2-i; j++) {
					System.out.print(" ");
				}
				for(int j = 0; j < 2*i+1; j++) {
					System.out.print("*");
				}
				System.out.println();
			}
		}else if(m == 4) {
			for(int i = 0; i < n/2; i++) {
				for(int j = 0; j < i; j++) {
					System.out.print(" ");
				}
				for(int j = 0; j < (n/2+1)-i; j++) {
					System.out.print("*");
				}
				System.out.println();
			}
			for(int i = 0; i < n/2+1; i++) {
				for(int j = 0; j < n/2; j++) {
					System.out.print(" ");
				}
				for(int j = 0; j < i+1; j++) {
					System.out.print("*");
				}
				System.out.println();
			}
		}
		
		
	}

}
