package d2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA_파스칼의삼각형_2005 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= TC; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[][] arr = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j <= i; j++) {
					if(j == 0 || i == j) arr[i][j] = 1;
					else arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
				}
			}
			
			System.out.println("#" + tc );
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j <= i; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
			
			
		}

	}

}
