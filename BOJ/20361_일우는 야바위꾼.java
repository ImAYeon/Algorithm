package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_일우는야바위꾼_20361 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken()); 
		int K = Integer.parseInt(st.nextToken()); 

		for (int i = 0; i < K; i++) { 
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			if (A == X) { 
				X = B; 
			} else if (B == X) { 
				X = A; 
			}
		}

		System.out.print(X);
	}
}
