import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_로또_6603 {
	
	static int[] src;
	static int[] tgt = new int[6];
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			if(k == 0) break;
			
			src = new int[k];
			
			
			for (int i = 0; i < k; i++) {
				src[i] = Integer.parseInt(st.nextToken());
			}
			
			comb(0,0);
			System.out.println();
		}

	}
	
	static void comb(int srcIdx, int tgtIdx) {
		
		if(tgtIdx == tgt.length) {
			for(int i = 0 ; i < 6; i++) {
				System.out.print(tgt[i] + " ");
			}
			System.out.println();
			return;
		}
		
		
		for(int i = srcIdx; i < src.length; i++) {
			tgt[tgtIdx] = src[i];
			comb(i+1, tgtIdx+1);
		}
		
		
	}

}
