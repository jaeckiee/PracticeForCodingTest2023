import java.util.*;

class Solution {
    public String solution(String p) {
        String answer = getCorrectStr(p);
        
        return answer;
    }
    public String getCorrectStr(String str){
        if(str.equals("")){
            return str;
        }
        StringBuffer sbU = new StringBuffer();
        StringBuffer sbV = new StringBuffer();
        int numOfLeft = 0;
        int numOfRight = 0;
        boolean sameFlag = false;
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if(c == '('){
                numOfLeft++;
            }
            else{
                numOfRight++;
            }
            if(!sameFlag){
                sbU.append(c);
                if(numOfLeft == numOfRight){
                    sameFlag = true;
                }
            }
            else{
                sbV.append(c);
            }
        }
        
        Stack<Character> stk = new Stack<>();
        boolean isCorrect = true;
        for(int i = 0; i < sbU.length(); i++){
            char c = sbU.charAt(i);
            if(c == '('){
                stk.push('(');
            }
            else{
                if(stk.isEmpty()){
                    isCorrect = false;
                    break;
                }
                stk.pop();
            }
        }
        if(!stk.isEmpty()){
            isCorrect = false;
        }
        
        if(isCorrect){
            return sbU.toString() + getCorrectStr(sbV.toString());
        }
        else{
            sbU.deleteCharAt(0);
            sbU.deleteCharAt(sbU.length() - 1);
            StringBuffer newSbU = new StringBuffer();
            for(int i = 0; i < sbU.length(); i++){
                if(sbU.charAt(i) == '('){
                    newSbU.append(')');
                }
                else{
                    newSbU.append('(');
                }
            }
            return "(" + getCorrectStr(sbV.toString()) + ")" + newSbU.toString(); 
        }
    }
}