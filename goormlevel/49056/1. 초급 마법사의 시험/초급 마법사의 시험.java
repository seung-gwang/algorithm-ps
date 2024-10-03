import java.io.*;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

class Main {
	public static int[][] map = new int[101][101];
	public static int[] dy = {-1,1,0,0};
	public static int[] dx = {0,0,-1,1}; //상하좌우
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		boolean[][][] visited = new boolean[101][101][101]; //R C K
		
		for(int i = 1; i <= R; ++i) {
			String line = br.readLine();
			for(int j = 0; j < line.length(); ++j) {
				int r = i;
				int c = j + 1;
				map[r][c] = line.charAt(j) - '0';
			}
		}
		
		Queue<int[]> q = new LinkedList<>();
		
		q.add(new int[]{1,1, K}); //시작점 (1,1, 최초 마력)
		visited[1][1][K] = true;
		
		int dist = 0;
		int mp = K;
		while(!q.isEmpty()) {
			int popCnt = q.size();
			
			for(int p = 0; p < popCnt; ++p) {
				int[] cur = q.poll();
				int cy = cur[0];
				int cx = cur[1];
				int cm = cur[2];
				
				if(cy == R && cx == C) {
					System.out.println(dist);
					return;
				}
				
				for(int dir = 0; dir < 4; ++dir) {
					int ny = cy + dy[dir];
					int nx = cx + dx[dir];
					
					int nny = ny + dy[dir];
					int nnx = nx + dx[dir];

					if(ny < 1 || nx < 1 || ny > R || nx > C) {
						continue;
					}

					if(visited[ny][nx][cm]) {
						continue;
					}

					if(map[ny][nx] == 0) {
						q.add(new int[]{ny, nx, cm});
						visited[ny][nx][cm] = true;
						continue;
					}
					
					if(nny < 1 || nnx < 1 || nny > R || nnx > C) {
						continue;
					}
					
					if(map[nny][nnx] == 1) {
						continue;
					}
					
					if(cm < 10) {
						continue;
					}
					
					int nm = cm -10;
					if(visited[nny][nnx][nm]) {
						continue;
					}
					
					q.add(new int[]{nny, nnx, nm});
					visited[nny][nnx][nm] = true;
				}
			}
			dist++;
		}
		
		System.out.println(-1);
	}
}