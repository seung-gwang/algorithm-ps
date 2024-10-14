class Solution {
    public int solution(int n) {
        int answer = 0;
        
        for(int i = 1; i <= n; ++i) {
            int s = i;
            int sum = 0;
            
            while(sum < n) {
                sum += s;
                s++;
                
                if(sum == n) {answer++; break;}
            }
            
        }
        
        return answer;
    }
}
