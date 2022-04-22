package 백준알고리즘;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 수학은비대면강의입니다_19532 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		int f = Integer.parseInt(st.nextToken());
		int x= 0, y = 0;
		
		// ax + by = c
		// dx + ey = f
		
		//   (a*d)x + (b*d)y = (c*d)
		// - (a*d)x + (e*a)y = (f*a)
		// = (b*d)y - (e*a)y = (c*d) - (f*a)
		// y = (c*d)-(f*a) / (b*d)-(e*a)
		// x = 
		
		if(a == 0) {
			y = c / b;
			x = (f-e*y)/d;
		}else if(b == 0) {
			x = c/a;
			y = (f-d*x)/e;
		}else if(d == 0) {
			y = f/e;
			x = (c-b*y)/a;
		}else if(e == 0) {
			x = f/d;
			y = (c-a*x)/b;
		}else {
			y = ((c*d) - (f*a)) / ((b*d) - (e*a));
			x = ((c*d) - (b*d)*y) / (a*d);
		}
		
		
		System.out.println(x + " " + y);
	}

}
