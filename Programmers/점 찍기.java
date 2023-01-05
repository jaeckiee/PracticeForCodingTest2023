class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        long bound = Math.floorDiv((long)d * d, (long)k * k);
        for (long a = 0; a * a <= bound; a++){
            answer = answer + (int) Math.sqrt((double) (bound - a * a)) + 1;
        }
        return answer;
    }
}