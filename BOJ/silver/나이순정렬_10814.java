package silverV;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_나이순정렬_10814 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		Member[] mem = new Member[N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			mem[i] = new Member(Integer.parseInt(st.nextToken()), st.nextToken());
		}
		
//		Arrays.sort(mem, new Comparator<Member>() {
//
//			@Override
//			public int compare(Member o1, Member o2) {
//				return o1.age - o2.age;
//			}
//			
//		});
		
//		Arrays.sort(mem, (o1, o2)->{return o1.age-o2.age;});
		
		Arrays.sort(mem, (o1, o2) -> o1.age-o2.age);
		
		for(Member m : mem) {
			System.out.println(m.age + " " + m.name);
		}
	}
	
	public static class Member{
		int age;
		String name;
		
		public Member(int age, String name) {
			this.age = age;
			this.name = name;
		}
	}

}
