import java.util.*;
class Result implements Comparable<Result>{
    int start;
    int end;
    public Result(int start, int end){
        this.start = start;
        this.end = end;
    }
    @Override
    public int compareTo(Result o){
        int diff = this.end - this.start;
        int oDiff = o.end - o.start;
        if(diff == oDiff){
            return this.start - o.start;
        }
        return diff - oDiff;
    }
    
}
class Solution {
    public PriorityQueue<Result> pq;
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int start = 0;
        int end = 0;
        int sum = 0;
        int seqSize = sequence.length;
        pq = new PriorityQueue<>();
        for(end = 0; end < seqSize; end++){
            sum += sequence[end];
            if(sum > k){
                while(start < end){
                    sum -= sequence[start];
                    start++;
                    if(sum == k){
                        pq.add(new Result(start, end));
                        break;
                    }
                    if(sum < k){
                        break;
                    }
                }
            }
            else if(sum < k){
                continue;
            }
            else{
                pq.add(new Result(start, end));
            }
        }
        while(start < end){
            sum -= sequence[start];
            start++;
            if(sum == k){
                pq.add(new Result(start, end));
                break;
            }
            if(sum < k){
                break;
            }
        }
        Result result = pq.poll();
        answer[0] = result.start;
        answer[1] = result.end;
        
        return answer;
    }
}