import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//silver I

public class BJ_맥주마시면서걸어가기_9205 { // *****교수님 코드

	static int T, N, V; // V : 집, 페스티벌, 편의점 모두 포함
	static int BIG = 101*32767*2; // 편의점이 100개 
	static int[][] input;
	static int[][] matrix;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			
			N = Integer.parseInt(br.readLine());
			V = N + 2;
			
			input = new int[V][2];
			matrix = new int[V][V];
			
			for(int i = 0; i < V; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < 2; j++) {
					input[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i = 0; i < V; i++) {
				int vy = input[i][0];
				int vx = input[i][1];
			
				for(int j = 0; j < V; j++) {
					if( i == j ) continue;
					int ty = input[j][0];
					int tx = input[j][1];
					int dis = Math.abs(ty-vy) + Math.abs(tx-vx);
					
					if( dis <= 1000 ) {
						matrix[i][j] = dis; // 연결 간선이 있다.
					}else {
						matrix[i][j] = BIG; // 연결 간선이 없다!! 로 생각
					}
				}
			}
			
			// 플로이드 적용
			for(int k = 0; k < V; k++) {
				for(int i = 0; i < V; i++) {
					if( k == i ) continue;  // 출발지와 경유지가 같다면 다음 출발지
					for(int j = 0; j < V; j++) {
						if( i == j || k == j ) continue;  // 경유지와 목적지가 같거나 출발지가 곧 목적지라면 패스
						matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
					}
				}
			}
			
			System.out.println( matrix[0][V-1] != 0 && matrix[0][V-1] < BIG ? "happy" : "sad" );
			
			
			
		}
		
	}
	

}
