import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        HashMap<Integer, Integer> sizeAndNum = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int currTangerine : tangerine){
            Integer num = sizeAndNum.get(currTangerine);
            if (num == null){
                sizeAndNum.put(currTangerine, 1);
            }
            else{
                sizeAndNum.put(currTangerine, num + 1);
            }
        }
        Collection<Integer> values = sizeAndNum.values();
        for (Integer value : values){
            pq.add(value);
        }
        while (k > 0){
            Integer maxNum = pq.poll();
            k = k - maxNum;
            answer = answer + 1;
        }
        return answer;
    }
}