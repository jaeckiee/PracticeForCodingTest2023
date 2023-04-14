import java.util.*;

class Target implements Comparable<Target>{
    int start;
    int end;
    public Target(int start, int end){
        this.start = start;
        this.end = end;
    }
    @Override
    public int compareTo(Target o){
        return this.end - o.end;
    }
}

class Solution {
    public PriorityQueue<Target> pq;
    public int solution(int[][] targets) {
        int answer = 0;
        pq = new PriorityQueue<>();
        for(int[] target : targets){
            pq.add(new Target(target[0], target[1]));
        }
        while(!pq.isEmpty()){
            Target target = pq.poll();
            answer++;
            int tEnd = target.end;
            while(!pq.isEmpty()){
                Target tmpTarget = pq.peek();
                if(tEnd > tmpTarget.start){
                    pq.poll();
                }
                else{
                    break;
                }
            }
        }
        return answer;
    }
}