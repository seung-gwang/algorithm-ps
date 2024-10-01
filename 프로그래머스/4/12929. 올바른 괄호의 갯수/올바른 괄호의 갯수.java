class Solution {
    public static int subsol(int n, int openCnt, int closeCnt) {
        if (openCnt == n && closeCnt == n) {
            return 1;
        }

        int count = 0;

        // '(' 더 추가할 수 있을 때
        if (openCnt < n) {
            count += subsol(n, openCnt + 1, closeCnt);
        }

        // ')' 더 추가할 수 있을 때 [ ')'는 열린 괄호보다 적어야 함 ]
        if (closeCnt < openCnt) {
            count += subsol(n, openCnt, closeCnt + 1);
        }

        return count;
    }
    
    public int solution(int n) {
        int answer = subsol(n,0,0);;
        return answer;
    }
}