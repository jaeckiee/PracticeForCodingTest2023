class Solution {
    public long[] solution(long[] numbers) {
        int numbersSize = numbers.length;
        long[] answer = new long[numbersSize];
        int index = 0;
        for(long num : numbers){
            int zeroIndex = getIndex(num);
            if(zeroIndex <= 0){
                answer[index++] = num + 1;
            }
            else{
                long tmp = 1;
                for(int i = 0; i < zeroIndex; i++){
                    tmp = tmp * 2;
                }
                answer[index++] = num + tmp - (tmp / 2);
            }
        }
        return answer;
    }
    public int getIndex(long num){
        int count = -1;
        while(num >= 0){
            if(num % 2 == 1){
                num = num / 2;
                count++;
            }
            else{
                count++;
                return count;
            }
        }
        return count;
    }
}