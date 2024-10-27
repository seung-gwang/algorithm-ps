class Solution {
    public long solution(int a, int b) {
        long left = Math.min(a,b);
        long right = Math.max(a,b);
        long answer = 0;
        for(long i = left; i <= right; ++i) {
            answer += i;
        }
        
        return answer;
    }
}