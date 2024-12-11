import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;

    public static void solve() throws IOException {
        N = Integer.parseInt(br.readLine());
        int[] nq = {1, 1, 0, 0, 2, 10, 4, 40, 92, 352, 724, 2680, 14200, 73712, 365596, 2279184};
        System.out.println(nq[N]);
    }



    public static void main(String[] args) throws IOException {
        solve();
    }
}

