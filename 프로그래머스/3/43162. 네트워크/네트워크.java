import java.util.*;

class Solution {
    
    //dfs(A, i, visit);
    void dfs(ArrayList<ArrayList<Integer>> A, int cur, boolean[] visit) {
        visit[cur] = true;
        for(int next : A.get(cur)) {
            if(visit[next]) {continue;}
            dfs(A, next, visit);
        }
    }
    
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        for(int i = 0; i < n; ++i) {
            A.add(new ArrayList<>());
        }
        boolean[] visit = new boolean[n];
        
        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < n; ++j) {
                if(computers[i][j] == 0) {continue;}
                A.get(i).add(j);
                A.get(j).add(i); //양방향 그래프
            }
        }
        
        for(int i = 0; i < n; ++i) {
            if(visit[i]) {continue;}
            dfs(A, i, visit);
            answer++;
        }
        
        return answer;
    }
}