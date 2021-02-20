package swea.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_규영이와인영이의카드게임_6808 {

	static int[] kyu = new int[9];
	static int[] iny = new int[9];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			int win = 0, lose = 0;
			boolean[] card = new boolean[19];
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int i = 0 ; i < 9; i++) { // 규영이가 가진 카드 배열에 삽입
				kyu[i] = Integer.parseInt(st.nextToken());
				card[kyu[i]] = true;
			}
			
			for(int i = 1, k = 0; i <= 18; i++) { // 규영이가 가진 카드를 제외한 나머지 카드 인영 배열에 삽입
				if(card[i]) continue;
				iny[k] = i;
				k++;
			}
			
			Arrays.sort(iny); // 인영이 가진 카드 배열 정렬 (np적용시키기 위해서)
		
			
			while(true) {
				int ky = 0, in = 0;
				for(int i = 0; i < 9; i++) {
					if(kyu[i] > iny[i]) ky += kyu[i] + iny[i];
					else if(kyu[i] < iny[i]) in += kyu[i] + iny[i];
				}
				
				if(ky > in) win++;
				else if(ky < in) lose++;
				
				if(!np()) break;
			}
			
			System.out.println("#" + t + " " + win + " " + lose);
		}
	}

	static boolean np() {

		// 맨 뒤에서 출발
		int i = iny.length - 1;
		
		// 뒤보다 앞이 크거나 같으면( 내림차순으로 정렬되어 있으면 ) 계속 가다가 그렇지 않으면 멈춘다.
		// 5 <-- 4 <-- 2 까지는 계속
		// 1 X 5 <-- 4 <-- 2
		while( i > 0 && iny[i-1] >= iny[i] ) --i;
		
		// 맨 앞까지 왔으면 종료
		if( i == 0 ) return false;
		
		// 현재 iny[i-1] 이 iny[i] 보다 작은 상태
		// iny[i] 이후 항목 (iny[i] 보다 작은) 과 iny[i-1]과 비교 필요
		
		// 맨 뒤에서 출발
		int j = iny.length - 1;
		// i 이전 항목 중 iny[i-1] 보다 작은 것은 무시하고, 큰 것이 있으면 멈춤 
		//  만약 큰 것이 있으면 그것과  없으면 iny[i] 와 교환
		while( iny[i-1] >= iny[j]) --j;
		swap( iny, i-1, j );
		
		// i 부터 맨 뒤까지 reverse
		int k = iny.length - 1;
		while( i < k ) {
			swap(iny, i++, k--);			
		}
		return true;
		
	}
	
	static void swap(int array[], int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

}
