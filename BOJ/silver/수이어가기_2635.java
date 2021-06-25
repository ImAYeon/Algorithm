package silverV;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_수이어가기_2635 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int max = 0;
		ArrayList<Integer> arrList = null;
		
		for(int i = N; i >= 0; i--) {
			int one = N, two = i, three = one - two;
			int cnt = 3;
			while(true) {
				one = two;
				two = three;
				three = one - two;
				if(three < 0) break;
				cnt++;
			}
			if(max < cnt) {
				max = cnt;
				one = N;
				two = i;
				three = one - two;
				arrList = new ArrayList<Integer>();
				arrList.add(one);
				arrList.add(two);
				arrList.add(three);
				while(true) {
					one = two;
					two = three;
					three = one - two;
					if(three < 0) break;
					arrList.add(three);
				}
			}
		}
		System.out.println(max);
		for(int num : arrList) System.out.print(num + " ");
		
	}

}
