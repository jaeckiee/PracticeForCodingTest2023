class Solution {
    public int[][] arr;
    public int[] solution(int n) {
        int[] answer = new int[n * (n + 1) / 2];
        arr = new int[n][n];
        insertNum(0, 0, n - 1, n - 1, 1);
        int index = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < i + 1; j++){
                answer[index++] = arr[i][j];
            }
        }
        return answer;
    }
    public void insertNum(int startRowIndex, int startColIndex, int endRowIndex, int endColIndex, int num){
        if(startRowIndex > endRowIndex){
            return;
        }
        if(startRowIndex == endRowIndex){
            arr[startRowIndex][startColIndex] = num;
            return;
        }
        for(int i = startRowIndex; i <= endRowIndex; i++){
            arr[i][startColIndex] = num++;
        }
        for(int i = startColIndex + 1; i <= endColIndex; i++){
            arr[endRowIndex][i] = num++;
        }
        int rowIndex = endRowIndex - 1;
        for(int colIndex = endColIndex - 1; colIndex > startColIndex; colIndex--){
            arr[rowIndex][colIndex] = num++;
            rowIndex--;
        }
        insertNum(startRowIndex + 2, startColIndex + 1,  endRowIndex - 1, endColIndex - 2, num);
    }
}