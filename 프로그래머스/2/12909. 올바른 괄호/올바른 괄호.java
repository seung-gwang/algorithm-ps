class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        int LEN = s.length();
        int open = 0;
        for(int i = 0; i < LEN; ++i) {
            if(s.charAt(i) == '(') {
                open++;
                continue;
            }
            
            if(open == 0) {
                answer = false;
                break;
            }
            
            open--;
        }
        
        if(open != 0) {answer = false;}
        return answer;
    }
}