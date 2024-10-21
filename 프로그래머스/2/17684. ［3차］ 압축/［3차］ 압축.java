import java.util.*;

class Solution {
    public int[] solution(String msg) {
        int[] answer = {};
        
        
        HashMap<String, Integer> dict = new HashMap<>();
        for(char a = 'A'; a <= 'Z'; ++a) {
            dict.put(String.valueOf(a), a - 'A' + 1);
        }
        
        
        ArrayList<Integer> tmp = new ArrayList<>();
        int idxNum = 27;
        
        int len;
        for(int s = 0; s < msg.length();s+=(len-1)) {
            len = 1;
            while(s + len <= msg.length() && dict.containsKey((msg.substring(s, s + len)))) {
                len++;
            }
            
            tmp.add(dict.get(msg.substring(s, s + len - 1)));
            
            if(s+len <= msg.length()) {
                dict.put(msg.substring(s, s+len), idxNum++);
            }                  
        }
        
        return tmp.stream().mapToInt(Integer::intValue).toArray();
        
    }
}