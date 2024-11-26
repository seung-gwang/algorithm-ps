import java.util.*;

class Solution {
    public int[] solution(int target) {        
        int dp[] = new int[target+1]; //dp[i] : i점을 얻기 위해 던져야 하는 최소 수
        int dp2[] = new int[target+1]; //각 점수를 낼때 사용한 싱글/불 수
        
        int INF = 999999999;
        Arrays.fill(dp, INF);
        
        dp[0] = 0;
        for(int s = 1; s <= 20; ++s) {
            for(int i = 0; i <= target; ++i) {
                if(i + s*2 <= target) {
                    dp[i + s*2] = Math.min(dp[i + s*2], dp[i] + 1); //더블    
                }
                
                if(i + s*3 <= target) {
                    dp[i + s * 3] = Math.min(dp[i + s*3], dp[i] + 1); //트리플    
                }
                
                if(i + 50 <= target) {
                    dp[i + 50] = Math.min(dp[i + 50], dp[i] + 1); //아우터불    
                }
            }
        }
        
          
        //싱글, 불
        for(int s = 1; s <= 20; ++s) {
            for(int i = 0; i <= target; ++i) {
                if(i + s <= target && dp[i] + 1 <= dp[i+s]) {
                    dp[i + s] = dp[i] + 1;
                    dp2[i + s] = Math.max(dp2[i + s], dp2[i] + 1);
                }
                
            
                if(i + 50 <= target && dp[i] + 1 <= dp[i + 50]) {
                    dp[i + 50] = dp[i] + 1;
                    dp2[i + 50] = Math.max(dp2[i + 50], dp2[i] + 1);
                }
            }
        }
        
        return new int[]{dp[target], Math.min(dp[target], dp2[target])};
    }
}