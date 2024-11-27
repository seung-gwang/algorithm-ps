import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M, K;
    static int[] arr;
    static int[] p;

    public static int find(int n) {
        if(n == p[n]) {return n;}

        int pn = find(p[n]);
        p[n] = pn;

        return pn;
    }

    public static void solve() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; ++i) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        p = new int[N+1];
        for(int i = 1; i <= N; ++i) {
            p[i] = i;
        }


        for(int i = 0; i < M; ++i) {
            st = new StringTokenizer(br.readLine());
            int a,b;
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            int pa = find(a);
            int pb = find(b);

            if(pa != pb) {
                p[pa] = pb;
            }
        }

        HashMap<Integer, Integer> candy = new HashMap<>();
        HashMap<Integer, Integer> kid = new HashMap<>();
        for(int i = 1; i <= N; ++i) {
            int p = find(i);
            candy.put(p, candy.getOrDefault(p, 0) + arr[i]);
            kid.put(p, kid.getOrDefault(p, 0) + 1);
        }

        int[] dp = new int[K];
        for(int k : candy.keySet()) {
            int candyCnt = candy.get(k);
            int kidCnt = kid.get(k);
            for(int i = K-1; i - kidCnt>= 0; --i) {
                dp[i] = Math.max(dp[i], dp[i-kidCnt] + candyCnt);
            }
        }

        int answer = -1;
        for(int i = 0; i < K; ++i) {
            answer = Math.max(answer, dp[i]);
        }

        System.out.println(answer);


    }

    public static void main(String[] args) throws IOException {
        solve();
    }
}
