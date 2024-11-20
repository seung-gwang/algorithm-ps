import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[] nums;
    static int[] D;

    public static int bSearch(int num, int lIdx, int rIdx) {
        while(lIdx < rIdx) {
            int mIdx = (lIdx + rIdx) / 2;
            if(D[mIdx] < num) {
                lIdx = mIdx + 1;
            }
            else {
                rIdx = mIdx;
            }
        }

        return lIdx;
    }

    public static void solve() throws IOException {
        N = Integer.parseInt(bf.readLine());
        nums = new int[N];
        D = new int[N];

        String[] ln = bf.readLine().split(" ");
        for(int i = 0; i < N; ++i) {
            nums[i] = Integer.parseInt(ln[i]);
            D[i] = Integer.MAX_VALUE;
        }

        int maxIdx = 0;
        D[0] = nums[0];
        for(int i = 1; i < N; ++i) {
            if(D[maxIdx] < nums[i]) {
                D[++maxIdx] = nums[i];
            }
            else {
                int curIdx = bSearch(nums[i],0, maxIdx);
                D[curIdx] = nums[i];
            }
        }

        System.out.println(maxIdx+1); //길이 : idx + 1
    }

    public static void main(String[] args) throws IOException {
        solve();
    }
}
