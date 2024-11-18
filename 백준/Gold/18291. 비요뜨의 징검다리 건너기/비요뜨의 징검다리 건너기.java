import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static int T;
    static int N;
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    // 빠른 거듭 제곱 알고리즘
    public static int fastPower(int base, int exp, int mod) {
        int result = 1;
        while (exp > 0) {
            if ((exp & 1) == 1) { // 지수가 홀수일 때
                result = (int) ((long) result * base % mod);
            }
            base = (int) ((long) base * base % mod);
            exp >>= 1; // 지수를 2로 나눔
        }
        return result;
    }

    public static void subsolve() throws IOException {
        N = Integer.parseInt(bf.readLine());
        if(N == 1) {
            System.out.println(1);
            return;
        }

        int mod = 1000000007;
        int answer = fastPower(2, N - 2, mod);
        System.out.println(answer);
    }

    public static void solve() throws IOException {
        T = Integer.parseInt(bf.readLine());
        for (int t = 0; t < T; ++t) {
            subsolve();
        }
    }

    public static void main(String[] args) throws IOException {
        solve();
    }
}
