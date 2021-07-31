package silverV;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_빙고_2578 {
	
	static int[][] bingo = new int[5][5];
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 5; j++) {
				bingo[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int cnt = 0;
		for(int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 5; j++) {
				cnt++;
//				System.out.println("\n cnt : " + cnt);
//				System.out.println();
				findNum( Integer.parseInt(st.nextToken()) ); // 부른 숫자 0으로 표시하기
//				System.out.println("---------------bingo------------------");
//				print();
//				System.out.println("---------------matrix------------------");
				int count = cntBingo();
//				System.out.println("count : " + count);
				if( count >= 3 ) { // 빙고개수가 한꺼번에 2에서 4로 늘어날 수 있기 때문에 3이상으로 해줘야 함
					System.out.println(cnt);
					System.exit(0);
				}
			}
		}
		
	}
	
	static void findNum(int n) {
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				if(bingo[i][j] == n) {
					bingo[i][j] = 0;
					return;
				}
			}
		}
	}
	
	static int cntBingo() {
		int count = 0;
		int[][] matrix = new int[2][5]; // [0][0~4] : 행 5개, [1][0~4] : 열 5개
		int[] diagonal = new int[2]; // 대각선 
		
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				if(bingo[i][j] == 0) {
					matrix[0][i]++;
					matrix[1][j]++;
					if(j == i) diagonal[0]++;
					if(j == (5-i-1)) diagonal[1]++;
				}
			}
		}
		
		
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < 5; j++) {
				if(matrix[i][j] == 5) count++;
//				System.out.print(matrix[i][j]);
			}
//			System.out.println();
		}
//		System.out.println("diagonal[0] : " + diagonal[0]);
//		System.out.println("diagonal[1] : " + diagonal[1]);
		if(diagonal[0] == 5) count++;
		if(diagonal[1] == 5) count++;
		
		
		return count;
	}
	
	static void print() {
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				System.out.print(bingo[i][j] + "\t");
			}
			System.out.println();
		}
	}

}
