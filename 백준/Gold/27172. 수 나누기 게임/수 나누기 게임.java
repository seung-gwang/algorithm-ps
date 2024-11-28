import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[] nums;
    static int[] scores;
    static Map<Integer, Integer> numScore;

    public static Set<Integer> getDivisors(int num) {
        Set<Integer> divisors = new TreeSet<>();
        for(int i = 1; i * i <= num; ++i) {
            if(num % i == 0) {
                divisors.add(i);
                divisors.add(num / i);
            }
        }

        return divisors;
    }

    public static void solve() throws IOException {
        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        scores = new int[N];
        numScore = new HashMap<Integer, Integer>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; ++i) {
            int n = Integer.parseInt(st.nextToken());
            nums[i] = n;
            numScore.put(n, 0);
        }

        for(int i = 0; i < N; ++i) { //100,000
            Set<Integer> divisors = getDivisors(nums[i]);
            Set<Integer> cardNums = numScore.keySet();

            for(int d : divisors) {
                if(cardNums.contains(d)) {
                    numScore.put(nums[i], numScore.get(nums[i]) - 1);
                    numScore.put(d, numScore.get(d) + 1);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; ++i) {
            sb.append(String.valueOf(numScore.get(nums[i])));
            sb.append(" ");
        }

        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        solve();
    }
}
