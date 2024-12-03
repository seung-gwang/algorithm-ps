import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, T;



    public static void solve() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        String t = st.nextToken();
        T = t.equals("Y") ? 1 : t.equals("F") ? 2 : 3;

        Set<String> nicknames = new HashSet<>();
        for(int i = 0; i < N; ++i) {
            nicknames.add(br.readLine());
        }

        System.out.println(nicknames.size() / T);

    }



    public static void main(String[] args) throws IOException {
        solve();
    }
}

