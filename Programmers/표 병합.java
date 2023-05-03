import java.util.*;

class Solution {
    public String[] table;
    public int[] root;
    public List<String> answerList;
    public String[] solution(String[] commands) {
        answerList = new ArrayList<>();
        table = new String[51 * 51];
        root = new int[51 * 51];
        for(int i = 0; i < 51; i++){
            for(int j = 0; j < 51; j++){
                root[i * 51 + j] = i * 51 + j;
            }
        }
        for(String command : commands){
            String[] splitedCom = command.split(" ");
            if(splitedCom[0].equals("UPDATE")){
                int arrSize = splitedCom.length;
                if(arrSize == 4){
                    String rStr = splitedCom[1];
                    String cStr = splitedCom[2];
                    String value = splitedCom[3];
                    int r = Integer.parseInt(rStr);
                    int c = Integer.parseInt(cStr);
                    int index = r * 51 + c;
                    int rootIndex = find(index);
                    table[rootIndex] = value;
                }
                else if(arrSize == 3){
                    String value1 = splitedCom[1];
                    String value2 = splitedCom[2];
                    for(int i = 0; i < table.length; i++){
                        if(table[i] != null && table[i].equals(value1)){
                            table[i] = value2;
                        }
                    }
                }
                else{
                    System.out.println("error");
                }
            }
            else if(splitedCom[0].equals("MERGE")){
                String r1Str = splitedCom[1];
                String c1Str = splitedCom[2];
                int r1 = Integer.parseInt(r1Str);
                int c1 = Integer.parseInt(c1Str);
                String r2Str = splitedCom[3];
                String c2Str = splitedCom[4];
                int r2 = Integer.parseInt(r2Str);
                int c2 = Integer.parseInt(c2Str);
                int index1 = r1 * 51 + c1;
                int index2 = r2 * 51 + c2;
                if(index1 != index2){
                    int rootIndex1 = find(index1);
                    int rootIndex2 = find(index2);
                    if(table[rootIndex1] == null && table[rootIndex2] != null){
                        union(rootIndex2, rootIndex1);
                    }
                    else{
                        union(rootIndex1, rootIndex2);
                    }
                }
            }
            else if(splitedCom[0].equals("UNMERGE")){
                String rStr = splitedCom[1];
                String cStr = splitedCom[2];
                int r = Integer.parseInt(rStr);
                int c = Integer.parseInt(cStr);
                int index = r * 51 + c;
                int rootIndex = find(index);
                String value = table[rootIndex];
                List<Integer> checkList = new ArrayList<>();
                for(int i = 0; i < root.length; i++){
                    if(find(i) == rootIndex){
                        checkList.add(i);
                    }
                }
                for(int checkIndex : checkList){
                    root[checkIndex] = checkIndex;
                    table[checkIndex] = null;
                }
                table[index] = value;
            }
            else if(splitedCom[0].equals("PRINT")){
                String rStr = splitedCom[1];
                String cStr = splitedCom[2];
                int r = Integer.parseInt(rStr);
                int c = Integer.parseInt(cStr);
                int index = r * 51 + c;
                int rootIndex = find(index);
                String value = table[rootIndex];
                if(value == null){
                    answerList.add("EMPTY");
                }
                else{
                    answerList.add(value);
                }
            }
        }
        String[] answer = answerList.toArray(new String[0]);
        return answer;
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
        root[y] = x;
    }
}