class Solution {
    public int numOfNumbers;
    public int result;
    public int targetNum;
    public int solution(int[] numbers, int target) {
        int answer = 0;
        targetNum = target;
        result = 0;
        numOfNumbers = numbers.length;
        getResult(0, 0, numbers);
        answer = result;
        return answer;
    }
    public void getResult(int index, int tmp, int[] numbers){
        if(index >= numOfNumbers){
            if(targetNum == tmp){
                result++;
            }
            return;
        }
        getResult(index + 1, tmp + numbers[index], numbers);
        getResult(index + 1, tmp - numbers[index], numbers);
    }
}