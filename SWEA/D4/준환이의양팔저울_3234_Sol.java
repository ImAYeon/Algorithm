package swea.d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 순열 기본틀 잡아서 
// 기저조건에서 왼쪽 오른쪽 무게 계산 해서 count계산 


public class SWEA_준환이의양팔저울_3234_Sol {

	static int T, N, ans;
	static int[] src;
	static boolean[] select;
	
	//미리계산
	static int[] facto;
	static int[] pow;
	static int total; // 총무게
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <=T; t++) {
			
			N = Integer.parseInt(br.readLine());
			src = new int[N];
			select = new boolean[N];
			
			facto = new int[N+1];
			pow = new int[N+1];
			facto[0] = facto[1] = pow[0] = 1;
			
			total = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				src[i] = Integer.parseInt(st.nextToken());
				facto[i+1] = facto[i]*(i+1);
				pow[i+1] = pow[i] *2;
				total += src[i];
			}
			
			ans = 0;
			
			perm(0, 0, 0, total);
			
			System.out.println("#" + t + " " + ans);
		}
		
	}
	
	// totalRemain : 남은 추의 무게
	static void perm(int tgtIdx, int leftSum, int rightSum, int totalRemain) {
		
		if( totalRemain + rightSum  <= leftSum ) { // 남아있는 추를 모두 오른쪽에 둔다고 하더라도 그 합이 왼쪽저울에 있는 추의 합보다 작다면 그 뒤로는 계속 perm돌면서 하나하나 두지 않고 계산해버리면 됨
			// 남은 개수 : N - tgtIdx ==> 3개 남았다. pow[3]*facto[3]
			ans += pow[N-tgtIdx] * facto[N-tgtIdx];
			return;
		}
		
		// 기저 조건
		if(tgtIdx == N) {
			ans++;
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if (select[i]) continue;
			
			select[i] = true; // 방금 선택 해당 인덱스에 대한 걸 오른쪽에 한번 태우고, 왼쪽에 한번 태우고
			
			perm(tgtIdx+1, leftSum + src[i], rightSum, totalRemain-src[i] ); // 왼쪽 추에 담는 경우
			if( leftSum >= rightSum + src[i]) {
				perm(tgtIdx+1, leftSum, rightSum + src[i], totalRemain-src[i]); // 오른쪽 추에 담는 경우
			}
			select[i] = false;
		}
	}

}
