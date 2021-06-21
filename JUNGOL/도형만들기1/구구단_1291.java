package 도형만들기1;

import java.util.Scanner;

public class JUNGOL_구구단_1291 {

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		
		int s, e;
		
		while(true) {
			s = sc.nextInt();
			e = sc.nextInt();
			
			if(s < 2 || e > 9 || s > 9 || e < 2) {
				System.out.println("INPUT ERROR!");
				continue;
			}
			else {
				break;
			}
		}
		
		
		if(s <= e) {
			for(int i = 1; i <= 9; i++) {
				for(int j = s; j <= e; j++) {
					System.out.printf("%d * %d = %2d", j, i, j*i);
					System.out.print("   ");
				}
				System.out.println();
			}
		}
		else { // s > e
			for(int i = 1; i <= 9; i++) {
				for(int j = s; j >= e; j--) {
					System.out.printf("%d * %d = %2d", j, i, j*i);
					System.out.print("   ");
				}
				System.out.println();
			}
		}
		
		
	}

}
