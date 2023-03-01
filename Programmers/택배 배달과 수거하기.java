import java.util.*;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int delIndex = n - 1;
        int pickIndex = n - 1;
        while(delIndex > -1 || pickIndex > -1){
            int tmpAnswer = 0;
            int delCap = cap;
            int pickCap = cap;
            while(delIndex >= 0 && delCap > 0){
                if(deliveries[delIndex] == 0){
                    delIndex--;
                    continue;
                }
                if(deliveries[delIndex] >= delCap){
                    deliveries[delIndex] -= delCap;
                    delCap = 0;
                }
                else{           
                    delCap = delCap - deliveries[delIndex];
                    deliveries[delIndex] = 0;
                }
                tmpAnswer = Math.max(tmpAnswer, delIndex + 1);
            }
            
            while(pickIndex >= 0 && pickCap > 0){
                if(pickups[pickIndex] == 0){
                    pickIndex--;
                    continue;
                }
                if(pickups[pickIndex] >= pickCap){
                    pickups[pickIndex] -= pickCap;
                    pickCap = 0;
                }
                else{
                    pickCap -= pickups[pickIndex];
                    pickups[pickIndex] = 0;
                }
                tmpAnswer = Math.max(tmpAnswer, pickIndex + 1);
            }
            answer += tmpAnswer * 2;
        }
        return answer;
    }
}