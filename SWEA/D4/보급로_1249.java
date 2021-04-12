package d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
 
public class SWEA_보급로_1249 {
     
    static int T, N;
    static int[][] map, dist;
    static boolean[][] visit;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
     
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            dist = new int[N][N];
            visit = new boolean[N][N];
             
            String s;
            for(int i = 0; i < N; i++) {
                s = br.readLine();
                for(int j = 0; j < N; j++) {
                    map[i][j] = s.charAt(j) - '0';
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }
             
             
            Queue<int[]> queue = new LinkedList<int[]>();
            queue.offer(new int[] {0, 0});
            visit[0][0] = true;
            dist[0][0] = 0;
             
            while(!queue.isEmpty()) {
                int[] temp = queue.poll();
                int y = temp[0];
                int x = temp[1];
                 
                for(int k = 0; k < 4; k++) {
                    int ny = y + dy[k];
                    int nx = x + dx[k];
                     
                    if(ny < 0 || nx < 0 || ny >= N || nx >= N) continue;
                     
                    if(!visit[ny][nx] || dist[ny][nx] > dist[y][x] + map[ny][nx]) {
                        if(!visit[ny][nx]) visit[ny][nx] = true;
                        dist[ny][nx] = dist[y][x] + map[ny][nx];
                        queue.offer(new int[] {ny, nx});
                    }
                }
                 
            }
             
            System.out.println("#" + t + " " + dist[N-1][N-1]);
        }
         
    }
 
}
