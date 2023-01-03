class Solution {
    public int solution(int storey) {
        int answer = 0;
        while (storey > 0){
            int currNum = storey % 10;
            storey = storey / 10;
            int nextNum = storey % 10;
            if (currNum < 5){
                answer = answer + currNum;
            }
            else if (currNum > 5){
                answer = answer + (10 - currNum);
                storey = storey + 1;
            }
            else{
                if (nextNum >= 5){
                    answer = answer + currNum;
                    storey = storey + 1;
                }
                else{
                    answer = answer + currNum;
                }
            }
        }
        return answer;
    }
}