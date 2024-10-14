class Solution {
    public String[] solution(String[] s) {
        String[] answer = new String[s.length];

        for (int i = 0; i < s.length; i++) {
            answer[i] = rearrange(s[i]);
        }

        return answer;
    }

    private String rearrange(String str) {
        // "110"을 모두 제거하면서 몇 개의 "110"이 있었는지 카운트
        StringBuilder sb = new StringBuilder();
        int count110 = 0;
        int length = str.length();

        for (int j = 0; j < length; j++) {
            sb.append(str.charAt(j));

            // "110" 패턴을 찾으면 제거하고 카운트 증가
            if (sb.length() >= 3 && sb.substring(sb.length() - 3).equals("110")) {
                sb.delete(sb.length() - 3, sb.length());
                count110++;
            }
        }

        // 남은 문자열을 기준으로 "110"을 어디에 삽입할지 결정
        String remaining = sb.toString();
        int insertPos = remaining.lastIndexOf("0") + 1;

        // "110"을 insertPos 위치에 삽입
        StringBuilder result = new StringBuilder();
        result.append(remaining.substring(0, insertPos));
        for (int k = 0; k < count110; k++) {
            result.append("110");
        }
        result.append(remaining.substring(insertPos));

        return result.toString();
    }
}
