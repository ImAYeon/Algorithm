package silverV;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


/*1,3,5번째 중에 제일 큰변 찾기
 *2,4,6번째 중에 제일 큰변 찾기
 *그리고 그 두변 곱한게 큰 사각형 
 *거기에 안쪽 작은 사각형을 빼줘야 하는데 
 * 만약 큰변이 160과 50이였다
 * 160(큰가로변) 다음  세번째 나오는거
 * 50(큰세로변) 다음 네번째 나오는거
 * 
 * 생각정리만하고 못풀었는데 승현님 코드 참고 => %6을 해주기!
 */
public class BOJ_참외밭_2477 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int K = Integer.parseInt(br.readLine());
		
		int[] arr = new int[6];
		StringTokenizer st;
		
		for(int i = 0; i < 6; i++) {
			st = new StringTokenizer(br.readLine());
			Integer.parseInt(st.nextToken()); // 위치 정보
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int maxArea = Integer.MIN_VALUE;
		int minArea = Integer.MAX_VALUE;
		for(int i = 0; i < 6; i++) {
			int area =arr[i] * arr[(i+1) % 6];
			if(area > maxArea) {
				maxArea = area;
				minArea = arr[(i+3) % 6] * arr[(i+4) % 6];
			}
		}
		
		int ans = (maxArea-minArea) * K;
		System.out.println(ans);
	}

}
