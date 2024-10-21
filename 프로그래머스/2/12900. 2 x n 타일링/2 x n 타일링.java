class Solution {
    static int div = 1000000007;
    
    public int solution(int n) {
        if(n <= 2) {return n;}
        
        int pp = 1;
        int p = 2;
        int answer = -1;
        for(int i = 3; i <= n; ++i) {
            answer = (pp + p) % div;
            pp = p;
            p = answer;
        }
        
        return answer;
    }
}