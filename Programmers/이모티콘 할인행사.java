import java.util.*;

class Node implements Comparable<Node>{
    public int numOfUsers;
    public int sumCost;
    public Node(int numOfUsers, int sumCost){
        this.numOfUsers = numOfUsers;
        this.sumCost = sumCost;
    }
    @Override
    public int compareTo(Node o){
        if(this.numOfUsers == o.numOfUsers){
            return o.sumCost - this.sumCost;
        } 
        return o.numOfUsers - this.numOfUsers;
    }
}

class Solution {
    public int[] emoticonCosts;
    public int numOfEmoticons;
    public int numOfUsers;
    public int[][] userInformation;
    public PriorityQueue<Node> pq;
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int[2];
        numOfEmoticons = emoticons.length;
        numOfUsers = users.length;
        emoticonCosts = new int[numOfEmoticons];
        pq = new PriorityQueue<>();
        for(int i = 0; i < numOfEmoticons; i++){
            emoticonCosts[i] = emoticons[i];
        }
        userInformation = new int[numOfUsers][2];
        for(int i = 0; i < numOfUsers; i++){
            for(int j = 0; j < 2; j++){
                userInformation[i][j] = users[i][j];
            }
        }
        int[] sailPercents = new int[numOfEmoticons];
        check(0, sailPercents);
        Node node = pq.poll();
        answer[0] = node.numOfUsers;
        answer[1] = node.sumCost;
        return answer;
    }
    
    public void check(int emoticonsIndex, int[] sailPercents){
        if(emoticonsIndex == numOfEmoticons){
            int tmpNumOfUsers = 0;
            int tmpSumCost = 0;

            for(int i = 0; i < numOfUsers; i++){
                int currCost = 0;
                int[] currUserInformation = userInformation[i];
                int boundPercent = currUserInformation[0];
                int boundCost = currUserInformation[1];
                for(int j = 0; j < numOfEmoticons; j++){
                    if(sailPercents[j] >= boundPercent){
                        currCost += emoticonCosts[j] * (100 - sailPercents[j]) / 100;
                    }
                }   
                if(currCost >= boundCost){
                    tmpNumOfUsers++;
                }
                else{
                    tmpSumCost += currCost;
                }
            }
            pq.add(new Node(tmpNumOfUsers, tmpSumCost));
            return;
        }
        int[] sail10Percent = new int[numOfEmoticons];
        int[] sail20Percent = new int[numOfEmoticons];
        int[] sail30Percent = new int[numOfEmoticons];
        int[] sail40Percent = new int[numOfEmoticons];
        for(int i = 0; i < numOfEmoticons; i++){
            sail10Percent[i] = sailPercents[i];
            sail20Percent[i] = sailPercents[i];
            sail30Percent[i] = sailPercents[i];
            sail40Percent[i] = sailPercents[i];
        }
        sail10Percent[emoticonsIndex] = 10;
        sail20Percent[emoticonsIndex] = 20;
        sail30Percent[emoticonsIndex] = 30;
        sail40Percent[emoticonsIndex] = 40;
        check(emoticonsIndex + 1, sail10Percent);
        check(emoticonsIndex + 1, sail20Percent);
        check(emoticonsIndex + 1, sail30Percent);
        check(emoticonsIndex + 1, sail40Percent);
    }
}