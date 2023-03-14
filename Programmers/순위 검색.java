import java.util.*;

class EncodedInfo{
    int type;
    int score;
    EncodedInfo(int type, int score){
        this.type = type;
        this.score = score;
    }
}

class EncodedQuery{
    int type;
    int score;
    EncodedQuery(int type, int score){
        this.type = type;
        this.score = score;
    }
}

class Solution {
    public HashMap<Integer, TreeMap<Integer, Integer>> hashMap;
    public HashMap<Integer, List<Integer>> newHashMap;
    public int[] solution(String[] info, String[] query) {
        hashMap = new HashMap<>();
        newHashMap = new HashMap<>();
        for(String currInfo : info){
            EncodedInfo encodedInfo = getEncodedInfo(currInfo);
            int currType = encodedInfo.type;
            int currScore = encodedInfo.score;
            if(hashMap.containsKey(currType)){
                TreeMap<Integer, Integer> treeMap = hashMap.get(currType);
                if(treeMap.containsKey(currScore)){
                    treeMap.replace(currScore, treeMap.get(currScore) + 1);
                }
                else{
                    treeMap.put(currScore, 1);
                }
            }
            else{
                TreeMap<Integer, Integer> treeMap = new TreeMap<>();
                treeMap.put(currScore, 1);
                hashMap.put(currType, treeMap);
            }
        }

        Set<Integer> keySet = hashMap.keySet();
        for(int key : keySet){
            List<Integer> list = new ArrayList<>();
            TreeMap<Integer, Integer> treeMap = hashMap.get(key);
            for(Map.Entry<Integer,Integer> entry : treeMap.entrySet()) {
                for(int i = 0; i < entry.getValue(); i++){
                    list.add(entry.getKey());
                }
            }
            newHashMap.put(key, list);
        }

        int querySize = query.length;
        int[] answer = new int[querySize];
        int index = 0;
        List<Integer> checkList1 = new ArrayList<>();
        checkList1.add(1 << 8);
        checkList1.add(1 << 7);
        checkList1.add(1 << 6);
        List<Integer> checkList2 = new ArrayList<>();
        for(int checkNum1 : checkList1){
            checkList2.add(checkNum1 + (1 << 5));
            checkList2.add(checkNum1 + (1 << 4));
        }
        List<Integer> checkList3 = new ArrayList<>();
        for(int checkNum2 : checkList2){
            checkList3.add(checkNum2 + (1 << 3));
            checkList3.add(checkNum2 + (1 << 2));
        }
        List<Integer> checkList4 = new ArrayList<>();
        for(int checkNum3 : checkList3){
            checkList4.add(checkNum3 + (1 << 1));
            checkList4.add(checkNum3 + 1);
        }
        for(String currQuery : query){
            int result = 0;
            EncodedQuery encodedQuery = getEncodedQuery(currQuery);
            int currType = encodedQuery.type;
            int currScore = encodedQuery.score;
            for(int key : checkList4){
                if((key & currType) == currType){
                    if(!newHashMap.containsKey(key)){
                        continue;
                    }
                    List<Integer> list = newHashMap.get(key);
                    int listSize = list.size();
                    int left = 0;
                    int right = listSize - 1;
                    while(left <= right){
                        int mid = (left + right) / 2;
                        if(list.get(mid) < currScore){
                            left = mid + 1;
                        }
                        else{
                            right = mid - 1;
                        }
                    }
                    result += listSize - (right + 1);

                }
            }
            answer[index++] = result;
        }

        return answer;
    }
    public EncodedInfo getEncodedInfo(String info){
        int type = 0;
        String[] splitedInfo = info.split(" ");
        if(splitedInfo[0].equals("cpp")){
            type = type | (1 << 8);
        }
        else if(splitedInfo[0].equals("java")){
            type = type | (1 << 7);
        }
        else if(splitedInfo[0].equals("python")){
            type = type | (1 << 6);
        }

        if(splitedInfo[1].equals("backend")){
            type = type | (1 << 5);
        }
        else if(splitedInfo[1].equals("frontend")){
            type = type | (1 << 4);
        }

        if(splitedInfo[2].equals("junior")){
            type = type | (1 << 3);
        }
        else if(splitedInfo[2].equals("senior")){
            type = type | (1 << 2);
        }

        if(splitedInfo[3].equals("chicken")){
            type = type | (1 << 1);
        }
        else if(splitedInfo[3].equals("pizza")){
            type = type | 1;
        }
        int score = Integer.parseInt(splitedInfo[4]);
        return new EncodedInfo(type, score);
    }
    public EncodedQuery getEncodedQuery(String query){
        int type = 0;
        String[] splitedQuery = query.split(" and ");
        if(splitedQuery[0].equals("cpp")){
            type = type | (1 << 8);
        }
        else if(splitedQuery[0].equals("java")){
            type = type | (1 << 7);
        }
        else if(splitedQuery[0].equals("python")){
            type = type | (1 << 6);
        }

        if(splitedQuery[1].equals("backend")){
            type = type | (1 << 5);
        }
        else if(splitedQuery[1].equals("frontend")){
            type = type | (1 << 4);
        }

        if(splitedQuery[2].equals("junior")){
            type = type | (1 << 3);
        }
        else if(splitedQuery[2].equals("senior")){
            type = type | (1 << 2);
        }
        String[] finalString = splitedQuery[3].split(" ");
        if(finalString[0].equals("chicken")){
            type = type | (1 << 1);
        }
        else if(finalString[0].equals("pizza")){
            type = type | 1;
        }
        int score = Integer.parseInt(finalString[1]);
        return new EncodedQuery(type, score);
    }
}