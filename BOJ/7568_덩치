package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_덩치_7568 {

	static int N;
	static Bulk[] bulk;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		bulk = new Bulk[N];
		
		for(int i = 0 ;i < N; i++) {
			String[] s = br.readLine().split(" ");
			bulk[i] = new Bulk(Integer.parseInt(s[0]),Integer.parseInt(s[1]));
		}
		
		for(int i = 0; i < N; i++) {
			rank(bulk[i], i);
		}
		
		for(int i = 0; i < N-1; i++) {
			System.out.print(bulk[i].rank + " ");
		}
		System.out.print(bulk[N-1].rank);
	}
	
	static void rank(Bulk b, int o) {
		int cnt = 0;
		for(int i = 0; i < N; i++) {
			if(i == o) continue;
			if(b.height < bulk[i].height && b.weight < bulk[i].weight) {
				cnt++;
			}
		}
		b.rank = cnt+1;
	}

}

class Bulk {
	int height;
	int weight;
	int rank;
	
	Bulk(int height, int weight){
		this.height = height;
		this.weight = weight;
	}
}
