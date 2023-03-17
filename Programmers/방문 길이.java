import java.util.*;

class Edge{
    int x1;
    int y1;
    int x2;
    int y2;
    
    Edge(int x1, int y1, int x2, int y2){
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }
    @Override
    public int hashCode(){
        return x1 + y1 + x2 + y2;
    }
    
    @Override
    public boolean equals(Object o){
        Edge edge = (Edge) o;
        if(this.x1 != edge.x1){
            return false;
        }
        if(this.y1 != edge.y1){
            return false;
        }
        if(this.x2 != edge.x2){
            return false;
        }
        if(this.y2 != edge.y2){
            return false;
        }
        return true;
    }
}

class Solution {
    public int[] dx = {1, -1, 0, 0};
    public int[] dy = {0, 0, 1, -1};
    public int solution(String dirs) {
        int answer = 0;
        int stringLen = dirs.length();
        int currX = 0;
        int currY = 0;
        int prevX = 0;
        int prevY = 0;
        Set<Edge> set = new HashSet<>();
        for(int i = 0; i < stringLen; i++){
            int type = 0;
            if(dirs.charAt(i) == 'U'){
                type = 0;
            }
            else if(dirs.charAt(i) == 'D'){
                type = 1;
            }
            else if(dirs.charAt(i) == 'R'){
                type = 2;
            }
            else if(dirs.charAt(i) == 'L'){
                type = 3;
            }
            if(currX + dx[type] < -5| currX + dx[type] > 5){
                continue;
            }
            if(currY + dy[type] < -5| currY + dy[type] > 5){
                continue;
            }
            prevX = currX;
            prevY = currY;
            currX = currX + dx[type];
            currY = currY + dy[type];
            if(prevX > currX || (prevX == currX && prevY > currY)){
                set.add(new Edge(currX, currY, prevX, prevY));
            }
            else{
                set.add(new Edge(prevX, prevY, currX, currY));
            }
        }
        answer = set.size();
        return answer;
    }
}