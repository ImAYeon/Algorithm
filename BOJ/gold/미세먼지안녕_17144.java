package goldV;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 공기청정기는 윗 행, 아랫 행과 두칸이상 떨어져있다.
 */

public class BOJ_미세먼지안녕_17144 {

	static int R, C, T, cleaner;
	static int[][] map;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static Queue<int[]> queue;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		map = new int[R][C];

		queue = new LinkedList<int[]>();

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] > 0) {
					queue.offer(new int[] { i, j, map[i][j] }); // y, x, 미세먼지 양
				} else if (map[i][j] == -1 && cleaner == 0) {
					cleaner = i; // 공기청정기

				}
			}
		}

		for (int t = 0; t < T; t++) {
			// 미세먼지 확산
			spreadDust();

			// 공기청정기 작동
			airClean();

			findDust();

		}

		int sum = 2; // -1을 두번 할 거니까 미리 2를 더해놓음
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				sum += map[i][j];
			}
		}

		System.out.println(sum);
	}

	static void spreadDust() {
		int size = queue.size();
		while (size-- != 0) {
			int[] temp = queue.poll();
			int y = temp[0];
			int x = temp[1];
			int dust = temp[2];
			int dir = 4; // 확산된 방향의 갯수

			if (dust < 5)
				continue;

			for (int k = 0; k < 4; k++) {
				int ny = y + dy[k];
				int nx = x + dx[k];

				if (ny < 0 || nx < 0 || ny >= R || nx >= C || map[ny][nx] == -1) {
					dir--;
					continue;
				}

				map[ny][nx] += dust / 5;

			}

			map[y][x] -= (dust / 5) * dir;
		}
		
	}

	static void findDust() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] > 0)
					queue.offer(new int[] { i, j, map[i][j] });
			}
		}
	}
	

	static void airClean() {
		// 공기청정기 윗쪽
		int cy = cleaner - 1;
		int cx = 0;
		int cdir = 1;
		while (map[cy][cx] != -1) {
        switch (cdir) {
          case 1:
              if (cy - 1 < 0) {
                cdir = 2;
                break;
              }
              map[cy][cx] = map[cy - 1][cx];
              cy = cy - 1;
              break;
          case 2:
              if (cx + 1 >= C) {
                cdir = 3;
                break;
              }
              map[cy][cx] = map[cy][cx + 1];
              cx = cx + 1;
              break;
          case 3:
              if (cy + 1 > cleaner) {
                cdir = 4;
                break;
              }
              map[cy][cx] = map[cy + 1][cx];
              cy = cy + 1;
              break;
          case 4:
              if (cx - 1 < 1) {
                cdir = 1;
                map[cy][cx] = 0;
                cx = cx - 1;
                break;
              }
              map[cy][cx] = map[cy][cx - 1];
              cx = cx - 1;
              break;
        }
		}
		// 공기청정기 아랫쪽
		cy = cleaner + 2;
		cdir = 1;
		while (map[cy][cx] != -1) {
			switch (cdir) {
        case 1:
            if (cy + 1 >= R) {
              cdir = 2;
              break;
            }
            map[cy][cx] = map[cy + 1][cx];
            cy = cy + 1;
            break;
        case 2:
            if (cx + 1 >= C) {
              cdir = 3;
              break;
            }
            map[cy][cx] = map[cy][cx + 1];
            cx = cx + 1;
            break;
        case 3:
            if (cy - 1 < cleaner + 1) {
              cdir = 4;
              break;
            }
            map[cy][cx] = map[cy - 1][cx];
            cy = cy - 1;
            break;
        case 4:
            if (cx - 1 < 1) {
              cdir = 1;
              map[cy][cx] = 0;
              cx = cx - 1;
              break;
            }
            map[cy][cx] = map[cy][cx - 1];
            cx = cx - 1;
            break;
        }
		 }
	}

}
