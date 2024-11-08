import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static int visit = -1;
    static int answer = -1;
    static int N;
    static int R;
    static int C;

    public static void divide(int N, int r, int c) {
        if(r == R && c == C) {
            visit++;
            answer = visit;
            return;
        }

        //ab
        //cd

        //a구역
        if(R < r + N/2 && C < c+N/2) {
            divide(N/2, r, c);
        }
        else {
            visit += (N/2) * (N/2);
        }

        //b구역
        if(R < r + N/2 && c+N/2 <= C) {
            divide(N/2, r, c+N/2);
        }
        else {
            visit += (N/2) * (N/2);
        }

        //c구역
        if(r+N/2 <= R && C < c+N/2) {
            divide(N/2, r+N/2, c);
        }
        else {
            visit += (N/2) * (N/2);
        }

        //d구역
        if(r+N/2 <= R && c+N/2 <= C) {
            divide(N/2, r+N/2, c+N/2);
        }
        else {
            visit += (N/2) * (N/2);
        }

    }

    public static void solve() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bf.readLine().split(" ");
        N = Integer.valueOf(input[0]);
        R = Integer.valueOf(input[1]);
        C = Integer.valueOf(input[2]);

        divide((int)Math.pow(2,N), 0, 0);

        System.out.println(answer);
    }

    public static void main (String[] args) throws IOException {
        solve();
    }
}
