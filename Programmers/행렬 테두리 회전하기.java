import java.util.*;

class Solution {
    public int[][] arr;
    public int maxNum;
    public int[] solution(int rows, int columns, int[][] queries) {
        arr = new int[rows][columns];
        maxNum = rows * columns;
        int querySize = queries.length;
        int value = 0;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                value++;
                arr[i][j] = value;
            }
        }
        int[] answer = new int[querySize];
        int index = 0;
        for(int[] query : queries){
            int minNum = rotate(query[0], query[1], query[2], query[3]);
            answer[index++] = minNum;
        }    
        return answer;
    }
    public int rotate(int x1, int y1, int x2, int y2){
        int x1Index = x1 - 1;
        int y1Index = y1 - 1;
        int x2Index = x2 - 1;
        int y2Index = y2 - 1;
        int result = maxNum;
        int tmp1 = 0;
        for(int i = y2Index; i >= y1Index + 1; i--){
            if(i == y2Index){
                tmp1 = arr[x1Index][i];
            }
            result = Math.min(result, arr[x1Index][i]);
            arr[x1Index][i] = arr[x1Index][i - 1];
        }
        int tmp2 = 0;
        for(int i = x2Index; i >= x1Index + 1; i--){
            if(i == x2Index){
                tmp2 = arr[i][y2Index];
            }
            result = Math.min(result, arr[i][y2Index]);
            if(i == x1Index + 1){
                arr[i][y2Index] = tmp1;
                break;
            }
            arr[i][y2Index] = arr[i - 1][y2Index];
        }
        int tmp3 = 0;
        for(int i = y1Index; i <= y2Index - 1; i++){
            if(i == y1Index){
                tmp3 = arr[x2Index][i];
            }
            result = Math.min(result, arr[x2Index][i]);
            if(i == y2Index - 1){
                arr[x2Index][i] = tmp2;
                break;
            }
            arr[x2Index][i] = arr[x2Index][i + 1];
        }
        for(int i = x1Index; i <= x2Index - 1; i++){
            result = Math.min(result, arr[i][y1Index]);
            if(i == x2Index - 1){
                arr[i][y1Index] = tmp3;
                break;
            }
            arr[i][y1Index] = arr[i + 1][y1Index];
        }
        return result;
    }
}