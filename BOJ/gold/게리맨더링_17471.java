package goldV;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_게리맨더링_17471 {

	static int N, min;
	static int[] pNum, area;
	static boolean[] visit;
	static int[][] node;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine()); // 구역의 개수
		
		pNum = new int[N+1]; // 인덱스 1부터 사용 -> 구역의 인구 (인구 차이 최솟값 찾을 때 이용)
		area = new int[N+1]; // 각 구역이 어떤 선거구에 속하는지 체크 (1, 2 두 선거구 중 한 선거구에 포함되야 한다.)
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			pNum[i] = Integer.parseInt(st.nextToken()); // 구역의 인구수 입력받기 
		}
		
		node = new int[N+1][]; // 각 구역마다 인접한 구역 입력받기 
		for(int i = 1; i <=N; i++) {
			st = new StringTokenizer(br.readLine());
			node[i] = new int[ Integer.parseInt(st.nextToken()) ];
			for(int j = 0; j < node[i].length; j++) {
				node[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		min = Integer.MAX_VALUE; // 두 선거구의 인구 차이의 최솟값을 담을 변수
		dfs(1);
		
		if(min == Integer.MAX_VALUE) System.out.println(-1); // 두 선거구로 나눌 수 없는 경우 -1 출력
		else System.out.println(min);
		
	}
	
	static void dfs(int cnt) {
		
		if(cnt == N+1) { // N개의 구역 모두 선거구를 지정했을 시에
			visit = new boolean[N+1];
			
			int areaNum = 0;
			for(int i = 1; i <= N; i++) {
				if(!visit[i]) { // 연결된 노드탐색을 두번 했는데 아직도 방문하지 않은 노드가 있다면 그건 두개지역이외에 연결되지 않은 또다른 지역이 있다는 것
					
					 // 1번 구역과 연결되어있는 노드를 모두 탐색하러 간다 (dfs - 연결되어있는 구역은 모두 방문표시가 되게 된다)
					// 1번 구역을 탐색하고 나면 1번과 연결되어있는 구역은 모두 방문표시가 될 것이고 아직 방문하지 않은 노드를 다시 탐색하러 간다
					// 그 다음 방문하지 않은 임의의 구역을 탐색하러 갔을 때 또한 연결되어있는 구역은 모두 방문처리가 된다.
					// if문을 두번 실행하면 연결되어있는 선거구를 두개 탐색하게 되는데 만약 if문에 한번더 실행된다면 아직 방문하지 않은 노드가 있다는 것이고 결국은 두개의 선거구로 나뉘지 않은것을 의미하므로 return해준다.
					check(i, area[i]);
					areaNum++;
					if(areaNum > 2) return;
				}
			}
			
			if(areaNum == 2) { // 두개의 선거구로 잘 나뉘었을 시에 두 선거구에 포함된 인구의 차이 최솟값을 찾는다.
				
				int sum1 = 0, sum2 = 0;
				for(int i = 1; i <= N; i++) {
					if(area[i] == 1) sum1 += pNum[i];
					else sum2 += pNum[i];
				}
				
				if(min > Math.abs(sum1 - sum2))
					min = Math.abs(sum1 - sum2);
			}
			return;
		}
		
		area[cnt] = 1; // area[cnt]를 선거구1에 넣는 경우
		dfs(cnt+1);

		area[cnt] = 2; // area[cnt]를 선거구 2에 넣는 경우
		dfs(cnt+1);
	}
	
	static void check(int index, int num) { // 나뉘어진 지역구들이 이어져 있는지
		visit[index] = true;
		
		for(int i = 0; i < node[index].length; i++) {
			int k = node[index][i];
			if(!visit[k] && area[k] == num)
				check(k, num);
		}
	}

}
