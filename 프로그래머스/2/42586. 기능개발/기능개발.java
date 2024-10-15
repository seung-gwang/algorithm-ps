import java.util.ArrayList;

class Solution {    
    public int[] solution(int[] progresses, int[] speeds) {
        
        int jobCnt = progresses.length;
        int[][] jobs = new int[jobCnt][2];
        
        for(int i = 0; i < jobCnt; ++i) {
            jobs[i][0] = progresses[i];
            jobs[i][1] = speeds[i];
        }

        ArrayList<Integer> tmp = new ArrayList<>();
        
        int s = 0;
        int e = jobCnt;
        while(s < e) {
            for(int i = 0; i < jobCnt; ++i) {
                jobs[i][0] += jobs[i][1];
            }
            
            int done = 0;
            for(int i = s; i < jobCnt; ++i) {
                if(jobs[i][0]>=100) {
                    done++;
                    continue;
                }
                break;
            }
            
            if(done == 0) {continue;}
            tmp.add(done);
            s += done;
        }
        
        return tmp.stream().mapToInt(i -> i).toArray();
    }
}