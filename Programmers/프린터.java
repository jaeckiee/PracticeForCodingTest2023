import java.util.*;

class Task{
    int priority;
    int location;
    public Task(int priority, int location){
        this.priority = priority;
        this.location = location;
    }
}
class Solution {
    PriorityQueue<Integer> pq;
    Queue<Task> q;
    public int solution(int[] priorities, int location) {
        int answer = 0;
        pq = new PriorityQueue<>(Collections.reverseOrder());
        q = new LinkedList<>();
        int loc = 0;
        for(int priority : priorities){
            pq.add(priority);
            q.add(new Task(priority, loc));
            loc++;
        }
        while(!q.isEmpty()){
            Task task = q.poll();
            if(pq.peek() == task.priority){
                pq.poll();
                answer++;
                if(task.location == location){
                    break;
                } 
            }
            else{
                q.add(task);
            }
        }
        return answer;
    }
}