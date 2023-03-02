class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        int q1Size = queue1.length;
        int q2Size = queue2.length;
        int[] q = new int[q1Size + q2Size];
        int qIndex = 0;
        long sum1 = 0;
        long sum2 = 0;
        int q1Index = 0;
        int firstQ1Index = q1Index;
        for(int q1Num : queue1){
            q[qIndex++] = q1Num;
            sum1 += q1Num;
        }
        int q2Index = qIndex;
        int firstQ2Index = q2Index;
        for(int q2Num : queue2){
            q[qIndex++] = q2Num;
            sum2 += q2Num;
        }
        while(sum1 != sum2){
            if(q1Index == firstQ2Index && q2Index == firstQ1Index){
                answer = -1;
                break;
            }
            if(sum1 > sum2){
                sum1 -= q[q1Index];
                sum2 += q[q1Index];
                q1Index = (q1Index + 1) % (q1Size + q2Size);
                if(q1Index == firstQ1Index){
                    answer = -1;
                    break;
                }
            }
            else{
                sum1 += q[q2Index];
                sum2 -= q[q2Index];
                q2Index = (q2Index + 1) % (q1Size + q2Size);
                if( q2Index == firstQ2Index){
                    answer = -1;
                    break;
                }
            }
            answer++;
        }
        return answer;
    }
}