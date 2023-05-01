import java.util.*;

class Solution {
    public long solution(int[] sequence) {
        long answer = 0;
        int lenSeq = sequence.length;
        int[] seq1 = new int[lenSeq];
        long[] sumSeq = new long[lenSeq + 1];
        for(int i = 0; i < lenSeq; i++){
            if(i % 2 == 0){
                seq1[i] = sequence[i];
            }
            else{
                seq1[i] = -sequence[i];
            }
        }
        sumSeq[0] = (long) seq1[0];
        for(int i = 1; i < lenSeq; i++){
            sumSeq[i] = sumSeq[i - 1] + seq1[i];
        }
        long minSum = sumSeq[0];
        long maxSum = sumSeq[0];
        for(int i = 1; i < lenSeq + 1; i++){
            minSum = Math.min(minSum, sumSeq[i]);
            maxSum = Math.max(maxSum, sumSeq[i]);
        }
        answer = Math.abs(maxSum - minSum);
        return answer;
    }
}