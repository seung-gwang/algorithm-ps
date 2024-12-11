import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[][] map;
    static int cnt;
    static List<int[]>[][] attackablePositions;

    public static List<int[]> getAttackablePositions(int r, int c) {
        List<int[]> ap = new ArrayList<>();

        for(int i = 0; i < N; ++i) {
            if(i != r) {
                ap.add(new int[]{i,c});
            }

            if(i != c) {
               ap.add(new int[]{r, i});
            }
        }

        int[] dr = {1,-1,1,-1};
        int[] dc = {1,1,-1,-1};
        for(int i = 1; i < N; ++i) {
            for(int dir = 0; dir < 4; ++dir) {
                int nr = r + dr[dir] * i;
                int nc = c + dc[dir] * i;

                if(nr < 0 || nc < 0 || nr >= N || nc >= N) {
                    continue;
                }

                ap.add(new int[] {nr,nc});
            }

        }

        return ap;
    }

    public static void dfs(int row) {
        if(row == N) {
            cnt++;
            return;
        }


        for(int col = 0; col < N; ++col) {
            if(map[row][col] != 0) {continue;}
            map[row][col] = -1;


            for(int[] pos : attackablePositions[row][col]) {
                map[pos[0]][pos[1]]++;
            }
            dfs(row+1);
            for(int[] pos : attackablePositions[row][col]) {
                map[pos[0]][pos[1]]--;
            }

            map[row][col] = 0;
        }

    }

    public static void solve() throws IOException {
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        cnt = 0;

        attackablePositions = new ArrayList[N][N];
        for(int i = 0; i < N; ++i) {
            for(int j = 0; j < N; ++j) {
                attackablePositions[i][j] = getAttackablePositions(i, j);
            }
        }

        dfs(0);  //Queen : -1
        System.out.println(cnt);
    }



    public static void main(String[] args) throws IOException {
        solve();
    }
}

