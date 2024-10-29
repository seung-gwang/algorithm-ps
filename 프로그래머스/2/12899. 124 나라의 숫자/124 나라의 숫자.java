class Solution {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        while(n > 0) {
            sb.append(String.valueOf(n%3));
            n/=3;
        }
        sb.reverse();
        
        while(sb.toString().contains("0")) {
            int len = sb.length();
            for(int i = 1; i < len; ++i) {
                if(sb.charAt(i) == '0') {
                    sb.replace(i,i+1, "4");
                    String borrow = String.valueOf((sb.charAt(i-1) - '0') / 2);//4->2 2->1 1->0
                    sb.replace(i-1, i, borrow);
                }
            }
            
            if(sb.charAt(0) == '0') {
                sb.delete(0,1);    
            }
        }
        
        return sb.toString();
    }
}