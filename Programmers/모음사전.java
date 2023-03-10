import java.util.*;

class Solution {
    TreeSet<String> treeSet;
    char[] charArr = {'A', 'E', 'I', 'O', 'U'};
    public int solution(String word) {
        treeSet = new TreeSet<>();
        StringBuffer sb = new StringBuffer();
        setStrings(0, sb);
        setStrings(1, sb);
        setStrings(2, sb);
        setStrings(3, sb);
        setStrings(4, sb);
        int answer = 0;
        for(String str : treeSet){
            answer++;
            if(str.equals(word)){
                break;
            }
        }
        return answer;
    }
    public void setStrings(int count, StringBuffer sb){
        if(count < 0){
            treeSet.add(sb.toString());
            return;
        }
        for(int i = 0; i < 5; i++){
            StringBuffer nextSb = new StringBuffer();
            nextSb.append(sb);
            nextSb.append(charArr[i]);
            setStrings(count - 1, nextSb);
        }
    }
}