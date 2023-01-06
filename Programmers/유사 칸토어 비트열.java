import java.util.*;

class Solution {
    public boolean isZero(long index, long start, long end){
        long slice = (end - start) / 5;
        if (slice == 0){
            return false;
        }
        if (index < start + slice){
            return isZero(index, start, start + slice);
        }
        else if (index < start + slice * 2){
            return isZero(index, start + slice, start + slice * 2);
        }
        else if (index < start + slice * 3){
            return true;
        }
        else if (index < start + slice * 4){
            return isZero(index, start + slice * 3, start + slice * 4);
        }
        else{
            return isZero(index, start + slice * 4, start + slice * 5);
        }
    }
    
    public int solution(int n, long l, long r) {
        int answer = 0;
        long num = (long) Math.pow(5, n);
        for (long index = l - 1; index < r; index++){
            if (!isZero(index, 0, num)){
                answer = answer + 1;
            }
        }
        return answer;
    }
}