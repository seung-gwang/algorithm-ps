import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int listenLen = m.replaceAll("#", "").length();
        int answerPlayLen = -1;
        
        
        for(String mi : musicinfos) {
            String[] info = mi.split(","); 
            String start = info[0];
            String end = info[1];
            String title = info[2];
            String codeStr = info[3];
            
            
            
            int sm = Integer.valueOf(start.substring(0,2)) * 60 + Integer.valueOf(start.substring(3,5));
            int em = Integer.valueOf(end.substring(0,2)) * 60 + Integer.valueOf(end.substring(3,5));
            int playTime = em - sm;
            
            if(answerPlayLen != -1 && answerPlayLen >= playTime) {continue;}
            
            ArrayList<String> codeList = new ArrayList<>();
            for(int i = 0; i < codeStr.length(); ++i) {
                if(codeStr.charAt(i) == '#') {continue;}
                if(i+1 < codeStr.length() && codeStr.charAt(i+1) == '#') {
                    codeList.add(codeStr.substring(i, i+2));
                }
                else {
                    codeList.add(codeStr.substring(i, i+1));
                }
            }
            
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < listenLen; ++i) {
                sb.append(codeList.get(i % codeList.size()));
            }
            
            
            for(int i = listenLen; i <= playTime; ++i) {
                if(!sb.toString().equals(m)) {
                    sb.delete(0,1);
                    if(sb.length() > 0 && sb.charAt(0) == '#') {sb.delete(0,1);}
                    sb.append(codeList.get(i % codeList.size()));
                    continue;
                }
                
                answer = title;
                answerPlayLen = playTime;
                break;
            }
        }
        
        return answer;
    }
}

