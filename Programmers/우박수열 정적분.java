import java.util.*;

class Solution {
    public double[] solution(int k, int[][] ranges) {
        List<Integer> list = new ArrayList<>();
        List<Double> resultList = new ArrayList<>();
        List<Double> sumList = new ArrayList<>();
        list.add(k);
        while(k > 1){
            if (k % 2 == 0){
                k = k / 2;
            }
            else{
                k = k * 3 + 1;
            }
            list.add(k);
        }
        
        int size = list.size();
        for (int i = 0; i < size - 1; i++){
            int prev = list.get(i);
            int next = list.get(i + 1);
            double sum = (double) (prev + next) / (double) 2;
            sumList.add(sum);
        }
        
        for (int[] range : ranges){
            int a = range[0];
            int b = range[1];
            int start = a;
            int end = size - 1 + b;
            if (start > end){
                resultList.add((double)-1);
                continue;
            } 
            double result = 0;
            for (int index = start; index < end; index++){
                result = result + sumList.get(index);
            }
            resultList.add(result);
        }
        int resultListSize = resultList.size();
        double[] answer = new double[resultListSize];
        for (int i = 0; i < resultListSize; i++){
            answer[i] = resultList.get(i);
        }
        return answer;
    }
}