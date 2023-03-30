import java.util.*;
class Node{
    int index;
    int count;
    int currVisit;
    Node(int index, int count, int currVisit){
        this.index = index;
        this.count = count;
        this.currVisit = currVisit;
    }
}
class Solution {
    public int[] nameIntArr;
    public int nameLen;
    public int visit;
    public int mask;
    public int result;
    public int solution(String name) {
        int answer = 0;
        result = 0;
        visit = 0;
        mask = 0;
        nameLen = name.length();
        nameIntArr = new int[nameLen];
        for(int i = nameLen - 1; i >= 0; i--){
            int tmp = (int) (name.charAt(i) - 'A');
            visit = visit << 1;
            mask = mask << 1;
            mask++;
            if(tmp != 0){
                visit++;
            }
            nameIntArr[i] = tmp;
        }
        getResult();
        answer = result;
        return answer;
    }
    public void getResult(){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0, visit));
        while(!q.isEmpty()){
            Node node = q.poll();
            int count = node.count;
            int index = node.index;
            int currVisit = node.currVisit;
            count += getMinControlCount(nameIntArr[index]);
            currVisit = currVisit & (mask - (1 << index));
            if(currVisit == 0){
                if(result == 0){
                    result = count;
                }
                else{
                    result = Math.min(result, count);
                }
                continue;
            }
            int rightCount = 1;
            int leftCount = 1;
            int rightIndex = (index + 1) % nameLen;
            int leftIndex = index - 1;
            if(leftIndex == -1){
                leftIndex = nameLen - 1;
            }
            while(rightIndex != index){
                if((currVisit & (1 << rightIndex)) == (1 << rightIndex)){
                    break;
                }
                rightIndex = (rightIndex + 1) % nameLen;
                rightCount++;
            }
            while(leftIndex != index){
                if((currVisit & (1 << leftIndex)) == (1 << leftIndex)){
                    break;
                }
                leftIndex = leftIndex - 1;
                if(leftIndex == -1){
                    leftIndex = nameLen - 1;
                }
                leftCount++;
            }
            if(rightIndex != index){
                q.add(new Node(rightIndex, count + rightCount, currVisit));
            }
            if(leftIndex != index){
                q.add(new Node(leftIndex, count + leftCount, currVisit));
            }
        }
    }
    public int getMinControlCount(int num){
        return Math.min(num, 26 - num);
    }
}