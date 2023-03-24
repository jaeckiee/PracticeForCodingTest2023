import java.util.*;
class Solution {
    public int numOfDia;
    public int numOfIron;
    public int numOfStone;
    public Map<String, Integer> mineralId;
    public int[][] cost;
    public int result;
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        cost = new int[][] {{1, 1, 1}, {5, 1, 1}, {25, 5, 1}};
        result = Integer.MAX_VALUE;
        mineralId = new HashMap<>();
        mineralId.put("diamond", 0);
        mineralId.put("iron", 1);
        mineralId.put("stone", 2);
        numOfDia = picks[0];
        numOfIron = picks[1];
        numOfStone = picks[2];
        getResult(0, 0, 1, 0, 0, 0, minerals);
        getResult(0, 1, 0, 1, 0, 0, minerals);
        getResult(0, 2, 0, 0, 1, 0, minerals);
        answer = result;
        return answer;
    }
    public void getResult(int index, int type, int diaCount, int ironCount, int stoneCount, int sum, String[] minerals){
        if(diaCount > numOfDia){
            return;
        }
        if(ironCount > numOfIron){
            return;
        }
        if(stoneCount > numOfStone){
            return;
        }
        int startIndex = index;
        for(int i = 0; i < 5; i++){
            if(startIndex == minerals.length){
                result = Math.min(result, sum);   
                return;
            }
            int mineralType = mineralId.get(minerals[startIndex]);
            sum = sum + cost[type][mineralType];
            startIndex++;
        }
        if(diaCount == numOfDia && ironCount == numOfIron && stoneCount == numOfStone){
            result = Math.min(result, sum);   
            return;
        }
        getResult(index + 5, 0, diaCount + 1, ironCount, stoneCount, sum, minerals);
        getResult(index + 5, 1, diaCount, ironCount + 1, stoneCount, sum, minerals);
        getResult(index + 5, 2, diaCount, ironCount, stoneCount + 1, sum, minerals);
    }
}