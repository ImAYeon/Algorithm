package jungol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class JUNGOL_냉장고_1828 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 화학물질의 수
		
		int[][] arr = new int[N][2]; // 각 화학물질의 최저온도와 최고온도 저장할 배열
		
		for(int n = 0; n < N; n++) {
			String[] s = br.readLine().split(" ");
			arr[n][0] = Integer.parseInt(s[0]);
			arr[n][1] = Integer.parseInt(s[1]);
		}
		
		Arrays.sort(arr, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) { //최고온도 기준으로 정렬, 같으면 최저온도기준으로 정렬
				return o1[1] == o1[1] ? o1[0] - o2[0] : o1[1] - o1[2] ;
			}
			
		});
		
		// sort 했을 때, 최고온도는 정렬되있음 
		// -> 만약 제일 큰 수의 최고온도인 화학물질의 최저온도보다 어떤 화학물질의 최고온도 가 더 낮다면 count++
		// 그 화학물질의 최저온도가 다시 "경계"가 되서 그 최저온도보다 낮은 최고온도를 찾으면 count++ 반복
		int bound = arr[N-1][0]; // 제일 최고온도인 화학물질의 최저온도를 경계로 설정
		int count = 1;
		for(int i = N-2; i >= 0; i--) {
			if(arr[i][1] < bound) { // 만약 이 화학물질의 최고온도가 경계보다 더 낮다면 냉장고 하나 더 필요
				count++;
				bound = arr[i][0]; // 다시 그 화학물질의 최저온도를 경계로 바꿔줌
			}
		}
		
		System.out.println(count);
	}

}
