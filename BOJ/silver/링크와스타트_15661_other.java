// asdf0185님 코드 (백준)
// 기저조건에서 모두 visited인것 따로, 모두 !visited인것 따로 계산 바로 해줌

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N, result = Integer.MAX_VALUE;
	static int[][] arr;
	static boolean[] visited;

	public static void ability(int count) {
		if (count == N) {
			int first = 0, second = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (visited[i] && visited[j])
						first += arr[i][j];
					else if (!visited[i] && !visited[j])
						second += arr[i][j];
				}
			}
			result = Math.min(result, Math.abs(first - second));
			return;
		}

		ability(count + 1);
		visited[count] = true;
		ability(count + 1);
		visited[count] = false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(input[j]);
			}
		}
		visited = new boolean[N];

		ability(0);
		System.out.println(result);
	}
}
