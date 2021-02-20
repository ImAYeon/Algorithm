package supplement.day05;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA_수의새로운연산풀기_1493 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		
		Location[] arr = new Location[1000001];
		
		int i = 1, y = 1;
		while(i < arr.length) {
			for(int x = 1, k = y; x <= y; x++, k--) {
				if(i >= arr.length) break;
				arr[i] = new Location(x,k); 
				i++;
			}
			y++;
		}
		
		for(int t = 1; t <= T; t++) {
			int ans = 0;
			
			String[] s = br.readLine().split(" ");
			int x1 = arr[Integer.parseInt(s[0])].x + arr[Integer.parseInt(s[1])].x;
			int y1 = arr[Integer.parseInt(s[0])].y + arr[Integer.parseInt(s[1])].y;
			System.out.println("x1 = " + x1 + ", y1 = " + y1);
			
			for(int j = 1; j < arr.length; j++) {
				System.out.println(arr[j]);
				if(arr[j].x == x1 && arr[j].y == y1) {
					ans = j;
					break;
				}
			}
			
			
			System.out.println("#" + t + " " + ans);
		}
		
	}

}

class Location{
	int x;
	int y;
	
	Location(int x, int y){
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "Location [x=" + x + ", y=" + y + "]";
	}
	
}
