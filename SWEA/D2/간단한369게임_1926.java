import java.util.Scanner;

public class SWEA_간단한369게임_1926 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int N = sc.nextInt();
		
		int cnt = 0;
		for(int i = 1; i <= N; i++) {
			cnt = 0;
			int num = i;
			while(true) {
				if(num % 10 == 3 || num % 10 == 6 || num % 10 == 9) cnt++;
				if(num / 10 == 0) break;
				num /= 10;
			}
			if(cnt > 0) {
				for(int k = 0; k < cnt; k++) sb.append('-');
			}else {
				sb.append(i);
			}
			sb.append(' ');
		}
		
		System.out.println(sb.toString());
		
	}

}
