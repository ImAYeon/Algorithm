package supplement.day03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_가랏RC카_1940 {

	static int command = 0, select = 0 ;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			command = Integer.parseInt(br.readLine());
			int speed = 0, distance = 0, accel = 0;
			for(int i = 0; i < command; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				select = Integer.parseInt(st.nextToken());
				if(select == 0) {
					distance += speed;
					continue;
				}
				accel = Integer.parseInt(st.nextToken());
				if(select == 1) {
					speed += accel;
				}else if(select == 2) {
					if(speed < accel) {
						speed = 0;
						continue;
					}
					speed -= accel;
				}
				distance += speed;
			}
		
			System.out.println("#" + t + " " + distance);
		}
		
	
	}

}
