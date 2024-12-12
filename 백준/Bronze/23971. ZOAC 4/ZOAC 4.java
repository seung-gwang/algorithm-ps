import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int H, W, N, M; //5 4 1 1


    public static void solve() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int y = H / (N+1) + ((H % (N+1)) == 0 ? 0 : 1);
        int x = W / (M+1) + ((W % (M+1)) == 0 ? 0 : 1);

        System.out.println(y*x);

    }



    public static void main(String[] args) throws IOException {
        solve();
    }
}

