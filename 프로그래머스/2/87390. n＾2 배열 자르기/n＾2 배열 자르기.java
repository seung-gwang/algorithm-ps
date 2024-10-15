class Solution {
    public int[] solution(int n, long left, long right) {
        /*
        123 223 333
        1234 2234 334 44444
        
        01234 56789 
        00000 11111 22222 33333
        01234 01234 01234 01234
        
        12345 22345 33345 44445 55555
        ...
        */
        int sz = (int)(right - left + 1);
        int[] answer = new int[sz];
        int pos = 0;
        for(long i = left; i <= right; ++i) {
            long q = i / n;
            long r = i % n;
            answer[pos++] = (int)(q >= r ? q+1 : r+1);
        }

        return answer;
    }
}