class Solution {
    public String toBinary(int n) {
        StringBuilder sb = new StringBuilder();
        
        while(n > 0) {
            sb.append(n%2==1 ? "1" : "0");
            n /= 2;
        }
        
        return sb.reverse().toString();
    }
    
    public String getNext(String cur) {
        StringBuilder sb = new StringBuilder();
        
        int idx01 = cur.lastIndexOf("01");
        if(idx01 != -1) {
            String front = cur.substring(0, idx01);
            sb.append(front);
            sb.append("10");
            
            int cnt0 = 0;
            int cnt1 = 0;
            
            StringBuilder zeros = new StringBuilder();
            StringBuilder ones = new StringBuilder();
            
            for(int i = idx01 + 2; i < cur.length(); ++i) {
                if(cur.charAt(i) == '0') {zeros.append("0");} else {ones.append("1");}
            }
            
            sb.append(zeros.toString());
            sb.append(ones.toString());
                
            return sb.toString();
        }
        
        
        /*110 1111110 10 등*/
        if(cur.contains("10")) {
            int cnt0 = 0;
            int cnt1 = 0;
            
            StringBuilder zeros = new StringBuilder();
            StringBuilder ones = new StringBuilder();
            for(int i = 1; i < cur.length(); ++i) {
                if(cur.charAt(i) == '0') {zeros.append("0");} else {ones.append("1");}
            }
            
            sb.append("10");
            sb.append(zeros.toString());
            sb.append(ones.toString());
            
            return sb.toString();
        }
        
        //전부 1인경우
        sb.append("10");
        sb.append(cur.substring(1, cur.length()));
        return sb.toString();
    }
    
    int toDecimal(String bin) {
        int dec = 0;
        
        int d = 1;
        for(int i = bin.length() - 1; i >= 0; --i) {
            dec += (bin.charAt(i)-'0') * d;
            d *= 2;
        }
        
        return dec;
    }
    
    public int solution(int n) {
        int answer = 0;
        String bin = toBinary(n);
        String next = getNext(bin);
        answer = toDecimal(next); 
        return answer;
    }
}