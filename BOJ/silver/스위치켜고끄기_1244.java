package net.acmicpc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algorithm_1244 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 스위치 갯수 입력받음
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s);
		int[] switches = new int[N+1]; // 인덱스 0은 사용하지 않음, 스위치 넘버 1부터 N까지
		for(int i= 1 ; i <= N; i++) {
			switches[i] = Integer.parseInt(st.nextToken()); // 스위치 배열 초기화
		}
		
		int n = Integer.parseInt(br.readLine()); // 학생수 입력받음
		int sex, number; // 성별과 스위치 번호 
		
		for(int i = 0; i < n; i++) {
			s = br.readLine();
			st = new StringTokenizer(s);
			sex = Integer.parseInt(st.nextToken()); // 성별 입력 받기
			number = Integer.parseInt(st.nextToken());
			if(sex == 1) { // 남자일 때
				for(int j = 1; j <= N; j++) {
					// 스위치 숫자가 남자가 받은 스위치의 배수이면 0은 1로 1은 0으로 스위치 상태 바꿈
					if(j % number == 0) switches[j] = 1- switches[j];
				}
			}else if(sex == 2) { // 여자일 때
				int x = 0;
				while(true) {
					if(number-x-1 < 1 || number+x+1 > N) break; // 스위치 범위 배열 벗어나면 break;
					// 대칭 범위 -1, +1부터 시작 ( 대칭아니면 break걸고 x는 0그대로 유지)
					if(switches[number-x-1] != switches[number+x+1]) break; // 대칭이 아닐 때 종료
					x++; // 대칭범위
				}
				for(int j = number - x ; j <= number + x; j++) {
					switches[j] = 1- switches[j]; // 대칭인 구간 <- 이부분 XOR도 가능
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= N; i++) {
			sb.append(switches[i] + " "); // 맨끝에도 공백 처리를 하게된다.
			sb.setLength(sb.length() - 1);
			if(i % 20 == 0) sb.append("\n");
		}
		System.out.println(sb.toString());
		
			
			
	}
}
