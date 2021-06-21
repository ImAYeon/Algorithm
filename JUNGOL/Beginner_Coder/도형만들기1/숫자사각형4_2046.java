package 도형만들기1;

import java.util.Scanner;

public class JUNGOL_숫자사각형4_2046 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(); // 정사각형 한 변의 길이
		int m = sc.nextInt(); //. 종류
		
		if(m == 1) {
			for(int i = 1; i <= n; i++) {
				for(int k = 0; k < n; k++) {
					System.out.print(i + " ");
				}
				System.out.println();
			}
		}
		else if(m == 2) {
			for(int i = 0; i < n; i++) {
				if(i % 2 == 0) { 
					for(int k = 1; k <= n; k++) {
						System.out.print(k + " ");
					}
					System.out.println();
				}else {
					for(int k = n; k >= 1; k--) {
						System.out.print(k + " ");
					}
					System.out.println();
				}
			}
		}
		else if(m == 3) {
			for(int i = 1; i <= n; i++) {
				for(int k = 1; k <= n; k++) {
					System.out.print(i*k + " ");
				}
				System.out.println();
			}
		}
		
	}

}
