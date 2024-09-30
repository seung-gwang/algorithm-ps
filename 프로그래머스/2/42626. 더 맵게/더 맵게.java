import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i : scoville) {
            pq.add(i);
        }
        
        while(pq.size() >= 2 && pq.peek() < K) {
            int first = pq.poll();
            int second = pq.poll();
            int mix = first + second * 2;
            
            answer++;
            
            pq.add(mix);  
        }
        
        if(pq.peek() < K) {
            answer = -1;
        }
        
        return answer;
    }
}