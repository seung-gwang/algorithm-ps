import java.util.*;

class Solution {
    public long solution(long n) {
        long answer = 0;
        ArrayList<String> nList = new ArrayList<>();
        String nstr = String.valueOf(n);
        for(int i = 0; i < nstr.length(); ++i) {
            nList.add(String.valueOf(nstr.charAt(i)));
        }
        
        Collections.sort(nList, Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for(String s : nList) {
            sb.append(s);
        }
        
        String sortedStr = sb.toString();
        return Long.valueOf(sortedStr);
    }
}