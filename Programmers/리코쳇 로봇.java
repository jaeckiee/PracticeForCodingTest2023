import java.util.*;
class Node{
    int x;
    int y;
    int count;
    int type;
    Node(int x, int y, int count, int type){
        this.x = x;
        this.y = y;
        this.count = count;
        this.type = type;
    }
}
class Solution {
    public int startX;
    public int startY;
    public int distX;
    public int distY;
    public int height;
    public int width;
    public int result;
    public boolean[][][] visited;
    public boolean[][] block;
    public int[] dx = {1, -1, 0, 0};
    public int[] dy = {0, 0, 1, -1};
    public int solution(String[] board) {
        int answer = -1;
        result = -1;
        height = board.length;
        width = board[0].length();
        block = new boolean[height][width];
        visited = new boolean[height][width][4];
        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                if(board[i].charAt(j) == 'R'){
                    startX = i;
                    startY = j;
                }
                else if(board[i].charAt(j) == 'G'){
                    distX = i;
                    distY = j;
                }
                else if(board[i].charAt(j) == 'D'){
                    block[i][j] = true;
                }
            }
        }
        bfs();
        answer = result;
        return answer;
    }
    public void bfs(){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(startX, startY, 1, 0));
        q.add(new Node(startX, startY, 1, 1));
        q.add(new Node(startX, startY, 1, 2));
        q.add(new Node(startX, startY, 1, 3));
        visited[startX][startY][0] = true;
        visited[startX][startY][1] = true;
        visited[startX][startY][2] = true;
        visited[startX][startY][3] = true;
        while(!q.isEmpty()){
            Node node = q.poll();
            int x = node.x;
            int y = node.y;
            int count = node.count;
            int type = node.type;
            while(true){
                if(x + dx[type] < 0 || x + dx[type] >= height){
                    break;
                }
                if(y + dy[type] < 0 || y + dy[type] >= width){
                    break;
                }
                if(block[x + dx[type]][y + dy[type]]){
                    break;
                }
                x = x + dx[type];
                y = y + dy[type];
                visited[x][y][type] = true;
            }
            if(x == distX && y == distY){
                result = count;
                return;
            }
            for(int i = 0; i < 4; i++){
                if(visited[x][y][i]){
                    continue;
                }
                visited[x][y][i] = true;
                q.add(new Node(x, y, count + 1, i));
            }
        }
    }
}