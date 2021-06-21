package 도형만들기1;

import java.util.Arrays;
import java.util.Scanner;

public class JUNGOL_문자삼각형2_1339 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(); // 정사각형 한 변의 길이
		
		if(n % 2 == 0 || n < 1 || n > 100) {
			System.out.println("INPUT ERROR");
			System.exit(1);
		}
		
		char[][] arr = new char[n][n];
		
		for(char c[] : arr) Arrays.fill(c, ' ');
		
		char ch = 'A';
		
		for(int i = n/2, k = 1; i >= 0; i--, k+=2) {
			for(int j = i; j < i + k; j++) {
				arr[j][i] = ch++;
				if(ch > 'Z') ch = 'A';
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(arr[i][j] == ' ') break;
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

}
