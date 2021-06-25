package 수학1;

import java.util.Arrays;
import java.util.Scanner;

public class JUNGOL_약수_2809_other {

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
		
		// cnt가 배열의 사이즈를 가리키고 있다는것이 중요!!!!!!!!
		
		// 정렬
		for(int i = 0; i < cnt; i++) {
			for(int j = i+1; j < cnt; j++) {
				int temp;
				if(arr[i] > arr[j]) { // 뒤에 더 작은게 있으면 바꿈
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
			
		}
		
		// 출력
		for(int i = 0; i < cnt; i++) {
			System.out.print(arr[i] + " ");
		}
		
	}

}
