import java.util.*;

class Solution {
    static ArrayList<ArrayList<Integer>> A;
    static boolean[] visit;
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        A = new ArrayList<>();
        visit = new boolean[n+1];
        
        for(int i = 0; i < n+1; ++i) {
            A.add(new ArrayList<>());
        }
        
        for(int[] se : edge) {
            int s = se[0];
            int e = se[1];
            
            A.get(s).add(e);
            A.get(e).add(s);
        }
        
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visit[1] = true;
        while(!q.isEmpty()) {
            int popCnt = q.size();
            answer = popCnt;
            for(int p = 0; p < popCnt; ++p) {
                int cur = q.poll();
                for(int next : A.get(cur)) {
                    if(visit[next]) {continue;}
                    visit[next] = true;
                    q.add(next);
                }
            }
        }
        
        return answer;
    }
}