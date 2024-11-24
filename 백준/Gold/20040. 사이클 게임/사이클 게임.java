import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;

    public static void solve() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());


        int[] p = new int[N];
        for(int n = 0; n < N; ++n) {
            p[n] = n;
        }

        int answer = 0;
        for(int m = 0; m < M; ++m) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            //union-find
            int pa = find(p,a);
            int pb = find(p, b);

            if(pa == pb) {
                answer = m+1;
                break;
            }

            p[pb] = pa;
        }

        System.out.println(answer);
    }

    public static int find(int[] p, int n) {
        if(p[n] == n) {return n;}

        int pn = find(p, p[n]);
        p[n] = pn;

        return pn;
    }


    public static void main(String[] args) throws IOException {
        solve();
    }
}

