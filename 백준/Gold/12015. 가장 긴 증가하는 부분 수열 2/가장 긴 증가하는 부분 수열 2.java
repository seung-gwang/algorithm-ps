import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[] nums;
    static int[] D;

    // num보다 크거나 같은 첫 위치를 반환
    public static int bSearch(int num, int lIdx, int rIdx) {
        while (lIdx < rIdx) {
            int mIdx = (lIdx + rIdx) / 2;
            if (D[mIdx] < num) {
                lIdx = mIdx + 1; // 오른쪽으로 이동
            } else {
                rIdx = mIdx; // 왼쪽으로 이동
            }
        }
        return lIdx;
    }

    public static void solve() throws IOException {
        N = Integer.parseInt(bf.readLine());
        nums = new int[N];
        D = new int[N];

        String[] ln = bf.readLine().split(" ");
        for (int i = 0; i < N; ++i) {
            nums[i] = Integer.parseInt(ln[i]);
        }

        // D 배열 초기화
        Arrays.fill(D, Integer.MAX_VALUE);

        int maxIdx = 0;
        D[0] = nums[0]; // 첫 번째 원소 배치
        for (int i = 1; i < N; ++i) {
            if (nums[i] > D[maxIdx]) {
                D[++maxIdx] = nums[i];
            } else {
                int curIdx = bSearch(nums[i], 0, maxIdx + 1); // 정확한 위치 찾기
                D[curIdx] = nums[i];
            }
        }

        System.out.println(maxIdx + 1); // 길이 출력 (인덱스 + 1)
    }

    public static void main(String[] args) throws IOException {
        solve();
    }
}
