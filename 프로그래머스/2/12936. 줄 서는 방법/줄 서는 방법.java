import java.util.ArrayList;

class Solution {
    public int[] solution(int n, long k) {
        ArrayList<Integer> N = new ArrayList<>();
        for(int i = 1; i <= n; ++i) {
            N.add(i);
        }
        
        int[] answer = new int[n];
        
        long[] factorials = new long[21];
        factorials[1] = 1;
        for(int i = 2; i <= 20; ++i) {
            factorials[i] = factorials[i-1] * i;
        }
        
        for(int i = 0; i < n - 1; ++i) {
            long q = (k-1) / factorials[n-i-1];
            answer[i] = N.get((int)q);
            N.remove((int)q);
            k -= q*factorials[n-i-1];
        }
        
        answer[n-1] = N.get(0);
        
        return answer;
    }
    
}
/*
factorials : 1 2 6 24 120 ...

k = 5
1,2,3

[1, 2, 3]
[1, 3, 2]
[2, 1, 3]
[2, 3, 1]
[3, 1, 2]
[3, 2, 1]


*/