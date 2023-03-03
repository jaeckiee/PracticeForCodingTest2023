import java.util.*;
class Node implements Comparable<Node>{
    int score;
    int[] arr;
    Node(int score, int[] arr){
        this.score = score;
        this.arr = arr;
    }
    @Override
    public int compareTo(Node o){
        if(this.score == o.score){
            for(int i = 10; i >= 0; i--){
                if(this.arr[i] == o.arr[i]){
                    if(i == 0){
                        return 0;
                    }
                    else{
                        continue;
                    }
                }
                else{
                    return o.arr[i] - this.arr[i];
                }
            }
        }
        return o.score - this.score;
    }
}
class Solution {
    public int[] score;
    public int[] bound;
    public int ryanScore;
    public int numOfArrows;
    public PriorityQueue<Node> pq;
    public int[] solution(int n, int[] info) {
        int[] answer;
        score = new int[11];
        bound = new int[11];
        numOfArrows = n;
        ryanScore = 0;
        pq = new PriorityQueue<>();
        for(int i = 0; i < 10; i++){
            if(info[i] > 0){
                ryanScore += 10 - i;
                score[i] = 2 * (10 - i);
                bound[i] = info[i] + 1;
            }
            else{
                score[i] = 10 - i;
                bound[i] = 1;
            }
        }
        int[] tmpResult = new int[11];
        check(0, tmpResult, 0, numOfArrows);
        if(pq.isEmpty()){
            answer = new int[1];
            answer[0] = -1;
        }
        else{
            Node node = pq.poll();
            answer = node.arr;
            
        }
        
        return answer;
    }
    public void check(int index, int[] tmpResult, int tmpScore, int tmpNumOfArrows){
        if(tmpNumOfArrows == 0 || index == 10){
            tmpResult[10] = tmpNumOfArrows;
            if(tmpScore > ryanScore){
                pq.add(new Node(tmpScore, tmpResult));
            }
            return;
        }
        int[] tmpResult1 = new int[11];
        int[] tmpResult2 = new int[11];
        for(int i = 0; i < 11; i++){
            tmpResult1[i] = tmpResult[i];
            tmpResult2[i] = tmpResult[i];
        }
        if(tmpNumOfArrows >= bound[index]){
            tmpResult2[index] = bound[index];
            check(index + 1, tmpResult2, tmpScore + score[index], tmpNumOfArrows - bound[index]);
        }
        check(index + 1, tmpResult1, tmpScore, tmpNumOfArrows);
    }
}