import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_사람네트워크2_1263 {

	static int T, N, min, BIG = 999999;
	static int[][] adjMatrix;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringTokenizer st;

		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			adjMatrix = new int[N][N];
			min = Integer.MAX_VALUE;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int input = Integer.parseInt(st.nextToken());
					if (input == 1)
						adjMatrix[i][j] = 1;
					else if (input == 0)
						adjMatrix[i][j] = BIG;
				}
			}
			
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < N; j++) {
//					System.out.print(adjMatrix[i][j] + " ");
//				}
//				System.out.println();
//			}
			

			//System.out.println("===========입력==========");
			//print();
			// 플로이드 적용
			for (int k = 0; k < N; k++) {
				for (int i = 0; i < N; i++) {
					if (k == i)
						continue; // 출발지와 경유지가 같다면 다음 출발지
					for (int j = 0; j < N; j++) {
						if (i == j || k == j)
							continue; // 경유지와 목적지가 같거나 출발지가 곧 목적지라면 패스
						adjMatrix[i][j] = Math.min(adjMatrix[i][j], adjMatrix[i][k] + adjMatrix[k][j]);
					}
				}
			}
			//print();
			
			for (int i = 0; i < N; i++) {
				int sum = 0;
				for (int j = 0; j < N; j++) {
					if(adjMatrix[i][j] == 999999) adjMatrix[i][j] = 0;
					sum += adjMatrix[i][j];
				}
				min = Math.min(min, sum);
			}

			System.out.println("#" + t + " " + min);

		}

	}
//	private static void print() {
//		for(int i=0; i<N; ++i) {
//			for(int j=0; j<N; ++j) {
//				System.out.print(adjMatrix[i][j]+"\t");
//			}
//			System.out.println();
//		}
//		System.out.println("=====================================");
//		
//	}
}
