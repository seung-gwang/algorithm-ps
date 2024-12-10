import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[] x;
    static int[] y;
    static int[] dist;
    static int INF = 1999999999;

    public static int getDist(int i, int j) {
        return Math.abs(x[i] - x[j]) + Math.abs(y[i] - y[j]);
    }
    public static void solve() throws IOException {
        N = Integer.parseInt(br.readLine());
        x = new int[N];
        y = new int[N];
        dist = new int[N-1];


        for(int i = 0; i < N; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }

        int distSum = 0;
        for(int i = 0; i < N - 1; ++i) {
            dist[i] = getDist(i, i+1);
            distSum += dist[i];
        }

        int minDist = INF;
        for(int i = 1; i <= N-2; ++i) {
            int curDist = distSum - dist[i-1] - dist[i] + getDist(i-1, i+1);
            minDist = Math.min(minDist, curDist);
        }

        System.out.println(minDist);
    }



    public static void main(String[] args) throws IOException {
        solve();
    }
}

