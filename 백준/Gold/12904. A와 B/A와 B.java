import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static String S;
    static String T;
    
    public static void solve() throws IOException {
        S = bf.readLine();
        T = bf.readLine();

        StringBuffer tb = new StringBuffer(T);

        while(tb.length() > S.length()) {
            boolean reverse = tb.charAt(tb.length() - 1) == 'B';

            tb.delete(tb.length() - 1, tb.length());

            if(reverse) {tb.reverse();}
        }

        int answer = S.equals(tb.toString()) ? 1 : 0;
        System.out.println(answer);
    }

    public static void main(String[] args) throws IOException {
        solve();
    }
}
