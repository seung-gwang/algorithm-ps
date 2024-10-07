import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Collections;
import java.util.LinkedList;


class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Queue<int[]> wq = new LinkedList<>(); 
        
        
        for(int i = 0; i < priorities.length; ++i) {
            pq.add(priorities[i]);
            wq.add(new int[]{i, priorities[i]});
        }
        
        int executionOrder = 1;
        while(!wq.isEmpty()) {
            int maxPriority = pq.peek();     
            int[] curProcess = wq.poll();
            int curLoc = curProcess[0];
            int curPriority = curProcess[1];      
            
            if(curPriority != maxPriority) {
                wq.add(curProcess);
                continue;
            }
            
            pq.poll();
            
            if(curLoc == location) {
                answer = executionOrder;
                break;
            }
            
            executionOrder++;
        }
        
        
        
        return answer;
    }
}