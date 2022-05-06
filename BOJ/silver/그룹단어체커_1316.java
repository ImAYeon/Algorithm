import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_그룹단어체커_1316 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int cnt = 0;
		
		for(int i = 0; i < N; i++) {
			boolean[] used = new boolean[26]; // a : 97
			String s = br.readLine();
			int flag = 1;
			for(int j = 0; j < s.length(); j++) {
				if(j != 0 && (s.charAt(j-1) == s.charAt(j))) continue;
				if(used[s.charAt(j)-97]) {
					flag = 0;
					break;
				}
				used[s.charAt(j)-97] = true;
			}
			if(flag == 1) cnt++;
		}
		
		System.out.println(cnt);
		
	}

}
