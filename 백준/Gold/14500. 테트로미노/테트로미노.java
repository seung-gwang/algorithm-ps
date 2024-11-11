import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


public class Main {
    static int N;
    static int M;
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static int[][] board;
    static boolean[][] visit;
    static int maxSum;
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};

    public static void dfs(int cy, int cx, int depth, int sum) {
        int curSum = sum + board[cy][cx];

        if(depth == 3) {
            maxSum = Math.max(curSum, maxSum);
            return;
        }

        for(int dir = 0; dir < 4; ++dir) {
            int ny = cy + dy[dir];
            int nx = cx + dx[dir];

            if(ny >= N || ny < 0 || nx >= M || nx < 0) {continue;}
            if(visit[ny][nx]) {continue;}

            visit[ny][nx] = true;
            dfs(ny, nx, depth+1, curSum);
            visit[ny][nx] = false;
        }


    }

    public static void solve() throws IOException {
        maxSum = -1;
        String[] nm = bf.readLine().split(" ");
        N = Integer.valueOf(nm[0]);
        M = Integer.valueOf(nm[1]);
        board = new int[N][M];
        visit = new boolean[N][M];

        for(int i = 0; i < N; ++i) {
            String[] row = bf.readLine().split(" ");
            for(int j = 0; j < M; ++j) {
                board[i][j] = Integer.parseInt(row[j]);
                visit[i][j] = false;
            }
        }

        for(int i = 0; i < N; ++i) {
            for(int j = 0; j < M; ++j) {
                visit[i][j] = true;
                dfs(i, j, 0, 0);
                visit[i][j] = false;
            }
        }

        //ㅗ ㅜ ㅏ ㅓ
        for(int y = 0; y < N; ++y) {
            for(int x = 0; x < M; ++x) {
                int tSum = board[y][x];

                int udlr = 0;
                for(int dir = 0; dir < 4; ++dir) {
                    int ny = y + dy[dir];
                    int nx = x + dx[dir];

                    if(ny < 0 || nx < 0 || ny >= N || nx >= M) {continue;}

                    tSum += board[ny][nx];
                    udlr++;
                }

                if(udlr < 3) {
                    continue;
                }

                if(udlr == 3) {
                    maxSum = Math.max(tSum, maxSum);
                }

                for(int dir = 0; dir < 4; ++dir) {
                    int ny = y + dy[dir];
                    int nx = x + dx[dir];


                    if (ny < 0 || nx < 0 || ny >= N || nx >= M) {
                        continue;
                    }
                    int sum = tSum - board[ny][nx];
                    maxSum = Math.max(sum, maxSum);
                }
            }
        }

        System.out.println(maxSum);
    }

    public static void main (String[] args) throws IOException {
        solve();
    }
}
