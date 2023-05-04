import java.util.*;

class Solution {
    public int[] solution(int e, int[] starts) {
        int[] numArr = new int[e + 1];
        int[] resultArr = new int[e + 1];
        for (int i = 1; i <= e; i++) {
            for (int j = 1; j <= e / i; j++){
                numArr[i * j]++;
            }
        }
        int maxNum = 0;
        int curr = 0;
        for(int i = e; i >= 1; i--){
            if(numArr[i] >= maxNum){
                maxNum = numArr[i];
                curr = i;
            }
            resultArr[i] = curr;
        }
        int startsLen = starts.length;
        int[] answer = new int[startsLen];
        for(int i = 0; i < startsLen; i++){
            int start = starts[i];
            answer[i] = resultArr[start];
        }
        return answer;
    }
}