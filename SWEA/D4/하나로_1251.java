package hwalgo21_서울_13반_임아연;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_하나로_1251 {
	
	
	static class Edge implements Comparable<Edge>{
		int from, to;
		double weight;
		
		public Edge(int from, int to, double weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Double.compare(this.weight,  o.weight);
		}
		
	}

	static int T, N;
	static double E;
	static int[] parents, X, Y ;
	static List<Edge> edgeList;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine()); // N == V (N이 정점의 갯수)
			
			parents = new int[N];
			X = new int[N];
			Y = new int[N];
			edgeList = new ArrayList<>();
			
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				X[i] = Integer.parseInt(st1.nextToken());
				Y[i] = Integer.parseInt(st2.nextToken());
			}
			E = Double.parseDouble(br.readLine());
			
			for(int i = 0; i < N; i++) {
				int x1 = X[i];
				int y1 = Y[i];
				for(int j = i+1; j < N; j++) {
					int x2 = X[j];
					int y2 = Y[j];
					
					double L = Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2);
					edgeList.add(new Edge(i, j, L*E));
				}
			}
			
			// 1. 간선리스트 가중치 기준 오름차순 정렬
			Collections.sort(edgeList);
			
			make();
			double result = 0; // 가중치의 합
			int count = 0; // 선택한 간선수
			
			for(Edge edge : edgeList) {
				if(union(edge.from, edge.to)) { // union이 true이면 다른 집합이고 간선을 선택한다는 의미
					result += edge.weight;
					if(++count == N-1) break;
				}
			}
		
			
			System.out.println("#" + t + " " + Math.round(result));
		}
	}
	
	
	static void make() {
		for(int i = 0; i < N; i++) {
			parents[i] = i;
		}
	}
	
	static int findSet(int a) {
		if(parents[a] == a) return a;
		
		return parents[a] = findSet(parents[a]);
	}
	
	static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if(aRoot == bRoot) return false;
		parents[bRoot] = aRoot;
		return true;
	}

}
