package silverI;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2667_단지번호붙이기 {
	
	static int[] dx = {0, 0, -1, 1}; // 상 하 좌 우
	static int[] dy = {-1, 1, 0, 0};

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 지도의 크기
		
		int[][] map = new int[N][N];
		
		// 지도 입력받는 부분
		for(int i = 0; i < N; i++) {
			String s = br.readLine();
			for(int j = 0; j < N ;j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		
		Queue<int[]> queue = new LinkedList<>(); // BFS로 풀 것이므로 queue 선언
		int cnt = 0, n = 0; // 총 단지수 n, 단지내 집의 수를 셀 변수 cnt
		ArrayList<Integer> arrList = new ArrayList<>(); // 단지내 집의 수를 BFS를 돌 때마다 세서 기억해야 하므로 크기를 알 수 없기 때문에 배열 x, ArrayList
		
		// for문을 돌면서 집이 있는 곳을 찾으면 그 근처에 있는 집을 모두 bfs로 찾아낸다 
		// -> 집이 있는 곳을 지날 때 0으로 바꿔줌으로써 단지내 집을 모두 찾고 다음 단지를 찾으러 갈 때 재방문하지 않게 한다.
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) { 
				if(map[i][j] == 0) continue; // 집이 아닌곳은 건너 뛰기
				
				queue.offer(new int[] {i, j}); // 집을 찾은 경우이므로 queue에 넣어준다. (그 근처 집을 찾기 위해)
				map[i][j] = 0; // 방금 queue에 넣은 집의 위치를 0으로 바꿔주지 않으면 다시 재방문하게 되므로 꼭 0으로 초기화 시켜줘야 한다.
				
				cnt = 0; // 단지 내 집의 수를 셀 변수 초기화
				while(!queue.isEmpty()) { // 이어져있는 집들을 차례로 queue에 집어넣고 빼면서 찾아내는 과정
					int[] loc = queue.poll(); // queue에서 빼내서 집의 위치를 x,y변수에 넣어준다.
					cnt++;
					int y = loc[0];
					int x = loc[1];
					
					for(int k = 0; k < 4; k++) { // 방금 queue에서 빼낸 집의 상,하,좌,우에 집이 있으면 queue에 대입해준다.
						int ny = y + dy[k];
						int nx = x + dx[k];
						
						if(ny < 0 || nx < 0 || ny >= N || nx >= N || map[ny][nx] == 0) continue;
						
						queue.offer(new int[] {ny, nx});
						map[ny][nx] = 0; // 집을 방문했으면 잊지않고 0으로 바꿔준다.
					}
					
				}
				
				queue.clear(); // 다음 단지를 찾으러 가기 전에 queue 초기화
				arrList.add(cnt); // 단지 내 집의 수를 ArrayList에 대입해준다.
				n++; // 단지 갯수 세기
			}
		}
		
		Collections.sort(arrList); // 출력할 때 단지 내 집의 수를 오름차순으로 정렬하여 출력하라고 하였음
		
		System.out.println(n);
		for(int a : arrList) {
			System.out.println(a);
		}
		
	}

}
