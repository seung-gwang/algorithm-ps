import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void solve() throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; ++i) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0, sum = 0;
        int answer = Integer.MAX_VALUE;

        for (int right = 0; right < N; ++right) {
            sum += arr[right];
            while (sum >= S) {
                answer = Math.min(answer, right - left + 1);
                sum -= arr[left++];
            }
        }

        if (answer == Integer.MAX_VALUE) {
            answer = 0;
        }

        System.out.println(answer);
    }

    public static void main(String[] args) throws IOException {
        solve();
    }
}
