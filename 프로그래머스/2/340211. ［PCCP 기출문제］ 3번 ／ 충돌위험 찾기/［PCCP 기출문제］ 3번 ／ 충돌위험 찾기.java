import java.util.ArrayList;
import java.util.HashSet;
import java.util.Arrays;

class Solution {
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        
        HashSet<ArrayList<Integer>> timeRowCols = new HashSet<>();
        HashSet<ArrayList<Integer>> dangers = new HashSet<>();
        
        for(int i = 0; i < routes.length; ++i) {
            int time = 0;
            int dstR = -1;
            int dstC = -1;
            for(int j = 0; j < routes[i].length - 1; ++j) {
                int startPointIdx = routes[i][j] - 1;
                int endPointIdx = routes[i][j+1] - 1;
                
                int sr = points[startPointIdx][0];
                int sc = points[startPointIdx][1];
                
                int er = points[endPointIdx][0];
                int ec = points[endPointIdx][1];
                
                dstR = er;
                dstC = ec;
                
                //row (sr->er, sc)
                int dr = sr < er ? 1 : -1;
                for(int r = sr; r != er; r += dr) {
                    ArrayList<Integer> point = new ArrayList<>(Arrays.asList(time,r,sc));
                    if(!timeRowCols.add(point)) {
                        dangers.add(point);
                    }
                    time++;
                }
                
                //col (er, sc->ec)
                int dc = sc < ec ? 1 : -1;
                for(int c = sc; c != ec; c += dc) {
                    ArrayList<Integer> point = new ArrayList<>(Arrays.asList(time,er,c));
                    if(!timeRowCols.add(point)) {
                        dangers.add(point);
                    }
                    time++;
                }        
            }
            
            /*최종 목적지 처리*/
            ArrayList<Integer> dst = new ArrayList<>(Arrays.asList(time,dstR, dstC));
            if(!timeRowCols.add(dst)) {
                dangers.add(dst);
            }
        }
           
        answer = dangers.size();
        
        return answer;
    }
}