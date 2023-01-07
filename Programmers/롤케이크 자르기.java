import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int currTopping : topping){
            if (!hashMap.containsKey(currTopping)){
                hashMap.put(currTopping, 1);
            }
            else{
                hashMap.replace(currTopping, hashMap.get(currTopping) + 1); 
            }
        }
        Map<Integer, Integer> hashMap1 = new HashMap<>();
        for (int currTopping : topping){
            if (!hashMap1.containsKey(currTopping)){
                hashMap1.put(currTopping, 1);
            }
            else{
                hashMap1.replace(currTopping, hashMap1.get(currTopping) + 1); 
            }
            hashMap.replace(currTopping, hashMap.get(currTopping) - 1);
            if (hashMap.get(currTopping) == 0){
                hashMap.remove(currTopping);
            }
            
            if (hashMap1.size() == hashMap.size()){
                answer++;
            }
            else if (hashMap1.size() < hashMap.size()){
                continue;
            }
            else{
                break;
            }
        }
        
        return answer;
    }
}