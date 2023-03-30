import java.util.*;

class Solution {
    public int sum;
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        sum = brown + yellow;
        int height = 2;
        int width = 2;
        while(true){
            if(sum % height == 0){
                width = sum / height;
                int sumOfWAndH = height + width;
                double square = (double) sumOfWAndH * sumOfWAndH;
                if(square >= 4 * brown){
                    square = square - 4 * brown;
                    int sqrtNum = (int) Math.sqrt(square);
                    if(square == (double) sqrtNum * sqrtNum){
                        if(sumOfWAndH - sqrtNum > 0){
                            if((sumOfWAndH - sqrtNum) % 2 == 0){
                                answer[0] = width;
                                answer[1] = height;
                                break;
                            }
                        }
                        if((sumOfWAndH + sqrtNum) % 2 == 0){
                            answer[0] = width;
                            answer[1] = height;
                            break;
                        }
                    }
                }
            }
            height++;
        }
        return answer;
    }
}