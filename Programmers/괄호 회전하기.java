import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        int strLength = s.length();
        for(int i = 0; i < strLength; i++){
            boolean flag = true;
            Stack<Character> stk = new Stack<>();
            for(int j = i; j < i + strLength; j++){
                int index = j % strLength;
                if(s.charAt(index) == '['){
                    stk.push('[');
                }
                else if(s.charAt(index) == '{'){
                    stk.push('{');
                }
                else if(s.charAt(index) == '('){
                    stk.push('(');
                }
                else if(s.charAt(index) == ']'){
                    if(stk.isEmpty()){
                        flag = false;
                        break;
                    }
                    if(stk.peek() == '['){
                        stk.pop();
                    }
                    else{
                        flag = false;
                        break;
                    }
                }
                else if(s.charAt(index) == '}'){
                    if(stk.isEmpty()){
                        flag = false;
                        break;
                    }
                    if(stk.peek() == '{'){
                        stk.pop();
                    }
                    else{
                        flag = false;
                        break;
                    }
                }
                else if(s.charAt(index) == ')'){
                    if(stk.isEmpty()){
                        flag = false;
                        break;
                    }
                    if(stk.peek() == '('){
                        stk.pop();
                    }
                    else{
                        flag = false;
                        break;
                    }
                }
            }
            if(!stk.isEmpty()){
                flag = false;
            }
            if(flag){
                answer++;
            }
        }
        return answer;
    }
}