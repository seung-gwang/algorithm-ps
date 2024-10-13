class Solution {
    public int[] solution(int n, int s) {
        if(s < n) {return new int[]{-1};}
        int[] answer = new int[n];
        
        for(int i = 0; i < n; ++i) {
            answer[i] = s / n;
        }
        
        int r = s % n;
        for(int i = 0; i < r; ++i) {
            answer[n-1-i]++;
        }

        
        return answer;
    }
}