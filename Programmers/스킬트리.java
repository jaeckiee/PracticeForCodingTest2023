import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = skill_trees.length;
        int notPossibleNum = 0;
        Map<Character, Integer> hashMap = new HashMap<>();
        int index = 1;
        for(int i = 0; i < skill.length(); i++){
            char c = skill.charAt(i);
            hashMap.put(c, index++);
        }
        for(String skillTree : skill_trees){
            int maxNum = 0;
            for(int i = 0; i < skillTree.length(); i++){
                char c = skillTree.charAt(i);
                if(!hashMap.containsKey(c)){
                    continue;
                }
                int value = hashMap.get(c);
                if(maxNum != value - 1){
                    notPossibleNum++;
                    break;
                }
                else{
                    maxNum = value;
                }
            }
        }
        answer = answer - notPossibleNum;
        return answer;
    }
}