package silverIV;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
 * A L J C R U O
 * A L C J R U O 1초
 * A C L R J U O 2초
 * C A R L U J O 3초
 * C R A U L O J 4초
 * C R U A O L J 5초
 * C R U O A L J 6초
 */

/*
 * C B A D E F
 * C B D A E F 1초
 * C D B E A F 2초
 */

public class BOJ_개미_3048 {
	
	static int N1, N2;
	static ArrayList<Ant> arrList = new ArrayList<>();

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		N1 = Integer.parseInt(s[0]);
		N2 = Integer.parseInt(s[1]);
		
		String line = br.readLine();
		for(int i = N1-1; i >= 0; i--) {
			arrList.add(new Ant(line.charAt(i), 1));
		}
		
		line = br.readLine();
		for(int i = 0; i < N2; i++) {
			arrList.add(new Ant(line.charAt(i), 0));
		}
		
		
		int T = Integer.parseInt(br.readLine());
		
		
		for(int t = 1; t <= T; t++) { // T초동안 반복
			jump();
		}
		
		for(Ant a : arrList) {
			System.out.print(a.alpha);
		}
		
	}
	
	static void jump() {
		int i = 0;
		while(i < arrList.size() - 1) {
			Ant ant1 = arrList.get(i);
			Ant ant2 = arrList.get(i+1);
			if(ant1.dir == 1 && ant2.dir == 0) {
				arrList.set(i, ant2);
				arrList.set(i+1, ant1);
				i += 2;
			}else {
				i++;
			}
		}
	}
	
	static class Ant{
		char alpha; // 알파벳
		int dir; // 가려는 방향 : 오른쪽이면 1, 왼쪽이면 0
		Ant(char alpha, int dir){
			this.alpha = alpha;
			this.dir = dir;
		}
	}

}
