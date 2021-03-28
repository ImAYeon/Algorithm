package silverV;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_좌표정렬하기_11650 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		Point[] arr = new Point[N];
		
		for(int i = 0; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(arr);
		
		for(Point p : arr) {
			System.out.println(p.x + " " + p.y);
		}
	}

}

class Point implements Comparable<Point>{
	int x;
	int y;
	
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}

	@Override
	public int compareTo(Point p) {
		if(this.x == p.x) return this.y - p.y;
		else return this.x - p.x;
	}
}
