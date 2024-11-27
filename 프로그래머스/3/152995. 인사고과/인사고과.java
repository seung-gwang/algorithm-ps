import java.util.*;

class Solution {
    public class Score implements Comparable{
        public int a;
        public int b;
        
        public Score(int a, int b) {
            this.a = a;
            this.b = b;
        }
        
        public int compareTo(Object o) {
            Score other = (Score)o;
            
            if(this.a == other.a) {
                return Integer.compare(this.b, other.b);
            }
            
            return Integer.compare(other.a, this.a);
        }
    }
    
    public int solution(int[][] scores) {
        final int wa = scores[0][0];
        final int wb = scores[0][1];
        
        int answer = 0;
        int N = scores.length;
        
        Score[] arrScore = new Score[N];
        for(int i = 0; i < N; ++i) {
            arrScore[i] = new Score(scores[i][0], scores[i][1]);
        }
        
        Arrays.sort(arrScore);
        int aMax = arrScore[0].a;
        
        List<Score> incentives = new ArrayList<Score>();
        int bMax = -1;
        for(int i = 0; i < N; ++i) {
            int curA = arrScore[i].a;
            int curB = arrScore[i].b;
            
            if(curB >= bMax) {
                aMax = curA;
                bMax = curB;
            }
            
            
            if(curA < aMax && curB < bMax) {
                if(curA == wa && curB == wb) {
                    return -1;
                }
                continue; //인센티브 못받음
            }
            
            incentives.add(arrScore[i]);
        }
        
        Collections.sort(incentives, new Comparator<Score>() {
            public int compare(Score left, Score right) {
                int lSum = left.a + left.b;
                int rSum = right.a + right.b;
                
                return Integer.compare(rSum, lSum);
            }
        });
        
        int rank = 1;
        int left = 0;
        for(int right = 0; right < incentives.size(); ++right) {
            int a = incentives.get(right).a;
            int b = incentives.get(right).b;
            
            while(incentives.get(left).a + incentives.get(left).b > a+b) {
                left++;
                rank++;
            }
            
            
            if(a == wa && b == wb) {
                return rank;
            }

        }
        
        return -1;
    }
}