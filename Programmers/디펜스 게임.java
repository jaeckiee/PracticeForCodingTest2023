import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        int sumEnemy = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int currEnemy : enemy){
            sumEnemy = sumEnemy + currEnemy;
            pq.add(currEnemy);
            if (sumEnemy > n){
                if (k <= 0){
                    break;
                }
                int maxEnemy = pq.poll();
                sumEnemy = sumEnemy - maxEnemy;
                k = k - 1;
            }
            answer = answer + 1;
        }
        return answer;
    }
}