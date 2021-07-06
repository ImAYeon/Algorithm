package 도형만들기2;

import java.util.Scanner;

public class JUNGOL_숫자삼각형_1641 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		if(n%2==0 || n <= 0 || n > 100 || m < 1 || m > 3) {
			System.out.println("INPUT ERROR!");
			System.exit(1);
		}
		
		if(m == 1) {
			int[][] arr = new int[n][n];
			int cnt = 1;
			for(int i = 0; i < n; i++) {
				if(i%2!=0) { // 홀수
					for(int j = i; j >= 0; j--) {
						arr[i][j] = cnt;
						cnt++;
					}
				}else { // 짝수
					for(int j = 0; j <= i; j++) {
						arr[i][j] = cnt;
						cnt++;
					}
				}
			}
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					if(arr[i][j] != 0) {
						System.out.print(arr[i][j] + " ");
					}
				}
				System.out.println();
			}
		}else if(m == 2) {
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < i; j++) {
					System.out.print("  ");
				}
				for(int j = 0; j < 2*(n-i)-1; j++) {
					System.out.print(i + " ");
				}
				System.out.println();
			}
		}else if(m == 3) {
			int end = 1;
			for(int i= 0; i < n; i++) {
				for(int j = 1; j <= end ;j++) {
					System.out.print(j + " ");
				}
				if(i < n/2) end++;
				else end--;
				System.out.println();
			}
			
			
		}

	}

}
