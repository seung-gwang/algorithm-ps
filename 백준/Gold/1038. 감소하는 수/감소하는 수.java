import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main (String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(bf.readLine());

        //0 1 2 3 4 5 6 7 8 9
        if(n <= 10) {
            System.out.println(n);
            return;
        }

        ArrayList<ArrayList<String>> descNums = new ArrayList<>();
        for(int i = 0; i <= 10; ++i) {
            descNums.add(new ArrayList<>());
        }


        int cnt = 0;
        for(int i = 0; i <= 9; ++i) {
            descNums.get(1).add(String.valueOf(i));
            cnt++;
        }

        //9876543210 : 최대 10자리
        for(int i = 1; i <= 9; ++i) {
            for(String cur : descNums.get(i)) {
                if(Integer.parseInt(cur) == 0) {continue;}
                for(int j = 0; j < Integer.valueOf(cur.charAt(cur.length() - 1) - '0'); ++j) {
                    String concat = cur + String.valueOf(j);
                    descNums.get(i+1).add(concat);
                    cnt++;
                    if(cnt == n+1) {
                        System.out.println(concat);
                        return;
                    }

                }
            }
        }

        System.out.println("-1");
    }
}
