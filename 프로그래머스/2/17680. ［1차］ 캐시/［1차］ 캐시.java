import java.util.HashMap;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        HashMap<String, Integer> cache = new HashMap<>(); //도시명-캐싱시간
        
        
        int curTime = 0;
        for(String city : cities) {
            String c = city.toLowerCase();
            //cache Hit
            if(cache.containsKey(c)) {
                cache.put(c, curTime);
                curTime+=1;
                continue;
            }
            
            //cache Miss
            if(cache.size() == cacheSize) {//퇴거
                
                String lru = null;
                int minTime = Integer.MAX_VALUE;
                for(String k : cache.keySet()) {
                    int v = cache.get(k);
                    if(v < minTime) {
                        minTime = v;
                        lru = k;
                    }
                }
                cache.remove(lru);
            }
            
            if(cache.size() < cacheSize) {
                cache.put(c, curTime);    
            }
            
            curTime+=5;
        }
        
        answer = curTime;
        
        return answer;
    }
}
