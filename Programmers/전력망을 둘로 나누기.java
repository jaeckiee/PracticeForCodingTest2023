import java.util.*;

class Solution {
    public int numOfNode;
    public int[] root;
    public int solution(int n, int[][] wires) {
        int answer = 100;
        numOfNode = n;
        for(int i = 0; i < numOfNode - 1; i++){
            answer = Math.min(getResult(i, wires), answer);
        }
        return answer;
    }
    
    public int getResult(int index, int[][] wires){
        int wiresSize = wires.length;
        if(index < 0){
            return numOfNode;
        }
        if(index >= wiresSize){
            return numOfNode;
        }
        root = new int[numOfNode + 1];
        for(int i = 1; i < numOfNode + 1; i++){
            root[i] = i;
        }
        for(int i = 0; i < wiresSize; i++){
            if(i == index){
                continue;
            }
            union(wires[i][0], wires[i][1]);
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 1; i < numOfNode + 1; i++){
            int rootNum = find(i);
            if(map.containsKey(rootNum)){
                map.replace(rootNum, map.get(rootNum) + 1);
            }
            else{
                map.put(rootNum, 1);
            }
        }
        Collection<Integer> set = map.values();
        int tmp = 0;
        int result = 100;
        for(int num : set){
            if(tmp == 0){
                result = num;
            } 
            else{
                result = Math.abs(result - num);
            }
            tmp++;
        }
        return result;
    }
    
    public int find(int x){
        if(root[x] == x){
            return x;
        }
        return root[x] = find(root[x]);
    }
    
    public void union(int x, int y){
        x = find(x);
        y = find(y);
        root[x] = y;
    }
}