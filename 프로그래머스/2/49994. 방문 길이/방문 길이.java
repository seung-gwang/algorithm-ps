import java.util.List;
import java.util.HashSet;
import java.util.Arrays;

class Solution {
    static int dy[] = {1,-1,0,0};
    static int dx[] = {0,0,-1,1}; //상하좌우
    
    public int solution(String dirs) {
        int answer = 0;
        
        int len = dirs.length();
        
        int cy = 0;
        int cx = 0;
        
        int duplicateRouteCnt = 0;
        
        HashSet<List<Integer>> pathSet = new HashSet<>();
        for(int i = 0; i < len; ++i) {
            char command = dirs.charAt(i);
            //상하좌우
            int dir = -1;
            switch(command) {
                case 'U' : 
                    dir = 0;
                    break;
                case 'D' : 
                    dir = 1;
                    break;
                case 'L' : 
                    dir = 2;
                    break;
                case 'R' : 
                    dir = 3;
                    break;
            }
            
            int ny = cy + dy[dir];
            int nx = cx + dx[dir];
            
            //좌표를 벗어나는 경우 무시한다
            if(Math.abs(ny) > 5 || Math.abs(nx) > 5) {
                continue;
            }
            
            /*
                cy cx -> ny nx 
            */
            int py = cy;
            int px = cx;
            cy = ny;
            cx = nx;
            
            if(pathSet.contains(Arrays.asList(cy,cx,py,px)) || pathSet.contains(Arrays.asList(py, px, cy, cx))) {
                continue;
            }
            
            pathSet.add(Arrays.asList(py, px, cy, cx));
        }
        
        answer = pathSet.size();
        
        return answer;
    }
}