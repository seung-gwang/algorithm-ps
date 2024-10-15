class Solution
{
    public int solution(String s)
    {   
        if(s.length() % 2 == 1) {return 0;}
        
        int[] cnts = new int[26];
        for(int i = 0; i < s.length(); ++i) {
            cnts[s.charAt(i) - 'a']++;
        }
        
        for(int i = 0; i < 26; ++i) {
            if(cnts[i] % 2 == 1) {
                return 0;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));
        for(int i = 1; i < s.length(); ++i) {
            if(sb.length() > 0 && sb.charAt(sb.length() - 1) == s.charAt(i)) {
                sb.deleteCharAt(sb.length() - 1);
                continue;
            }
            
            sb.append(s.charAt(i));
        }
        
        int answer = 0;
        String result = sb.toString();
        if(result.length() == 0) {
            answer = 1;
        }
        
        return answer;
    }
}