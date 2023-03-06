import java.util.*;
class Solution {
    public int max;
    public int numOfDungeons;
    public int visitNum;
    public int[][] dungeonInfo;
    public int solution(int k, int[][] dungeons) {
        visitNum = 0;
        max = 0;
        numOfDungeons = dungeons.length;
        dungeonInfo = new int[numOfDungeons][2];
        for(int i = 0; i < numOfDungeons; i++){
            visitNum = visitNum * 2;
            visitNum++;
            for(int j = 0; j < 2; j++){
                dungeonInfo[i][j] = dungeons[i][j];
            }
        }
        for(int i = 0; i < numOfDungeons; i++){
            getMax(i, 0, 0, k);
        }
        int answer = max;
        
        return answer;
    }
    
    public void getMax(int index, int visit, int count, int remain){
        if(remain < dungeonInfo[index][0]){
            max = Math.max(max, count);
            return;
        }
        count++;
        remain = remain - dungeonInfo[index][1];
        visit = visit | (1 << index);
        if(visit == visitNum){
            max = Math.max(max, count);
            return;
        }
        for(int i = 0; i < numOfDungeons; i++){
            if(visit == (visit | (1 << i))){
                continue;
            }
            getMax(i, visit, count, remain);
        }
    }
}