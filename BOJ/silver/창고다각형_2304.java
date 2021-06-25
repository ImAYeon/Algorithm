package silverII;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_창고다각형_2304 {
	
	// 가장 최고 높이의 기둥을 찾는다.
	// 최고 높이의 기둥 왼쪽은 자신기둥보다 높은기둥이 나오기전까지 자신의 기둥 높이를 기준으로 면적을 계산한다.
	// 최고 높이의 기둥 오른쪽으로는 자신보다 왼쪽에 더 높은 기둥이 나오기 전까지 자신의 높이를 기준으로 면적을 계산한다.
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		ArrayList<int[]> arrList = new ArrayList<int[]>();
		
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arrList.add(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
		}
		
//		Collections.sort(arrList, new Comparator<int[]>() {
//
//			@Override
//			public int compare(int[] o1, int[] o2) {
//				return o1[0] - o2[0];
//			}
//			
//		});
		
		Collections.sort(arrList, (o1,o2) -> o1[0]-o2[0]);
		
		int max = arrList.get(0)[1];
		int idxMax = 0;
		for(int i = 1; i < N; i++) {
			if(max <= arrList.get(i)[1]) { // 여기서 =을 넣는 이유는 같은 높이인 경우 인덱스를 뒤에 있는걸로 저장하기 위해
				max = Math.max(max, arrList.get(i)[1]);
				idxMax = i;
			}
		}
		
		int sum = 0;
		
		int prevX = arrList.get(0)[0];
		int prevY = arrList.get(0)[1];
		
		// 제일 높은 기둥 왼쪽 면적
		for(int i = 1; i <= idxMax; i++) {
			if(prevY <= arrList.get(i)[1]) {
				sum += prevY * (arrList.get(i)[0] - prevX);
				
				prevX = arrList.get(i)[0];
				prevY = arrList.get(i)[1];
			}
		}
		sum += max; // 제일 높은 기둥 면적
		
		if(idxMax != N-1) { // 마지막 기둥이 제일 높은 기둥이 아닌 경우
			prevX = arrList.get(N-1)[0];
			prevY = arrList.get(N-1)[1];
			for(int i = N-2; i >= idxMax; i--) {
				if(prevY <= arrList.get(i)[1]) {
					sum += prevY * (prevX - arrList.get(i)[0]);
					
					prevX = arrList.get(i)[0];
					prevY = arrList.get(i)[1];
				}
			}
		}
		
		System.out.println(sum);
	}

}
