package silverII;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_회의실배정_1931 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		Meeting[] meetings = new Meeting[N];
		
		String[] s;
		for(int i = 0; i < N; i++) {
			s = br.readLine().split(" ");
			meetings[i] = new Meeting(Integer.parseInt(s[0]), Integer.parseInt(s[1]));
		}
		
		Arrays.sort(meetings);
		
		int ans = 0;
		int current = 0;
		for(int i = 0; i < N; i++) {
			if(meetings[i].start >= current) {
				ans++;
				current = meetings[i].end;
			}
		}
		
		System.out.println(ans);
	}

}

class Meeting implements Comparable<Meeting>{
	int start;
	int end;
	Meeting(int start, int end){
		this.start = start;
		this.end = end;
	}
	
	@Override
	public int compareTo(Meeting o) {
		int diff = this.end - o.end;
		return diff != 0 ? diff: this.start - o.start;
	}
}
