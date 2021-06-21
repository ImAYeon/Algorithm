package 수학1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class JUNGOL_곱셈_1692 {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		
		int e = a * (b / 100);
		
		b %= 100;
		
		int d = a * (b / 10);
		
		b %= 10;
		
		int c = a * b;
		
		System.out.println(c + "\n" +  d + "\n" + e + "\n" + (c+10*d+100*e));
	}
	
}

/*
 * System.out.println(input1 * (input2 % 10));
 * System.out.println(input1 * (input2 % 100 / 10));
 * System.out.println(input1 * (input2 / 100));
 * System.out.println(input1 * input2);
 */

