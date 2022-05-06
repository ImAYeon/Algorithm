import java.util.Scanner;

public class 바이러스 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long K = sc.nextInt(); // 바이러스 수
		long P = sc.nextInt(); // 증가율
		int N = sc.nextInt(); // 총 시간
		
		for(int i = 0; i < N; i++) {
			K = ((K%1000000007)*(P%1000000007))%1000000007;
		}
		
		System.out.println(K);
		
	}

}
