package d2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_숫자배열회전_1961 {
	
	static int N;
	static int[][] arr;
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
	
		int TC = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= TC; tc++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int[][][] result = new int[3][N][N];
			
			result[0] = rotate(arr);
			result[1] = rotate(result[0]);
			result[2] = rotate(result[1]);
			
			System.out.println("#"+tc);
			
			for(int i = 0; i < N; i++) {
				for(int k = 0; k < 3; k++) {
					for(int j = 0; j < N; j++) {
						System.out.print(result[k][i][j]);
					}
					System.out.print(" ");
				}
				System.out.println();
			}
			
		}
	}
	
	static int[][] rotate(int[][] arr) {
		
		int[][] tmp = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				tmp[i][j] = arr[N-j-1][i];
			}
		}
		
		return tmp;
	}

}
