class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int range = 1 + 2 * w;  
        
        int left = 1;  
        for (int s : stations) {
            int right = s - w - 1;  
            
            if (left <= right) {  
                int distance = right - left + 1;  
                answer += (distance + range - 1) / range;  
            }
            
            left = s + w + 1;
        }
        
        if (left <= n) {
            int distance = n - left + 1; 
            answer += (distance + range - 1) / range; 
        }
        
        return answer;
    }
}
