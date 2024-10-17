import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        Set<String> gemSet = new HashSet<>(Arrays.asList(gems));
        Map<String, Integer> gemCnt = new HashMap<>();
        
        int left = 0;
        int right = 0;
        int start = -1;
        int end = -1;
        int minLen = Integer.MAX_VALUE;
        
        while(right < gems.length) {
            gemCnt.put(gems[right], gemCnt.getOrDefault(gems[right], 0) + 1);
            
            while (gemCnt.size() == gemSet.size()) {
                if(right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                    end = right;
                }
                
                gemCnt.put(gems[left], gemCnt.get(gems[left]) - 1);
                if(gemCnt.get(gems[left]) == 0) {
                    gemCnt.remove(gems[left]);    
                }
                
                left++;
            }
            
            right++;
        }        
        
        
        return new int[] {start+1, end+1};
    }
}