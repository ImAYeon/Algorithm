package silverI;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

// N = 9;
//*********
//* ** ** *
//*********
//***   ***
//* *   * *
//***   ***
//*********
//* ** ** *
//*********

public class BOJ_별찍기10_2447 {

	static char[][] arr;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		arr = new char[N][N];
		
		for(int i = 0; i < arr.length; i++) {
			Arrays.fill(arr[i], ' ');
		}
		
		
		printStar(0,0,N);
		
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	
	static void printStar(int x, int y, int n) {
		if(n == 1) {
			arr[y][x] ='*';
			return;
		}
		
		int t = n/3;
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(i == 1 && j == 1) continue;
				printStar(x+(t*j),y+(t*i),t);
			}
		}
	}

}
