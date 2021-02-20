package boj.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_도영이가만든맛있는음식_2961 {

	static Food[] input;
	static boolean[] select;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		input = new Food[N];
		select = new boolean[input.length];
		
		for(int i = 0; i < N; i++) {
			String[] s = br.readLine().split(" ");
			input[i] = new Food(Integer.parseInt(s[0]),Integer.parseInt(s[1]));
		}
		
		subset(0);
		
		System.out.println(min);
		
	}
	static void subset(int srcIdx) {
		// 기저조건
		
		if ( srcIdx == input.length ) {
			// 그 시점에 완성된 select 결과 도출
			calc();
			return;
		}
		
		select[srcIdx] = true;
		subset(srcIdx + 1);
		
		select[srcIdx] = false;
		subset(srcIdx + 1);
		
	}
	
	static void calc() {
		int flag = 0;
		int s = 1, b = 0;
		
		for( int i = 0; i < select.length; i++) {
			if(select[i]) {
				flag=1;
				s *= input[i].sour;
				b += input[i].bit;
			}
		}
		if(flag == 0) return; // 모두 선택하지 않을 경우 그냥 return;
		min = Math.min(min, Math.abs(s - b));
	}

}

class Food{
	int sour;
	int bit;
	
	Food(int sour, int bit){
		this.sour = sour;
		this.bit = bit;
	}

	

}
