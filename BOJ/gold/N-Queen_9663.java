package goldV;

import java.util.Scanner;

public class BOJ_NQueen_9663 {

	static int ans, N;
	static int[] col; // 부모노드가 놓인 위치 기억 (같은행에는 놓지 않는 방식 -> 어느 여려에 있는지 위치값만 기억하면됨
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		col = new int[N+1]; // 1퀸은 1행, 2퀸은 2행 (0인덱스 안씀)
		
		setQueen(0); // 첫번째 퀸도 1,2,3,4 뿌려져야 하므로 루트노드를 설정해서 마치 1퀸도 부모가 있는 것처럼
		System.out.println(ans);

	}
	
	public static void setQueen(int rowNo) {
		
		// 현재 노드가 유망하지 않다면 돌아가기
		if(!isAvailable(rowNo)) {
			return;
		}
		
		if(rowNo == N) { // N번째 퀸을 모두 본거
			ans++;
			return;
		}
		
		// 자식 노드의 가지를 파생
		for(int i =1; i <= N; i++) {
			col[rowNo+1] = i; // 현재 부모노드 입장에서 자식의 가지를 만들어내는 역할
			setQueen(rowNo + 1);
		}
		
	}
	
	private static boolean isAvailable(int rowNo) {
		
		for(int i = 1; i < rowNo; i++) { // 첫번째 퀸부터 직전퀸까지 들여다보기
			// 퀸이 서로 위협적인 위치면 false
			if(col[rowNo] == col[i] || Math.abs(col[rowNo] - col[i]) == rowNo - i) return false; // 대각선 -> 열차이랑 행차이가 같음
		}
		 return true;
	}

}
