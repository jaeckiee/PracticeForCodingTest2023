import java.util.*;

class Solution {
    Integer[] descArr;
    public int solution(int[] citations) {
        int answer = 0;
        descArr = new Integer[citations.length];
        for(int i = 0; i < citations.length; i++){
            descArr[i] = citations[i];
        }
        Arrays.sort(descArr, Collections.reverseOrder());
        for(int i = 1; i <= citations.length; i++){
            if(descArr[i - 1] < i){
                break;
            }
            answer = i;
        }
        return answer;
    }
}