import java.util.*;

class Solution {
    class FileName implements Comparable{
        public FileName(String head, String num, String tail) {
            this.head = head;
            this.num = num;
            this.tail = tail;
        }
        
        public String head;
        public String num;
        public String tail;
        
        @Override
        public int compareTo(Object o) {
            FileName other = (FileName)o;
           
            int h = (this.head.toLowerCase()).compareTo(other.head.toLowerCase());
            if(h != 0) {return h;}
            
            return Integer.valueOf(this.num) - Integer.valueOf(other.num);
        }
    }
    
    public FileName toFileName(String file) {
        StringBuilder headBuilder = new StringBuilder();
        StringBuilder numBuilder = new StringBuilder();
        StringBuilder tailBuilder = new StringBuilder();
        
        boolean isHeadDone = false;
        boolean isNumDone = false;
        for(int i = 0; i < file.length(); ++i) {
            char cur = file.charAt(i);
            if('0' <= cur && cur <= '9') {
                isHeadDone = true;
            }
            
            if(isHeadDone && !isNumDone && !('0' <= cur && cur <= '9')) {
                isNumDone = true;
            }
            
            String curStr = String.valueOf(cur);
            
            if(!isHeadDone) {
                headBuilder.append(curStr);
                continue;
            }
            
            if(!isNumDone) {
                numBuilder.append(curStr);
                continue;
            }
            
            tailBuilder.append(curStr);            
        }
        
        return new FileName(headBuilder.toString(), numBuilder.toString(), tailBuilder.toString());
    }
        
    
    
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        
        FileName[] fileNames = new FileName[files.length];
        
        for(int i = 0; i < files.length; ++i) {
            fileNames[i] = toFileName(files[i]);
        }
        
        Arrays.sort(fileNames);
        for(int i = 0; i < files.length; ++i) {
            StringBuilder sb = new StringBuilder();
            sb.append(fileNames[i].head);
            sb.append(fileNames[i].num);
            sb.append(fileNames[i].tail);
            
            answer[i] = sb.toString();
        }
        
        return answer;
    }
}
