class Solution {
    public static int N;
    public static int zeroCnt = 0;
    public static int oneCnt = 0;
    
    //왼쪽 위 좌표 기준 y, x
    public static int quad(int y, int x, int n, int[][] arr) {
        if(n == 1) {      
            return arr[y][x];
        }
        
        int nn = n/2;
        
        int a = quad(y, x, nn, arr);
        int b = quad(y+nn, x, nn, arr);
        int c = quad(y, x+nn, nn, arr);
        int d = quad(y+nn, x+nn, nn, arr);
        
        int[] abcd = new int[]{a,b,c,d};
        for(int q : abcd) {
            if(q == 1) {
                oneCnt++;
            }
            else if (q == 0){
                zeroCnt++;
            }
        }
        
        if(a == b && b == c && c == d && d != -1) {            
            if(a == 1) {
                oneCnt -= 4;
            } 
            else if(a == 0) {
                zeroCnt -= 4;
            }
            
            return a;
        }
        
        return -1;
    }
    
    public int[] solution(int[][] arr) {
        N = arr.length;
        
        int q = quad(0,0,N, arr);
        if(q == 1) {
            oneCnt++;
        }
        else if(q == 0) {
            zeroCnt++;
        }
        
        return new int[] {zeroCnt, oneCnt};
    }
}