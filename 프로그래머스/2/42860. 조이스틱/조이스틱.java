class Solution {
    public int getMinUpDown(char target) {
        int upCnt = target - 'A';
        int downCnt = 'Z' - target + 1;   
        return Math.min(upCnt, downCnt); 
    }
    
    public int greedy(String name, StringBuilder aaaa, int curIdx, int curMovCnt) {
        aaaa.replace(curIdx, curIdx + 1, String.valueOf(name.charAt(curIdx)));
        curMovCnt += getMinUpDown(name.charAt(curIdx));
        if(aaaa.toString().equals(name)) {return curMovCnt;}
        
        int result = Integer.MAX_VALUE;
        
        boolean lSearch = false;
        boolean rSearch = false;
        
        for(int m = 1; m < name.length(); ++m) {
            int rightIdx = curIdx + m;
            if(rightIdx > name.length() - 1) {rightIdx -= name.length();}  
            
            int leftIdx = curIdx - m;
            if(leftIdx < 0) {leftIdx += name.length();}
            
            
            if(name.charAt(rightIdx) != aaaa.charAt(rightIdx) && !rSearch) {
                result = Math.min(greedy(name, new StringBuilder(aaaa.toString()), rightIdx, curMovCnt + m), result);
                rSearch = true;
            }
            
            if(name.charAt(leftIdx) != aaaa.charAt(leftIdx) && !lSearch) {
                result = Math.min(greedy(name, new StringBuilder(aaaa.toString()), leftIdx, curMovCnt + m), result);        
                lSearch = true;
            }
            
            if(lSearch && rSearch) {break;}
        }
        
        
        return result;
    }
    
    public int solution(String name) {
        StringBuilder sb = new StringBuilder();
        
        int ud = 0;
        for(int i = 0; i < name.length(); ++i) {
            sb.append("A");
        }
        
        return greedy(name, sb, 0, 0);
    }
}