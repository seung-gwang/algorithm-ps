class Solution {
    public String convertToN(int n, int num) {
        
        if(num == 0) {return "0";}
        
        String[] ABCDEF = {"A", "B", "C", "D", "E", "F"};
        StringBuilder sb = new StringBuilder();
        while(num > 0) {
            int d = num%n;
            num /= n;
            
            if(d >= 10) {
                sb.append(ABCDEF[d - 10]);
                continue;
            }
            
            sb.append(String.valueOf(d));
        }
        
        return sb.reverse().toString();
    }
    
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        
        int cur = 0;
        int speaker = 1;
        while(sb.length() < t) {
            String nstr = convertToN(n, cur);
            cur++;
            for(int i = 0; i < nstr.length(); ++i) {
                if(speaker == p) {
                    sb.append(String.valueOf(nstr.charAt(i)));
                }         
                if(sb.length() == t) {break;}
                speaker++;
                if(speaker > m) {speaker = 1;}
            }
        }
        
        return sb.toString();
    }
}