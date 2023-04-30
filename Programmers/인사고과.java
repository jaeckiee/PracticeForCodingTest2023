import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int answer = 1;
        int[] myScore = scores[0];
        Arrays.sort(scores, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        int maxCom2 = 0;
        for(int[] score : scores){
            if(maxCom2 > score[1]){
                if(score.equals(myScore)){
                    return -1;
                }
            }
            else{
                maxCom2 = Math.max(maxCom2, score[1]);
                if(score[0] + score[1] > myScore[0] + myScore[1]){
                    answer++;
                }
            }
        }
        return answer;
    }
}