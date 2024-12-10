import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    static int[][] map;
    static int minDist;
    static final int INF = 1999999999;

    public static void solve() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        boolean visit[][][] = new boolean[N][M][2]; //N, M, breakCnt

        for(int i = 0; i  < N; ++i) {
            String ln = br.readLine();
            for(int j = 0; j < M; ++j) {
                map[i][j] = ln.charAt(j) - '0';
            }
        }


        minDist = INF;
        //BFS
        int[] dy = {-1,1,0,0};
        int[] dx = {0,0,-1,1};
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{0,0,1}); //y,x,부수기가능
        int curDist = 1;
        while(!q.isEmpty()) {
            int popCnt = q.size();
            for(int p = 0; p < popCnt; ++p) {
                int[] cur = q.poll();
                int cy = cur[0];
                int cx = cur[1];
                int breakCnt = cur[2];

                if(cy == N-1 && cx == M-1) {
                    minDist = Math.min(minDist, curDist);
                }

                for(int dir = 0; dir < 4; ++dir) {
                    int ny = cy + dy[dir];
                    int nx = cx + dx[dir];

                    if(ny < 0 || nx < 0 || ny >= N || nx >= M) {
                        continue;
                    }

                    if(!visit[ny][nx][0] && map[ny][nx] == 1 && breakCnt == 1) {
                        q.add(new int[]{ny, nx, 0});
                        visit[ny][nx][0] = true;
                    }

                    if(!visit[ny][nx][breakCnt] && map[ny][nx] == 0) {
                        q.add(new int[]{ny, nx, breakCnt});
                        visit[ny][nx][breakCnt] = true;
                    }
                }
            }
            curDist++;
        }

        if(minDist == INF) {
            minDist = -1;
        }

        System.out.println(minDist);
    }



    public static void main(String[] args) throws IOException {
        solve();
    }
}

