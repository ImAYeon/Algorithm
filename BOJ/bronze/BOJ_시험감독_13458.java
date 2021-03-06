package bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_시험감독_13458 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); // 시험장의 갯수

		int[] room = new int[N]; // 시험장에 있는 응시자 수

		String[] s = br.readLine().split(" ");
		String[] input = br.readLine().split(" ");
		int B = Integer.parseInt(input[0]); // 총감독관이 감시할 수 있는 응시자 수
		int C = Integer.parseInt(input[1]); // 부감독관이 감시할 수 있는 응시자 수
		
		long num = 0; // 감독관 수 => 입력범위 잘보자!!!!! int 범위 넘어감!!!
		
		for (int i = 0; i < N; i++) {
			room[i] = Integer.parseInt(s[i]);
			if(room[i] > 0) {
				room[i] -= B;			
				num++;
			}
		}
		
		for(int i = 0; i < N; i++) {
			if(room[i] <= 0) continue;
			if(room[i] % C == 0) num += room[i] / C;
			else num += room[i] / C + 1;
		}
		
		System.out.println(num);
		
		
	}

}
