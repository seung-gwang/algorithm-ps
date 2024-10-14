/*
홀수로 나누어 떨어짐 
짝수로 나누었을 때 나머지가 나누는 수
*/
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