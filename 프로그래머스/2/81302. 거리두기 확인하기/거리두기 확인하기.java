import java.util.*;

class Solution {
    public int getDist(char[][] map, int[] src, int[] dst) {
        int R = map.length;
        int C = map[0].length;
        int[] dy = {-1,1,0,0};
        int[] dx = {0,0,-1,1};
        
        
        boolean[][] visit = new boolean[R][C];
        Queue<ArrayList> q = new LinkedList<>();
        
        ArrayList<Integer> s = new ArrayList<>();
        s.add(src[0]);
        s.add(src[1]);
        
        q.add(s);
        visit[src[0]][src[1]] = true;
        
        int dist = 0;
        while(!q.isEmpty()) {
            int popCnt = q.size();
            for(int p = 0; p < popCnt; ++p) {
                ArrayList<Integer> cur = q.poll();
                int cy = cur.get(0);
                int cx = cur.get(1);
                
                if(cy == dst[0] && cx == dst[1]) {
                    return dist;
                }
                

                for(int dir = 0; dir < 4; ++dir) {
                    int ny = cy + dy[dir];
                    int nx = cx + dx[dir];

                    if(ny >= R || ny < 0 || nx >= C || nx < 0) {continue;}
                    if(visit[ny][nx]) {continue;}
                    if(map[ny][nx] == 'X') {continue;}
                    
                    visit[ny][nx] = true;
                    ArrayList<Integer> next = new ArrayList<>();
                    next.add(ny); next.add(nx);
                    q.add(next);
                }    
            }     
            
            dist++;
        }
        
        return Integer.MAX_VALUE;
    }
    
    public int check(String[] place) {
        int R = place.length;
        int C = place[0].length();
        
        char[][] map = new char[R][C];
        boolean[][] visit = new boolean[R][C];
        
        ArrayList<int[]> ps = new ArrayList<>();
        for(int i = 0; i < R; ++i) {
            for(int j = 0; j < C; ++j) {
                map[i][j] = place[i].charAt(j);
                if(map[i][j] == 'P') {ps.add(new int[]{i, j});}
            }
        }
        
        int pCnt = ps.size();
        int minDist = Integer.MAX_VALUE;
        for(int i = 0; i < pCnt - 1; ++i) {
            for(int j = i + 1; j < pCnt; ++j) {
                int dist = getDist(map, ps.get(i), ps.get(j));
                minDist = Math.min(minDist, dist);
            }
        }
        
        if(minDist <= 2) {
            return 0;
        }
        
        return 1;
    }
    
    
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        
        for(int i = 0; i < places.length; ++i) {
            answer[i] = check(places[i]);
            
        }
        return answer;
    }
}