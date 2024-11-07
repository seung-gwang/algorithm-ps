import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] ln = bf.readLine().split(" ");
        int N = Integer.parseInt(ln[0]);
        int nScore = Integer.parseInt(ln[1]);
        int P = Integer.parseInt(ln[2]);

        if (N == 0) {
            System.out.println(1);
            return;
        }

        List<Integer> scores = new ArrayList<>();
        if (N > 0) {
            String[] scoreStrings = bf.readLine().split(" ");
            for (String score : scoreStrings) {
                scores.add(Integer.parseInt(score));
            }
        }

        if (N == P && scores.get(N - 1) >= nScore) {
            System.out.println(-1);
            return;
        }

        int rank = 1;
        for (int score : scores) {
            if (score > nScore) {
                rank++;
            } else {
                break;
            }
        }

        if (rank > P) {
            System.out.println(-1);
        } else {
            System.out.println(rank);
        }
    }
}
