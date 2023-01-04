import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(2500, new Comparator<int[]>(){
            public int compare(int[] arr1, int[] arr2){
                if (arr1[col - 1] > arr2[col - 1]){
                    return 1;
                }
                else if (arr1[col - 1] < arr2[col - 1]){
                    return -1;
                }
                else{
                    if (arr1[0] < arr2[0]){
                        return 1;
                    }
                    else if (arr1[0] > arr2[0]){
                        return -1;
                    }
                }
                return 1;
            }
        });
        
        for (int[] currData : data){
            pq.add(currData);
        }
        
        List<Integer> sumList = new ArrayList<>();
        
        int rowNum = 1;
        while(!pq.isEmpty()){
            int[] topArr = pq.poll();
            int tmpSum = 0;
            for (int currInt : topArr){
                tmpSum = tmpSum + currInt % rowNum;
            }
            sumList.add(tmpSum);
            rowNum = rowNum + 1;
        }
        for (int tmpNum = row_begin; tmpNum < row_end + 1; tmpNum++){
            answer = answer ^ sumList.get(tmpNum - 1);
        }
        return answer;
    }
}