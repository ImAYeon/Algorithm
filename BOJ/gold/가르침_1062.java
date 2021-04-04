package goldIV;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * "anta" ~~ "tica"
 * a, c, i, n, t 5개의 글자는 무조건 배워야 함
 */

public class BOJ_가르침_1062 {

	static int N, K, ans;
	static String[] word;
	static boolean[] checked = new boolean[26];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		if (K < 5) {
			System.out.println(0);
			System.exit(0);
		} else if (K == 26) { // K는 0 또는 26보다 작거나 같은 자연수
			// k가 26이면 단어들 모두 배울 수 있다는 뜻
			System.out.println(N); // 단어의 갯수만큼 출력
			System.exit(0);
		}

		word = new String[N];

		// antarctica
		// -> rc만 추출
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			word[i] = input.substring(4, input.length() - 4);
		}

		checked['a' - 'a'] = true;
		checked['c' - 'a'] = true;
		checked['i' - 'a'] = true;
		checked['n' - 'a'] = true;
		checked['t' - 'a'] = true;

		dfs(0, 0);
		System.out.println(ans);

	}

	static void dfs(int srcIdx, int cnt) {
		if (cnt == K - 5) {
			int count = 0;
			for (int i = 0; i < N; i++) {
				boolean possible = true;

				for (int index = 0; index < word[i].length(); index++) {
					if (!checked[word[i].charAt(index) - 'a']) {
						possible = false;
						break;
					}
				}

				if (possible) {
					count++;
				}
			}

			ans = Math.max(ans, count);
			return;
		}

		for (int i = srcIdx; i < 26; i++) {
			if (checked[i])
				continue;
			checked[i] = true;
			dfs(i, cnt + 1);
			checked[i] = false;
		}

	}

}
