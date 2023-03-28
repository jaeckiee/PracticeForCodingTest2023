import java.util.*;

class Solution {
    public PriorityQueue<Integer> peopleQueue = new PriorityQueue<>(Collections.reverseOrder());
    public PriorityQueue<Integer> resideQueue = new PriorityQueue<>(Collections.reverseOrder()); 
    
    public int solution(int[] people, int limit) {
        int answer = 0;
        for(int person : people){
            peopleQueue.add(person);
        }
        while(!peopleQueue.isEmpty()){
            int person = peopleQueue.poll();
            if(resideQueue.isEmpty()){
                answer++;
                if(limit > person){
                    resideQueue.add(limit - person);
                }
            }
            else{
                if(resideQueue.peek() >= person){
                    int reside = resideQueue.poll();
                }
                else{
                    answer++;
                    if(limit > person){
                        resideQueue.add(limit - person);
                    }
                }
            }
        }
        return answer;
    }
}