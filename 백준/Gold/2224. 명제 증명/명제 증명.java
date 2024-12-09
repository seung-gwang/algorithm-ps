import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static boolean[][] map; //A B C D...Z a b c d ...z


    public static void solve() throws IOException {
        final int ALPHA_CNT = 'z' - 'A' + 1;
        map = new boolean[ALPHA_CNT][ALPHA_CNT];
        N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char src = st.nextToken().charAt(0);
            st.nextToken(); //'=>'
            char dst = st.nextToken().charAt(0);

            map[src-'A'][dst-'A'] = true;
        }


        for(int k = 0; k < ALPHA_CNT; ++k) {
            for(int i = 0; i < ALPHA_CNT; ++i) {
                for(int j = 0; j < ALPHA_CNT; ++j) {
                    if(map[i][j]) {continue;}
                    if(map[i][k] && map[k][j]) {
                        map[i][j] = true;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for(int src = 0; src < ALPHA_CNT; ++src) {
            for(int dst = 0; dst < ALPHA_CNT; ++dst) {
                if(src == dst) {continue;}
                if(!map[src][dst]) {continue;}
                sb.append((char)(src + 'A'));
                sb.append(" => ");
                sb.append((char)(dst + 'A'));
                sb.append("\n");
                cnt++;
            }
        }

        System.out.println(cnt);
        System.out.println(sb.toString());

    }



    public static void main(String[] args) throws IOException {
        solve();
    }
}

