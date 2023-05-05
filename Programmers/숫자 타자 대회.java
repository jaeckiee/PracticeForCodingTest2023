import java.util.*;

class Cor{
    public int row;
    public int col;
    public Cor(int row, int col){
        this.row = row;
        this.col = col;
    }
}
class Check{
    public int curr1;
    public int curr2;
    public int value;
    public Check(int curr1, int curr2, int value){
        this.curr1 = curr1;
        this.curr2 = curr2;
        this.value = value;
    }
}
class Solution {
    public Map<Integer, Cor> buttonCorMap;
    public int[][] costMap;
    public int[][] minMap;
    public int solution(String numbers) {
        int answer = 0;
        buttonCorMap = new HashMap<>();
        setCor();
        costMap = new int[10][10];
        minMap = new int[10][10];
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                if(i == 4 && j == 6){
                    minMap[i][j] = 0;
                }
                else if(i == 6 && j == 4){
                    minMap[i][j] = 0;
                }
                else{
                    minMap[i][j] = -1;
                }
            }
        }
        setMap();
        for(int i = 0; i < numbers.length(); i++){
            int nextNum = (int) (numbers.charAt(i) - '0');
            int[][] tmpMin = new int[10][10];
            for(int curr1 = 0; curr1 < 10; curr1++){
                for(int curr2 = 0; curr2 < 10; curr2++) {
                    tmpMin[curr1][curr2] = -1;
                }
            }
            for(int curr1 = 0; curr1 < 10; curr1++){
                for(int curr2 = 0; curr2 < 10; curr2++){
                    if(minMap[curr1][curr2] != -1){
                        int currCost = minMap[curr1][curr2];
                        int cost1 = costMap[curr1][nextNum];
                        int cost2 = costMap[curr2][nextNum];
                        if(nextNum != curr2){
                            if(tmpMin[nextNum][curr2] == -1){
                                tmpMin[nextNum][curr2] = currCost + cost1;
                            }
                            else{
                                tmpMin[nextNum][curr2] = Math.min(tmpMin[nextNum][curr2], currCost + cost1);
                            }
                        }
                        if(curr1 != nextNum){
                            if(tmpMin[curr1][nextNum] == -1){
                                tmpMin[curr1][nextNum] = currCost + cost2;
                            }
                            else{
                                tmpMin[curr1][nextNum] = Math.min(tmpMin[curr1][nextNum], currCost + cost2);
                            }    
                        }
                    }
                }
            }

            for(int curr1 = 0; curr1 < 10; curr1++){
                for(int curr2 = 0; curr2 < 10; curr2++) {
                    minMap = tmpMin;
                }
            }
        }
        for(int curr1 = 0; curr1 < 10; curr1++){
            for(int curr2 = 0; curr2 < 10; curr2++) {
                if(minMap[curr1][curr2] != -1){
                    if(answer == 0){
                        answer = minMap[curr1][curr2];
                    }
                    else{
                        answer = Math.min(answer, minMap[curr1][curr2]);
                    }

                }
            }
        }
        return answer;
    }
    public void setCor(){
        buttonCorMap.put(0, new Cor(3, 1));
        buttonCorMap.put(1, new Cor(0, 0));
        buttonCorMap.put(2, new Cor(0, 1));
        buttonCorMap.put(3, new Cor(0, 2));
        buttonCorMap.put(4, new Cor(1, 0));
        buttonCorMap.put(5, new Cor(1, 1));
        buttonCorMap.put(6, new Cor(1, 2));
        buttonCorMap.put(7, new Cor(2, 0));
        buttonCorMap.put(8, new Cor(2, 1));
        buttonCorMap.put(9, new Cor(2, 2));
    }
    public void setMap(){
        for(int start = 0; start < 10; start++){
            for(int end = 0; end < 10; end++){
                Cor startCor = buttonCorMap.get(start);
                Cor endCor = buttonCorMap.get(end);
                int rowDiff = Math.abs(startCor.row - endCor.row);
                int colDiff = Math.abs(startCor.col - endCor.col);
                int dist = 0;
                if(rowDiff == 0 && colDiff == 0){
                    dist = 1;
                }
                else{
                    int minDiff = Math.min(rowDiff, colDiff);
                    int maxDiff = Math.max(rowDiff, colDiff);
                    dist = 3 * minDiff + 2 * (maxDiff - minDiff);
                }
                costMap[start][end] = dist;
            }
        }

    }
}
