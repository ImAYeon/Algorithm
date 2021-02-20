package bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_달팽이는올라가고싶다_2869 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		
		double A = Integer.parseInt(s[0]);
		double B = Integer.parseInt(s[1]);
		double V = Integer.parseInt(s[2]);
		
		
		int cal = (int)Math.ceil((V-A) / (A-B)); // 올림
		System.out.println(1+cal); // 일단 먼저 한번 올라간다음-day 1부터 시작, 내려가고 올라간걸 하루로 같이 계산해줌
		
	}

}
