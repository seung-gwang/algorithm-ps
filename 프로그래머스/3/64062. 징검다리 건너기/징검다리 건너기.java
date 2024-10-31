class Solution {
    public boolean canGo(int[] stones, int fCnt, int k) {
        int jumpCnt = 0;
        for (int stone : stones) {
            if (stone < fCnt) {
                jumpCnt++;
                if (jumpCnt >= k) {return false;}
            } else {
                jumpCnt = 0;
            }
        }
        return true;
    }

    public int solution(int[] stones, int k) {
        int left = 1;
        int right = Integer.MAX_VALUE;
        int answer = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (canGo(stones, mid, k)) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return answer;
    }
}
