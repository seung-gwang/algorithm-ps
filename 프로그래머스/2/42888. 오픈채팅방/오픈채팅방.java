import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        ArrayList<String> ansList = new ArrayList<>();
        
                
        List<String> idSequence = new ArrayList<>();
        List<String> io = new ArrayList<>();
        
        HashMap<String, String> idNick = new HashMap<>();
        
        for(String s : record) {
            String[] ss = s.split(" ");
            
            
            String id = ss[1];
            io.add(ss[0]);  
            
            idSequence.add(ss[1]);
            
            if(ss.length == 2) {continue;}
            idNick.put(ss[1], ss[2]);
        }
        
        for(int i = 0; i < idSequence.size(); ++i) {
            if(io.get(i).equals("Change")) {continue;}
            
            StringBuilder sb = new StringBuilder();
            
        
            sb.append(idNick.get(idSequence.get(i)));
            sb.append("님이 ");
            
            if(io.get(i).equals("Enter")) {
                sb.append("들어왔습니다.");
            }
            else if(io.get(i).equals("Leave")){
                sb.append("나갔습니다.");
            }
            
            ansList.add(sb.toString());
        }
         
        return ansList.stream().toArray(String[]::new);
    }
}
