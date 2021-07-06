package 도형만들기2;

import java.util.Scanner;

public class JUNGOL_파스칼삼각형_2071 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[][] arr = new int[n][n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j <= i; j++) {
				if(j == 0 || i == j) arr[i][j] = 1;
				else arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
			}
		}
		
		if(m == 1) {
			for(int i = 0; i < n; i++) {
				for(int j = 0; j <= i; j++) System.out.print(arr[i][j] + " ");
				System.out.println();
			}
		}else if(m == 2) {
			for(int i = n-1; i >= 0; i--) {
				for(int j = 0; j < n-i-1; j++) System.out.print(" ");
				for(int j = 0; j <= i; j++) System.out.print(arr[i][j] + " ");
				System.out.println();
			}
		}else if(m == 3) {
			for(int i = n-1; i >= 0; i--) {
				for(int j = n-1; j >= i; j--) System.out.print(arr[j][i] + " ");
				System.out.println();
			}
		}

	}

}
