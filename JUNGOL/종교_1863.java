import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JUNGOL_종교_1863 {

	static int N, M, a, b;
	static int[] parents;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		parents = new int[N+1];
		
		for(int i = 1; i <= N; i++) { // make 과정
			parents[i] = i;
		}
		
		
		for(int i = 0; i < M; i++){
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			union(a, b);
		}
		
		int cnt = 0;
		for(int i = 1; i <= N; i++) {
			if(parents[i] == i) cnt++;
		}
		
		System.out.println(cnt);
		
	}
	
	static int findSet(int a) {
		if(parents[a] == a) return a;
		
		return parents[a] = findSet(parents[a]);
	}
	
	static void union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		
		if(aRoot == bRoot) return; // 같은 집합은 못합침
		
		parents[bRoot] = aRoot;
	}

}
