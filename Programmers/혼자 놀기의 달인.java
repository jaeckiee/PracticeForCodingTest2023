import java.util.*;

class Solution {
    public int solution(int[] cards) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int sizeOfCards = cards.length;
        boolean[] visited = new boolean[sizeOfCards];
        for (int i = 0; i < sizeOfCards; i++){
            visited[i] = false;
        }
        for (int i = 0; i < sizeOfCards; i++){
            int currIdx = i;
            int tmpResult = 0;
            while(!visited[currIdx]){
                tmpResult++;
                visited[currIdx] = true;
                currIdx = cards[currIdx] - 1;
            }
            pq.add(tmpResult);
        }
        
        int topResult = pq.poll();
        int nextResult = pq.poll();
        answer = topResult * nextResult;
        
        return answer;
    }
}