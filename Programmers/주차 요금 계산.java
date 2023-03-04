import java.util.*;

class Solution {
    
    public int[] solution(int[] fees, String[] records) {
        int defaultTime = fees[0];
        int defaultFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Map<Integer, Integer> resultMap = new HashMap<>();
        Map<Integer, Integer> tmpMap = new HashMap<>();
        for(String record : records){
            String[] splitedStr = record.split(" ");
            String strTime = splitedStr[0];
            String strId = splitedStr[1];
            String type = splitedStr[2];
            int intTime = strTime2IntTime(strTime);
            int intId = strId2IntId(strId);
            if(!resultMap.containsKey(intId)){
                pq.add(intId);
                resultMap.put(intId, 0);
            }
            if(type.equals("IN")){
                tmpMap.put(intId, intTime);
            }
            else{
                int inTime = tmpMap.get(intId);
                tmpMap.remove(intId);
                int diffTime = intTime - inTime;
                resultMap.replace(intId, resultMap.get(intId) + diffTime);
            }
        }
        String strMaxTime = "23:59";
        int intMaxTime = strTime2IntTime(strMaxTime);
        Set<Integer> keySet = tmpMap.keySet();
        for(int key : keySet){
            int inTime = tmpMap.get(key);
            int diffTime = intMaxTime - inTime;
            resultMap.replace(key, resultMap.get(key) + diffTime);
        }
        int numOfId = resultMap.size();
        int[] answer = new int[numOfId];
        for(int i = 0; i < numOfId; i++){
            int sum = 0;
            int id = pq.poll();
            int time = resultMap.get(id);
            if(defaultTime >= time){
                sum = defaultFee;
            }
            else{
                sum += defaultFee;
                int diffTime = time - defaultTime;
                if(diffTime % unitTime == 0){
                    sum += (diffTime / unitTime) * unitFee;
                }
                else{
                    sum += (diffTime / unitTime + 1) * unitFee;
                }
            }
            answer[i] = sum;
        } 
        return answer;
    }
    public int strTime2IntTime(String str){
        int result = 0;
        result += (str.charAt(0) - '0') * 60 * 10;
        result += (str.charAt(1) - '0') * 60;
        result += (str.charAt(3) - '0') * 10;
        result += (str.charAt(4) - '0');
        return result;
    }
    
    public int strId2IntId(String str){
        int result = 0;
        result += (str.charAt(0) - '0') * 1000;
        result += (str.charAt(1) - '0') * 100;
        result += (str.charAt(2) - '0') * 10;
        result += (str.charAt(3) - '0') * 1;
        return result;
    }
}