import java.util.*;

class Solution {
    public class NumSet implements Comparable{
        public HashSet<Integer> nums = new HashSet<>();
        
        @Override
        public int compareTo(Object other) {
            return this.nums.size() - ((NumSet)other).nums.size();
        }
    }
    
    public int[] solution(String s) {
        s = s.substring(1, s.length() - 1); //{2},{2,1},{2,1,3},{2,1,3,4}
        
        ArrayList<NumSet> numSetList = new ArrayList<>();
        
        int arrLen = -1;
        for(String setStr : s.split("\\},\\{")) { 
            setStr = setStr.replaceAll("[{}]", "");
            
            NumSet nSet = new NumSet();
            for(String n : setStr.split(",")) {
                nSet.nums.add(Integer.valueOf(n));
            }
            arrLen = Math.max(arrLen, nSet.nums.size());
            numSetList.add(nSet);
        }
        
        Collections.sort(numSetList);
        int answer[] = new int[arrLen];
        int idx = 0;
        HashSet<Integer> hs = new HashSet<>();
        for(NumSet ns : numSetList) {
            for(int n : ns.nums) {
                if(hs.contains(n)) {continue;}
                hs.add(n);
                answer[idx++] = n;
            }
        }
        
        return answer;
    }
}