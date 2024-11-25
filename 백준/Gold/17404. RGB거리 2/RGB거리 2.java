import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[][] C;
    static int[][] DP;
    static int INF = 9999999;

    public static void solve() throws IOException {
        N = Integer.parseInt(br.readLine());
        C = new int[N][3];


        for(int i = 0; i < N; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            C[i][0] = r;
            C[i][1] = g;
            C[i][2] = b;
        }


        int answer = INF;
        for(int color = 0; color < 3; ++color) {
            DP = new int[N][3];
            for(int r = 0; r < 3; ++r) {
                Arrays.fill(DP[r],INF);
            }

            DP[0][color] = C[0][color];
            for(int i = 1; i < N; ++i) {
                DP[i][0] = Math.min(DP[i-1][1], DP[i-1][2]) + C[i][0]; //R
                DP[i][1] = Math.min(DP[i-1][0], DP[i-1][2]) + C[i][1]; //G
                DP[i][2] = Math.min(DP[i-1][0], DP[i-1][1]) + C[i][2]; //B
            }


            if(color == 0) {
                answer = Math.min(answer, Math.min(DP[N-1][1], DP[N-1][2]));
                continue;
            }

            if(color == 1) {
                answer = Math.min(answer, Math.min(DP[N-1][0], DP[N-1][2]));
                continue;
            }

            //color == 2
            answer = Math.min(answer, Math.min(DP[N-1][0], DP[N-1][1]));
        }
        
        System.out.println(answer);
    }
    
    public static void main(String[] args) throws IOException {
        solve();
    }
}

