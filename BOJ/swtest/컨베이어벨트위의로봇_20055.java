package swtest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// SilverI


public class BOJ_컨베이어벨트위의로봇_20055 {
	
	static int N, K;
	static int[] A;
	static boolean[] map;
	static int step;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		A = new int[2*N + 1];
		map = new boolean[N + 1];
		
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= 2*N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		
		while(true) {
			step++;
			
			// 벨트 한칸 회전
			rotate();
			
			// 로봇 이동
			move();
			
			// 올라가는 위치에 로봇이 없다면 로봇 올리기
			if(map[1] == false && A[1] >= 1) {
				map[1] = true;
				A[1]--;
			}
			
			// 내구도 확인
			if(!check()) break;
		}
		System.out.println(step);
	}

	private static void rotate() {
		int temp = A[2*N];
		for(int i = 2*N - 1; i >= 1; i--) {
			A[i+1] = A[i];
		}
		A[1] = temp;
		
		for(int i = N-1; i >= 1; i--) { // N에 있는 로봇은 저절로 없어짐(내림)
			map[i+1] = map[i];
		}
		map[1] = false;
	}

	private static void move() {
		map[N] = false; // 로봇 이동(내림)
		for(int i = N-1; i >= 1; i--) { // N번째 칸에 있는 로봇은 내려야함
			if(map[i] == true && map[i+1] == false && A[i+1] >= 1) {
				map[i+1] = true;
				map[i] = false;
				A[i+1]--;
			}
		}
	}

	private static boolean check() {
		int count = 0;
		for(int i = 1; i <= 2*N; i++) {
			if(A[i] == 0) count++;
			if(count >= K) return false;
		}
		return true;
	}

}
