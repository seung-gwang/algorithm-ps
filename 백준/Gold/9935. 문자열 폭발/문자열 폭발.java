import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static String str;
    static String expl;
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void solve() throws IOException {
        str = bf.readLine();
        expl = bf.readLine();

        StringBuffer sb = new StringBuffer();

        for(int i = 0; i < str.length(); ++i) {
            char c = str.charAt(i);
            sb.append(String.valueOf(c));

            if(sb.length() >= expl.length() && sb.substring(sb.length() - expl.length()).equals(expl)) {
                sb.delete(sb.length() - expl.length(), sb.length());
            }
        }

        if(sb.length() == 0) {
            System.out.println("FRULA");
        }
        else {
            System.out.println(sb.toString());
        }

    }

    public static void main (String[] args) throws IOException {
        solve();
    }
}
