package swea;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_1208 {
	static int[] box = new int[100];
	static int result = 0;
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int t = 1; t <= 10; t++) {
			int dump = sc. nextInt();
			for(int i =0; i < 100; i++) {
				box[i] = sc.nextInt();
			}
			Arrays.sort(box);
			for(int i = 0; i < dump; i++) {
				if(box[99] - box[0] <= 1) break;
				box[0]++;
				box[99]--;
				Arrays.sort(box);
			}
			
			
			result = box[99] - box[0];
			
			
			System.out.println("#" + t + " " + result);
		}
	}
}
