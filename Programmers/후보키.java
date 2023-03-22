import java.util.*;
class Solution {
    public int cardinality;
    public int degree;
    public int numOfNonCaAttrs;
    public Set<Integer> resultSet;
    public int solution(String[][] relation) {
        int answer = 0;
        resultSet = new HashSet<>();
        cardinality = relation.length;
        degree = relation[0].length;
        List<Integer> nonCaAttrs = new ArrayList<>();
        for(int col = 0; col < degree; col++){
            Set<String> set = new HashSet<>();
            for(int row = 0; row < cardinality; row++){
                set.add(relation[row][col]);
            }
            if(set.size() == cardinality){
                int tmpResult = 1 << col;
                resultSet.add(tmpResult);
            }
            else{
                nonCaAttrs.add(col);
            }
        }
        numOfNonCaAttrs = nonCaAttrs.size();
        getCandidate(nonCaAttrs, relation);
        answer = resultSet.size();
        return answer;
    }
    public void getCandidate(List<Integer> list, String[][] relation){
        if(list.isEmpty()){
            return;
        }
        Set<String> set = new HashSet<>();
        for(int row = 0; row < cardinality; row++){
            String str = "";
            for(int col : list){
                str = str + "." + relation[row][col];
            }
            set.add(str);
        }
        if(set.size() != cardinality){
            return;
        }
        if(list.size() == 1){
            int tmpResult = 1 << list.get(0);
            resultSet.add(tmpResult);
            return;
        }
        List<List<Integer>> lists = new ArrayList<>();
        for(int excludedIndex : list){
            List<Integer> tmpList = new ArrayList<>();
            for(int Index : list){
                if(Index == excludedIndex){
                    continue;
                }
                tmpList.add(Index);
            }
            Set<String> tmpSet = new HashSet<>();
            for(int row = 0; row < cardinality; row++){
                String str = "";
                for(int col : tmpList){
                    str = str + "." + relation[row][col];
                }
                tmpSet.add(str);
            }
            if(tmpSet.size() == cardinality){
                lists.add(tmpList);
            } 
        }
        if(lists.isEmpty()){
            int tmpResult = 0;
            for(int tmpCol : list){
                tmpResult = tmpResult + (1 << tmpCol);
            }
            resultSet.add(tmpResult);
            return;
        }
        
        for(List<Integer> currList : lists){
            getCandidate(currList, relation);
        }
    }
}