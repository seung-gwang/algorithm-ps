import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.TreeMap;

public class Main {
    static int N;
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static TreeMap<Integer, Integer> tm = new TreeMap<>();

    public static void insert(int num) {
        tm.put(num, tm.getOrDefault(num, 0) + 1);
    }

    public static void remove() {
        if(tm.isEmpty()) {
            System.out.println("0");
            return;
        }
        int min = tm.firstKey();
        if(tm.get(min) == 1) {
            tm.remove(min);
        }
        else {
            tm.put(min, tm.get(min) - 1);
        }
        System.out.println(min);
    }

    public static void solve() throws IOException {
        N = Integer.valueOf(bf.readLine());
        for(int i = 0; i < N; ++i) {
            int input = Integer.valueOf(bf.readLine());

            if(input > 0) {
                insert(input);
                continue;
            }

            remove();
        }
    }

    public static void main (String[] args) throws IOException {
        solve();
    }
}
