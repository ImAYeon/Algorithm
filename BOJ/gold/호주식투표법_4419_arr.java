import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 호주식투표법_4419_arr {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		String[] candi = new String[n+1]; // 후보자 이름
		for(int i = 1; i <= n; i++) {
			candi[i] = br.readLine();
		}
		
		int[][] vote = new int[1000][n];
		
		String input;
		int index = 0;
		while((input = br.readLine()) != null) {
			st = new StringTokenizer(input);
			for(int j = 0; j < n; j++) {
				vote[index][j] = Integer.parseInt(st.nextToken());
			}
//			System.out.println(Arrays.toString(vote[index]));
			index++;
		}

//		System.out.println("입력 끝");
		
		
		int[] defeat = new int[n+1]; // 탈락한 후보 구분 용도(0:살아있음, -1:탈락)
		
		
		while(true) {

			int[] num= new int[n+1]; // 후보 투표 수 // 계속 반복할 때마다 투표수 초기화
			
			// 탈락한 후보 투표 빼고 투표수 세기
			for(int i = 0; i < index; i++) {
				for(int j = 0; j < n; j++) {
					if(defeat[vote[i][j]] == -1) continue; // 투표한 사람이 탈락했다면 그 다음 순위 보기
					else {
						num[vote[i][j]]++;
						break;
					}
				}
			}
			

			// 동점인지 확인(최대와 최소가 같은경우) -> 동점일 경우 탈락하지 않은 후보 이름들 담아서 출력
			int min = Integer.MAX_VALUE;
			int max = Integer.MIN_VALUE;
			int number = 0; // 투표수가 가장 많은 후보 기록(투표수가 절반 넘을 때 어떤 후보인지 기록하기 위해, 대신 max가 두명 이상이라면 필요없음)
			for(int i = 1; i <= n ; i++) {
				if(defeat[i] == -1) continue; // 이미 패배한 사람이면 투표수 최소, 최대 계산 하지 않음
				if(max < num[i]) {
					max = num[i];
					number = i;
				}
				min = Math.min(min, num[i]);
			}
			
			if(min == max) { // 동점인 경우
				for(int i = 1; i <= n; i++) {
					if(defeat[i] != -1) System.out.println(candi[i]);
				}
				break;
			}
			
			// 투표수가 절반이 넘는 후보가 있는지 확인 (투표수가 절반이 넘었다면 두명이상이 될 수 없음)
			if(max > (index/2)){
				System.out.println(candi[number]);
				break;
			}

			// 동점x, 투표수 절반 넘는 후보x -> 최소표인 후보자들 탈락시키기
			for(int i = 1; i <= n; i++) {
				if(num[i] == min) defeat[i] = -1;
			}
			
		}
		
	}
	
}
