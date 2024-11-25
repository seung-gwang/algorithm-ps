import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[] nums;
    static int M;

    public static boolean isPal(int begin, int end) {
        while(begin < end) {
            if(nums[begin] != nums[end]) {
                return false;
            }

            begin++;
            end--;
        }

        return true;
    }

    public static void solve() throws IOException {
        N = Integer.parseInt(br.readLine());
        nums = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; ++i) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());

        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < M; ++i) {
            int s, e;
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());

            if(isPal(s-1,e-1)) {
                sb.append("1\n");
            }
            else {
                sb.append("0\n");
            }
        }

        System.out.println(sb.toString());


    }

    public static void main(String[] args) throws IOException {
        solve();
    }
}

