package silverV;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_종이자르기_2628 {
	
	static ArrayList<Integer> row, col;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		row = new ArrayList<Integer>();
		col = new ArrayList<Integer>();
		
		col.add(0);
		col.add(Integer.parseInt(st.nextToken())); //가로 부분
		row.add(0);
		row.add(Integer.parseInt(st.nextToken())); //세로 부분
		
		int n = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			if(Integer.parseInt(st.nextToken()) == 0) { // 가로로 자르는 점선(세로)
				row.add(Integer.parseInt(st.nextToken()));				
			}else { // 세로로 자르는 점선(가로)
				col.add(Integer.parseInt(st.nextToken()));
			}
		}
		
		Collections.sort(row);
		Collections.sort(col);
		
		ArrayList<Integer> resultR = new ArrayList<Integer>();
		ArrayList<Integer> resultC = new ArrayList<Integer>();
		
		// ex 가로(col) : 0 4 10 , 세로(row) : 0 2 3 8
		
		for(int i = 1; i < row.size(); i++) {
			resultR.add(row.get(i) - row.get(i-1));
		}
		for(int i = 1; i < col.size(); i++) {
			resultC.add(col.get(i) - col.get(i-1));
		}

		Collections.sort(resultR);
		Collections.sort(resultC);
		
		System.out.println(resultR.get(resultR.size()-1) * resultC.get(resultC.size()-1));
		
	}

}
