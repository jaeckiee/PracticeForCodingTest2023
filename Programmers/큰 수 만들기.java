import java.util.*;
class Solution {
    public String solution(String number, int k) {
        String answer = "";
        StringBuffer sb = new StringBuffer();
        int startIndex = 0;
        while(k > 0){
            int maxIndex = startIndex;
            char maxChar = number.charAt(startIndex);
            if(number.length() - startIndex == k){
                startIndex = number.length();
                break;
            }
            for(int i = startIndex; i < startIndex + k + 1; i++){
                if(number.charAt(i) > maxChar){
                    maxIndex = i;
                    maxChar = number.charAt(maxIndex);
                }
            }
            sb.append(maxChar);
            k = k - (maxIndex - startIndex);
            startIndex = maxIndex + 1;
        }
        for(int i = startIndex; i < number.length(); i++){
            sb.append(number.charAt(i));
        }
        answer = sb.toString();
        return answer;
    }
}