package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_배열돌리기3_16935 {

	static int N, M, R, S;
	static int[][] map;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] read = br.readLine().split(" ");
		
		N = Integer.parseInt(read[0]);
		M = Integer.parseInt(read[1]);
		R = Integer.parseInt(read[2]);
		
		map = new int[N][M];
		for(int i = 0; i < N; i++) {
			String[] line = br.readLine().split(" ");
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(line[j]);
			}
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		while(st.hasMoreTokens()){
			S = Integer.parseInt(st.nextToken());
			switch(S) {
			case 1:
				reverse(1); // 상하 반전
				break;
			case 2:
				reverse(2); // 좌우 반전
				break;
			case 3:
				rotate(1); // 오른쪽으로 90도 회전
				break;
			case 4:
				rotate(2); // 왼쪽으로 90도 회전
				break;
			case 5:
				rotateGroup(1); // 그룹 부분 배열 오른쪽 회전
				break;
			case 6:
				rotateGroup(2); // 그룹 부분 배열 왼쪽 회전
				break;
			}
		}

		//출력
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[i].length-1; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println(map[i][map[i].length-1]);
		}
		
	}
	
	static void reverse(int s) { // s = 1 -> 상하 반전, s = 2 -> 좌우 반전
		int temp;
		if(s == 1) { // 상하 반전
			for(int i = 0; i < N/2; i++) {
				for(int j = 0; j < M; j++) {
					temp = map[i][j];
					map[i][j] = map[N-1-i][j];
					map[N-1-i][j] = temp;
				}
			}
			
		}else { // 좌우 반전
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M/2; j++) {
					temp = map[i][j];
					map[i][j] = map[i][M-1-j];
					map[i][M-1-j] = temp;
				}
			}
		}
	}

	static void rotate(int s) { // s = 1 -> 오른쪽으로 90도 회전, s = 2 -> 왼쪽으로 90도 회전
		// 배열크기 N, M 바꿔줘야 함
		int n = map.length;
		int m = map[0].length;
		int[][] temp = new int[m][n];
		if(s == 1) {
			for(int j = 0; j < m; j++) { // M번반복
				for(int i = n -1, k = 0; i >=0; i--, k++) {// N번반복, 대신 i는 y축 끝에서 시작해서 줄어드는 형태, k는 0에서 시작해서 늘어나는 형태
					temp[j][k] = map[i][j];
				}
			}
		}else {
			for(int j = m-1, k = 0; j >=0; j--, k++) {
				for(int i = 0; i < n; i++) { // N번반복 -> map에게는 y축 temp에게는 x축
					temp[k][i] = map[i][j];
				}
			}
		}
		//복사
		map = new int[m][n];
		for(int i = 0 ; i < temp.length; i++) {
			for( int j = 0; j < temp[0].length; j++) {
				map[i][j] = temp[i][j];
			}
		}
		M = n;
		N = m;
	}
	
	static void rotateGroup(int s) { // s = 1 -> 그룹 부분 배열 오른쪽 회전, s = 2 -> 그룹 부분 배열 왼쪽 회전
		int[][] temp = new int[N][M];
		
		if(s == 1) {
			int[] sx = {0, M/2, M/2, 0};
			int[] sy = {0, 0, N/2, N/2};
			int[] tsx = {M/2, M/2, 0, 0};
			int[] tsy = {0, N/2, N/2, 0};
			
			for(int k = 0; k < 4; k++) { //그룹 4개 이동해야하므로 4번반복
				for(int i = 0; i < N/2; i++) { // y축 N/2번반복
					for(int j = 0; j < M/2; j++) { // x축 M/2번반복
						temp[tsy[k]+i][tsx[k]+j] = map[sy[k] + i][sx[k] + j];
					}
				}
			}
		}else {
			int[] sx = {0, 0, M/2, M/2};
			int[] sy = {0, N/2, N/2, 0};
			int[] tsx = {0, M/2, M/2, 0};
			int[] tsy = {N/2, N/2, 0, 0};
			
			for(int k = 0; k < 4; k++) { //그룹 4개 이동해야하므로 4번반복
				for(int i = 0; i < N/2; i++) { // y축 N/2번반복
					for(int j = 0; j < M/2; j++) { // x축 M/2번반복
						temp[tsy[k]+i][tsx[k]+j] = map[sy[k] + i][sx[k] + j];
					}
				}
			}
		}
		//복사
		for(int i = 0 ; i < temp.length; i++) {
			for( int j = 0; j < temp[0].length; j++) {
				map[i][j] = temp[i][j];
			}
		}
	}

}
