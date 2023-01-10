import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        int startNum = 1;
        Stack<Integer> stack = new Stack<>();
        
        for (int num : order){
            if (!stack.empty()){
                if (stack.peek() == num){
                    stack.pop();
                    answer++;
                    continue;
                }
            }
            if (num < startNum){
                break;
            }
            while(num > startNum){
                stack.push(startNum);
                startNum++;
            }
            if (startNum == num){
                startNum++;
                answer++;
                continue;
            }
            else{
                break;
            }
        }
        return answer;
    }
}