import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int numOfElements = elements.length;
        int sumElements = 0;
        for (int element : elements){
            sumElements = sumElements + element;
        }
        hashMap.put(sumElements, 1);
        int maxNumOfSeq = numOfElements / 2;
        for (int numOfSeq = 1; numOfSeq <= maxNumOfSeq; numOfSeq++){
            for (int index = 0; index < numOfElements; index++){
                int tmpSum = 0;
                for (int sumIndex = index; sumIndex < index + numOfSeq; sumIndex++){
                    tmpSum = tmpSum + elements[sumIndex % numOfElements];
                }
                hashMap.put(tmpSum, 1);
                hashMap.put(sumElements - tmpSum, 1);
            }
        }
        answer = hashMap.size();
        return answer;
    }
    
    
}