import java.util.*;
class Node implements Comparable<Node>{
    int count;
    int type;
    Node(int count, int type){
        this.count = count;
        this.type = type;
    }
    @Override
    public int compareTo(Node o){
        return o.count - this.count;
    }
}
class Solution {
    List<List<Integer>> list;
    List<String> result;
    public String[] solution(String[] orders, int[] course) {
        list = new ArrayList<>();
        result = new ArrayList<>();
        for(String order : orders){
            int orderLength = order.length();
            List<Integer> tmpList = new ArrayList<>();
            for(int i = 0; i < orderLength; i++){
                int index = order.charAt(i) - 'A';
                tmpList.add(1 << index);
            }
            list.add(tmpList);
        }
        for(int courseNum : course){
            Map<Integer, Integer> hashMap = new HashMap<>();
            for(List<Integer> currList : list){
                if(currList.size() < courseNum){
                    continue;
                }
                addCourseToHashMap(courseNum, currList, hashMap);
            }
            PriorityQueue<Node> pq = new PriorityQueue<>();
            Set<Map.Entry<Integer, Integer>> set = hashMap.entrySet();
            for(Map.Entry<Integer, Integer> entry : set){
                int count = entry.getValue();
                int type = entry.getKey();
                if(count < 2){
                    continue;
                }
                pq.add(new Node(count, type));
            }
            int boundCount = 0;
            while(!pq.isEmpty()){
                Node node = pq.poll();
                int currCount = node.count;
                int currType = node.type;
                if(boundCount == 0){
                    boundCount = currCount;
                } 
                if(boundCount > currCount){
                    break;
                }
                result.add(deserializedType(currType));
            }
        }
        Collections.sort(result);
        String[] answer = new String[result.size()];
        for(int i = 0; i < result.size(); i++){
            answer[i] = result.get(i);
        }
        
        return answer;
    }
    public String deserializedType(int type){
        StringBuffer sb = new StringBuffer();
        int index = 0;
        while(type > 0){
            if((type % 2) == 1){
                char tmp = (char) ('A' + index);
                sb.append(tmp);
            }
            index++;
            type = type / 2;
        }
        return sb.toString();
    }
    
    public void addCourseToHashMap(int num, List<Integer> currList, Map<Integer, Integer> hashMap){
        int listSize = currList.size();
        selectCourse(num, 0, 0, listSize - num + 1, currList, hashMap);
    }
    
    public void selectCourse(int count, int selectedCourse, int startIndex, int endIndex, List<Integer> currList, Map<Integer, Integer> hashMap){
        if(count == 0){
            if(hashMap.containsKey(selectedCourse)){
                hashMap.replace(selectedCourse, hashMap.get(selectedCourse) + 1);
            }
            else{
                hashMap.put(selectedCourse, 1);
            }
            return;
        }
        for(int i = startIndex; i < endIndex; i++){
            selectCourse(count - 1, selectedCourse + currList.get(i), i + 1, endIndex + 1, currList, hashMap);
        }
    }
}