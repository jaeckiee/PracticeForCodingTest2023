import java.util.*;
class Node{
    char type;
    boolean[] inBound;
    public Node(char type){
        this.type = type;
        inBound = new boolean[4];
    }
}
class Solution {
    public PriorityQueue<Integer> pq = new PriorityQueue<>();
    public int up = 0;
    public int right = 1;
    public int down = 2;
    public int left = 3;
    public int direction;
    public int count;
    public int heigth;
    public int width;
    public Node[][] nodes;
    public int[] solution(String[] grid) {
        heigth = grid.length;
        width = grid[0].length();
        nodes = new Node[heigth][width];
        for(int i = 0; i < heigth; i++){
            for(int j = 0; j < width; j++){
                nodes[i][j] = new Node(grid[i].charAt(j));
            }
        }
        for(int i = 0; i < heigth; i++){
            for(int j = 0; j < width; j++){
                Node currNode = nodes[i][j];
                for(int k = 0; k < 4; k++){
                    if(!currNode.inBound[k]){
                        count = 0;
                        direction = k;
                        getCount(i, j);
                        pq.add(count);
                    }
                }
            }
        }
        int[] answer = new int[pq.size()];
        int index = 0;
        while(!pq.isEmpty()){
            int top = pq.poll();
            answer[index++] = top;
        }
        return answer;
    }
    public void getCount(int x, int y){
        while(true){
            Node node = nodes[x][y];
            if(direction == up){
                if(node.inBound[0]){
                    return;
                }    
                node.inBound[0] = true;
                count++;
            }
            else if(direction == right){
                if(node.inBound[1]){
                    return;
                }    
                node.inBound[1] = true;
                count++;
            }
            else if(direction == down){
                if(node.inBound[2]){
                    return;
                }    
                node.inBound[2] = true;
                count++;
            }
            else if(direction == left){
                if(node.inBound[3]){
                    return;
                }    
                node.inBound[3] = true;
                count++;
            }
            if(node.type == 'R'){
                direction = (direction + 1) % 4;
            }
            else if(node.type == 'L'){
                direction = (direction + 3) % 4;
            }
            if(direction == up){
                if(x - 1 < 0){
                    x = heigth;
                }
                x = x - 1;
            }
            else if(direction == right){
                if(y + 1 >= width){
                    y = -1;
                }
                y = y + 1;
            }
            else if(direction == down){
                if(x + 1 >= heigth){
                    x = -1;
                }
                x = x + 1;
            }
            else{
                if(y - 1 < 0){
                    y = width;
                }
                y = y - 1;
            }
        }
    }
}