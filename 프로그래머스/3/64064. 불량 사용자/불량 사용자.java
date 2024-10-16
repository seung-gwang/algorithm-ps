import java.util.HashSet;
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    static int cnt = 0;
    
    public class IdSet {
        public HashSet<String> ids = new HashSet<>();
        
        public void add(String id) {
            ids.add(id);
        }
        
        public boolean remove(String id) {
            if(ids.contains(id) == false) {return false;}
            ids.remove(id);
            return true;
        }
        
        @Override
        public boolean equals(Object obj) {
            if(obj == this) {return true;}
            if(obj == null || !(obj instanceof IdSet)) {return false;}

            IdSet other = (IdSet)obj;
            if(this.ids.size() != other.ids.size()) {
                return false;
            }
    
            for(String oi : other.ids) {
                if(this.ids.contains(oi) == false) {
                    return false;
                }
            }
            
            return true;
        }
        
        @Override
        public int hashCode() {
            ArrayList<String> tmp = new ArrayList<>();
            for(String id : ids) {
                tmp.add(id);
            }
            
            Collections.sort(tmp);
            
            int hash = 17;
            for(String id : tmp) {
                for(int i = 0; i < id.length(); ++i) {
                    hash = hash * 31 + (id.charAt(i) - 'a');
                }
            }
            
            return hash;
        }
    }
    
    public boolean isMatched(String masked, String id) {
        if(masked.length() != id.length()) {return false;}
        
        for(int i = 0; i < masked.length(); ++i) {
            if(masked.charAt(i) == '*') {continue;}
            if(masked.charAt(i) != id.charAt(i)) {return false;}
        }
        
        return true;
    }
    
    
    public void dfs(String[] userIds, String[] banIds, boolean[] visit, int curBanIdx, IdSet curSet, HashSet<IdSet> combi) {
        if(curBanIdx < banIds.length) {
            String masked = banIds[curBanIdx];
            for(int i = 0; i < userIds.length; ++i) {
                if(visit[i]) {continue;}
                if(isMatched(masked, userIds[i]) == false) {continue;}
                visit[i] = true;

                curSet.add(userIds[i]);
                dfs(userIds, banIds, visit, curBanIdx+1, curSet, combi);
                curSet.remove(userIds[i]);
                visit[i] = false;
            }
            return;
        }
        
        if(combi.contains(curSet)) {return;}
        combi.add(curSet);
        cnt++;
        return;
    }
    
    public int solution(String[] user_id, String[] banned_id) {
        int answer = 0;
        
        boolean[] visit = new boolean[user_id.length];
        IdSet curSet = new IdSet();
        HashSet<IdSet> combi = new HashSet<>();
        dfs(user_id, banned_id, visit, 0, curSet, combi);
        
        answer = cnt;
        return answer;
    }
}