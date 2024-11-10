import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.TreeMap;

public class Main {
    static int T;
    static int N;
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void subsol() throws IOException {
        N = Integer.valueOf(bf.readLine());
        TreeMap<Integer, Integer> tm = new TreeMap<>();

        for(int n = 0; n < N; ++n) {
            String[] ln = bf.readLine().split(" ");

            if(ln[0].equals("I")) {
                int num = Integer.valueOf(ln[1]);
                tm.put(num, tm.getOrDefault(num, 0) + 1);
                continue;
            }

            if(tm.isEmpty()) {continue;}

            //최댓값 삭제
            if(ln[1].equals("1")) {
                int maxKey = tm.lastKey();
                if(tm.get(maxKey) == 1) {
                    tm.remove(maxKey);
                }
                else {
                    tm.put(maxKey, tm.get(maxKey) - 1);
                }
                continue;
            }

            //최소값 삭제
            int minKey = tm.firstKey();
            if(tm.get(minKey) == 1) {
                tm.remove(minKey);
            }
            else {
                tm.put(minKey, tm.get(minKey) - 1);
            }
        }

        if(tm.isEmpty()) {
            System.out.println("EMPTY");
            return;
        }

        int max = tm.lastKey();
        int min = tm.firstKey();
        System.out.printf("%d %d\n", max, min);
    }

    public static void solve() throws IOException {

        T = Integer.valueOf(bf.readLine());
        for(int i = 0; i < T; ++i) {
            subsol();
        }
    }

    public static void main (String[] args) throws IOException {
        solve();
    }
}
