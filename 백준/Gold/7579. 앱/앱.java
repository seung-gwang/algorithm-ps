import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    static int[] mem;
    static int[] cost;


    public static void solve() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        mem = new int[N];
        cost = new int[N];

        StringTokenizer mSt = new StringTokenizer(br.readLine());
        StringTokenizer cSt = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; ++i) {
            mem[i] = Integer.parseInt(mSt.nextToken());
            cost[i] = Integer.parseInt(cSt.nextToken());
        }

        int maxCost = 100 * 100;
        int[] DP = new int[maxCost+1];

        for(int i = 0; i < N; ++i) {
            for(int j = maxCost; j - cost[i] >= 0; --j) {
                DP[j] = Math.max(DP[j], DP[j - cost[i]] + mem[i]);
            }
        }

        int answer = -1;
        for(int c = 0; c < DP.length; ++c) {
            if(DP[c] >= M) {
                answer = c;
                break;
            }
        }

        System.out.println(answer);
    }

    public static void main(String[] args) throws IOException {
        solve();
    }
}
