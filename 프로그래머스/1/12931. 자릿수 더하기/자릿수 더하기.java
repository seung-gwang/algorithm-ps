import java.util.*;

public class Solution {
    public int solution(int n) {
        String nstr = String.valueOf(n);
        int answer = 0;
        for(int i = 0; i < nstr.length(); ++i) {
            answer += (nstr.charAt(i)-'0');
        }

        return answer;
    }
}