class Solution {
    public int numOfOne;
    public int numOfZero;
    public int[] solution(int[][] arr) {
        int[] answer = new int[2];
        numOfOne = 0;
        numOfZero = 0;
        int count = arr.length;
        countNum(0, 0, count, arr);
        answer[0] = numOfZero;
        answer[1] = numOfOne;
        return answer;
    }
    public void countNum(int x, int y, int count, int[][] arr){
        if(count == 1){
            if(arr[x][y] == 1){
                numOfOne++;
            }
            else{
                numOfZero++;
            }
            return;
        }
        boolean flag = true;
        for(int i = x; i < x + count; i++){
            if(!flag){
                break;
            }
            for(int j = y; j < y + count; j++){
                if(arr[i][j] != arr[x][y]){
                    flag = false;
                    break;
                }
            }
        }
        if(flag){
            if(arr[x][y] == 1){
                numOfOne++;
            }
            else{
                numOfZero++;
            }
            return;
        }
        countNum(x, y, count / 2, arr);
        countNum(x + count / 2, y, count / 2, arr);
        countNum(x, y + count / 2, count / 2, arr);
        countNum(x + count / 2, y + count / 2, count / 2, arr);
    }
}