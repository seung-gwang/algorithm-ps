import java.util.*;

class Solution {
    public static void distribute(int money, int id, int[] profit, List<Integer>[] A) {
        if(money < 10) {
            profit[id] += money;
            return;
        }
        
        int loyalty = (int)(money * 0.1);
        int curProfit = money - loyalty;
        
        profit[id] += curProfit;
        
        if(A[id].size() != 0) {
            distribute(loyalty, A[id].get(0), profit, A);
        }
    }
    
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int N = enroll.length;
        int[] answer = new int[N];
        
        HashMap<String, Integer> nameId = new HashMap<>();
        for(int i = 0; i < N; ++i) {
            nameId.put(enroll[i], i);
        }
        
        List<Integer>[] A = new ArrayList[N];
        for(int i = 0; i < N; ++i) {
            A[i] = new ArrayList<Integer>();
        }
        
        for(int i = 0; i < N; ++i) {
            String parent = referral[i];
            String child = enroll[i];
            
            if(parent.equals("-")) {continue;}
            
            int pi = nameId.get(parent);
            int ci = nameId.get(child);
            
            A[ci].add(pi);
        }
        
        int[] profit = new int[N];
        for(int i = 0; i < seller.length; ++i) {
            int p = amount[i] * 100;
            int si = nameId.get(seller[i]);
            
            distribute(p, si, profit, A);
        }
        
        answer = profit;
        
        return answer;
    }
}