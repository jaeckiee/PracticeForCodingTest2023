import java.util.*;

class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int num : section){
            q.add(num);
        }
        int index = 0;
        while(!q.isEmpty()){
            int currNum = q.poll();
            if(index > currNum){
                continue;
            }
            index = currNum + m;
            answer++;
        }
        return answer;
    }
}