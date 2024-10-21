import java.util.*;

class Solution {
    public HashMap<String, Integer> parse(String str) {
        HashMap<String, Integer> tokenCnt = new HashMap<>();
        str = str.toLowerCase();
        for(int i = 0; i < str.length() - 1; ++i) {
            
            char cur = str.charAt(i);
            char next = str.charAt(i+1);
            
            if(!('a' <= cur && cur <= 'z')) {continue;}
            if(!('a' <= next && next <= 'z')) {continue;}
            
            String key = str.substring(i, i+2);
            tokenCnt.put(key, tokenCnt.getOrDefault(key, 0) + 1);
        }
        return tokenCnt;
    }
    
    public int intersect(HashMap<String, Integer> m1, HashMap<String, Integer> m2) {
        int cnt = 0;
        for(String k1 : m1.keySet()) {
            if(!m2.containsKey(k1)) { continue;}
            cnt += Math.min(m1.get(k1), m2.get(k1));
        }
        return cnt;
    }
    
    public int union(HashMap<String, Integer> m1, HashMap<String, Integer> m2) {
        HashSet<String> keys = new HashSet<>();
        keys.addAll(m1.keySet());
        keys.addAll(m2.keySet());
        
        int cnt = 0;
        for(String k : keys) {
            if(!m1.containsKey(k)) {
                cnt += m2.get(k);
                continue;
            }
            
            if(!m2.containsKey(k)) {
                cnt += m1.get(k);
                continue;
            }
            
            cnt += Math.max(m1.get(k), m2.get(k));
        }
        
        return cnt;    
    }
    
    
    public int solution(String str1, String str2) {                
        HashMap<String, Integer> token1 = parse(str1);
        HashMap<String, Integer> token2 = parse(str2);
        
        int i = intersect(token1, token2);
        int u = union(token1, token2);
        
        double j = (i == 0 && u == 0) ? 1 : i / (double)u;
        
        return (int)(j * 65536);
    }
}