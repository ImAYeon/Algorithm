package 도형만들기1;

import java.util.Arrays;
import java.util.Scanner;

public class JUNGOL_문자삼각형1_1338 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(); // 정사각형 한 변의 길이
		
		char[][] arr = new char[n][n];
		
		for(char c[] : arr) Arrays.fill(c, ' ');
		
		char ch = 'A';
		
		for(int i = 1; i <= n; i++) {
			for(int x = i, y = n; x <= n; x++, y--) {
				arr[x-1][y-1] = ch++;
				if(ch > 'Z') ch = 'A';
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

}
