package swea.d5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 그 전에 최솟값보다 커지면 더이상 안해두됨
// 만약 이동거리가 최대거리를 찾는거라면 가지치기 불가능

public class SWEA_최적경로_1247 {

	static int N, min;
	static boolean[] isSelected;
	static int[] company = new int[2];
	static int[] house = new int[2];
	static Customer[] c;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			
			min = Integer.MAX_VALUE;
			
			N = Integer.parseInt(br.readLine()); // 고객의 수
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			company[0] = Integer.parseInt(st.nextToken());
			company[1] = Integer.parseInt(st.nextToken());
			house[0] = Integer.parseInt(st.nextToken());
			house[1] = Integer.parseInt(st.nextToken());
			c = new Customer[N];
			isSelected = new boolean[N];
			
			for(int i = 0; i < N; i++) {
				c[i] = new Customer(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			}
			
			permutation(0, company[0], company[1], 0); // 그 전의 위치 x, y값-> 회사위치 알려주면 됨
			
			System.out.println("#" + t + " " + min);
		}
	}
	
	private static void permutation(int cnt, int px, int py, int sum) {
		
		if(cnt == N) {
			//집과의 거리 계산
			sum += Math.abs(house[0] - px) + Math.abs(house[1] - py);
			min = Math.min(min, sum);
		}
		
		if(sum > min) return;
		
		for(int i = 0; i < N; i++) { // input 배열 인덱스
			if(isSelected[i]) continue;
			
			isSelected[i] = true;
			permutation(cnt+1, c[i].x, c[i].y, sum + Math.abs(px - c[i].x) + Math.abs(py - c[i].y));
			isSelected[i] = false;
			
		}
	}
}

class Customer{
	int x;
	int y;
	Customer(int x, int y){
		this.x = x;
		this.y = y;
	}
}
