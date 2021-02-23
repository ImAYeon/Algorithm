import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JUNGOL_오류교정_1037 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		int[][] arr = new int[n + 1][n + 1];

		int sum = 0;
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				sum += arr[i][j];
			}
		}

		int col = 0, row = 0;

		int cnt1 = 0, cnt2 = 0;
		boolean check;
		for (int i = 1; i <= n; i++) {
			check = true;
			for (int j = 1; j <= n; j++) {
				if (arr[i][j] == 1)
					check = !check;
			}
			if (!check) {
				row = i;
				cnt1++;
			}
		}
		check = true;
		for (int j = 1; j <= n; j++) {
			check = true;
			for (int i = 1; i <= n; i++) {
				if (arr[i][j] == 1)
					check = !check;
			}
			if (!check) {
				col = j;
				cnt2++;
			}
		}
		if(cnt1 == 0 && cnt2 == 0) sb.append("OK");
		else if (cnt1 == 1 && cnt2 == 1)
			sb.append("Change bit (" + row + "," + col + ")");
		else
			sb.append("Corrupt");

		System.out.println(sb.toString());

	}

}
