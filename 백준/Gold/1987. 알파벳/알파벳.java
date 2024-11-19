import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static int R;
    static int C;
    static char[][] board;
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    static int answer;

    public static void dfs(int cy, int cx, boolean[] alphabet, int len) {
        answer = Math.max(len, answer);

        for(int d = 0; d < 4; ++d) {
            int ny = cy + dy[d];
            int nx = cx + dx[d];

            if(ny >= R || ny < 0 || nx >= C || nx < 0) {continue;}
            if(alphabet[board[ny][nx] - 'A']) {continue;}

            alphabet[board[ny][nx] - 'A'] = true;
            dfs(ny, nx, alphabet, len+1);
            alphabet[board[ny][nx] - 'A'] = false;

        }
    }

    public static void solve() throws IOException {
        String[] rc = bf.readLine().split(" ");
        R = Integer.parseInt(rc[0]);
        C = Integer.parseInt(rc[1]);

        board = new char[R][C];

        for(int i = 0; i < R; ++i) {
            String row = bf.readLine();
            for(int j = 0; j < C; ++j) {
                board[i][j] = row.charAt(j);
            }
        }


        answer = 0;
        boolean[] alphabet = new boolean[26]; //A ~ Z

        alphabet[board[0][0] - 'A'] = true;
        dfs(0,0, alphabet, 1);

        System.out.println(answer);
    }

    public static void main(String[] args) throws IOException {
        solve();
    }
}
