package d2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class SWEA_조교의성적매기기_1983 {
	
	static String[] grade = {"A+","A0","A-","B+","B0","B-","C+","C0","C-","D0"};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int TC = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= TC; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			ArrayList<Double> student = new ArrayList<>();
			double k_score = 0;
			for(int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				int mid = Integer.parseInt(st.nextToken());
				int fin = Integer.parseInt(st.nextToken());
				int assign = Integer.parseInt(st.nextToken());
				
				double sum = mid * 0.35 + fin * 0.45 + assign * 0.2;
				student.add(sum);
				if(i == K) k_score = sum;
			}
			
			Collections.sort(student, Collections.reverseOrder());
			
			System.out.println("#" + tc + " " + grade[ student.indexOf(k_score)/(N/10) ] );
		}

	}
	
}
