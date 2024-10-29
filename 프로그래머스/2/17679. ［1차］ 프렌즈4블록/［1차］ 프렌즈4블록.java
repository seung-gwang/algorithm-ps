class Solution {
    static char[][] map = new char[31][31];
    static int answer = 0;
    static int R;
    static int C;
    
    public int erase() {
        boolean[][] sq = new boolean[R][C];
        for(int r = 0; r < R-1; ++r) {
            for(int c = 0; c < C-1; ++c) {
                if(map[r][c] == 'X') {continue;}
                char lu = map[r][c];
                char ru = map[r][c+1];
                char ld = map[r+1][c];
                char rd = map[r+1][c+1];
                
                if(lu == ru && ru ==ld && ld == rd) {
                    sq[r][c] = true;
                    sq[r][c+1] = true;
                    sq[r+1][c] = true;
                    sq[r+1][c+1] = true;
                }
            }
        }
        
        int eraseCnt = 0;
        for(int r = 0; r < R; ++r) {
            for(int c = 0; c < C; ++c) {
                if(sq[r][c]) {
                    map[r][c] = 'X';
                    eraseCnt++;
                }
            }
        }
        
        answer += eraseCnt;
        return eraseCnt;
    }
    
    public void fall() {
        String[] cols = new String[C];
        for(int c = 0; c < C; ++c) {
            StringBuilder sb = new StringBuilder();
            for(int r = R - 1; r >= 0; --r) {
                if(map[r][c] != 'X') {
                    sb.append(String.valueOf(map[r][c]));
                }
            }
            
            int xCnt = R - sb.length();
            for(int i = 0; i < xCnt; ++i) {
                sb.append("X");
            }
            cols[c] = sb.reverse().toString();
        }
        
        
        for(int c = 0; c < C; ++c) {
            for(int r = 0; r < R; ++r) {
                map[r][c] = cols[c].charAt(r);
            }
        }
    }
    
    public int solution(int m, int n, String[] board) {
        R = m;
        C = n;
        
        for(int r = 0; r < m; ++r) {
            String row = board[r];
            for(int c = 0; c < row.length(); ++c) {
                map[r][c] = row.charAt(c);
            }
        }
        
        while(erase() != 0) {
            fall();
        }
        
        
        return answer;
    }
}

