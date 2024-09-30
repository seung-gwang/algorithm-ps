class Solution {
    
    public static boolean isValid(String binaryStr) {
        int len = binaryStr.length();
        
        //"1" "0"
        if(len == 1) {
            return true;
        }
        
        
        int mid = len / 2;
        char root = binaryStr.charAt(mid);
        
        
        String left = binaryStr.substring(0, mid);
        String right = binaryStr.substring(mid+1, binaryStr.length());
        
        return validateSubtree(left, root) && validateSubtree(right, root);
    }
    
    public static boolean validateSubtree(String binaryStr, char root) {
        //1의 자식은 유효해야 함
        //0의 자식은 0만 있어야 함
        int len = binaryStr.length();
        int mid = len / 2;
        char midChar = binaryStr.charAt(mid);
        
        //leaf
        if(len == 1 && root == '1') {
            return true;
        }
        
        if(len == 1 && root == '0') {
            return midChar == '0';
        }
        
        //len > 1 
        if(root == '0' && midChar == '1') {
            return false;
        }
        
        
        String left = binaryStr.substring(0, mid);
        String right = binaryStr.substring(mid+1, len);
        
        return validateSubtree(left, midChar) && validateSubtree(right, midChar);
        
    }
    
    
    public static String toBinaryStrTree(long dec) {
        String binaryStr = "";
        
        while(dec>0) {
            binaryStr = String.valueOf(dec%2) + binaryStr;
            dec/=2;
        }

        int h = 1;
        int binStrLen = binaryStr.length();
        while(Math.pow(2,h) - 1 < binStrLen) {
            h++;
        }

        //완전이진트리의 노드 수가 되도록 0 추가
        for(int j = 0; j < Math.pow(2,h) - 1 - binStrLen; ++j) {
            binaryStr = "0" + binaryStr;
        }
        
        return binaryStr;
    }
    
//     public static boolean ts(String binaryStr, char root) {
//         //0의 child는 모두 0이여야 유효함
//         //1의 child는 유효
        
//         //부모가 1이면 나는 1,0 둘다 상관 없어
        
        
//     }
    
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];        
        
        for(int i = 0; i < numbers.length; ++i) {
            String binaryStr = toBinaryStrTree(numbers[i]);
            answer[i] = isValid(binaryStr) ? 1 : 0;
        }
        
        return answer;
    }
}