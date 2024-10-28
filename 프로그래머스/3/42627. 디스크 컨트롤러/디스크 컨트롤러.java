import java.util.*;
/*
    가장 늦게끝나는거가 뒤로
    
    
*/
class Solution {
    public class Job implements Comparable{
        public int s;
        public int d;
        
        public Job(int s, int d) {
            this.s = s;
            this.d = d;
        }
        
        @Override
        public int compareTo(Object other) {
            Job o = (Job)other;
            if(this.s==o.s) {
                return (this.s+this.d) - (o.s+o.d); //빨리 끝나는 순서로 정렬    
            }
            
            return this.s - o.s;
            
        }
    }
    
    
    public int solution(int[][] jobs) {
        int answer = 0;
        PriorityQueue<Job> pq = new PriorityQueue<>();
        for(int[] j : jobs) {
            pq.add(new Job(j[0], j[1]));
        }
        
        int curTime = 0;
        int totalJobTime = 0;
        while(!pq.isEmpty()) {
            ArrayList<Job> ready = new ArrayList<>();
            while(!pq.isEmpty() && pq.peek().s <= curTime) {
                ready.add(pq.poll());
            }
            
            int minEndTime = Integer.MAX_VALUE;
            int minEndIdx = -1;
            for(int i = 0; i < ready.size(); ++i) {
                if(minEndTime >= curTime + ready.get(i).d) {
                    minEndTime = curTime + ready.get(i).d;
                    minEndIdx = i;
                }
            }
            
            if(minEndIdx == -1) {
                curTime = pq.peek().s;
                continue;
            }
            
            Job cur = ready.get(minEndIdx); //가장 빨리 끝낼수 있는 일을 시작함
            ready.remove(minEndIdx);
            totalJobTime += (curTime - cur.s) + cur.d;
            curTime+= cur.d;
            
            //준비는됐지만 실행은 못한거는 큐에 다시 넣는다
            for(Job j : ready) {
                pq.add(j);
            }
        }
        
        return totalJobTime / jobs.length;
    }
}