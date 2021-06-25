package 수학1;

import java.util.Arrays;
import java.util.Scanner;

public class JUNGOL_약수_2809 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] arr = new int[10000];
		
		int cnt = 0;
		
		for(int i = 1; i * i <= N; i++) {
			if(N % i == 0) {
				arr[cnt++] = i; // 작은수 저장
				if(N / i != i) { // 작은수와 같이 않을 경우
					arr[cnt++] = N / i; // 큰 수 저장
				}
			}
		}
		
		Arrays.sort(arr);
		
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == 0) continue;
			System.out.print(arr[i] + " ");
		}
		
	}

}
