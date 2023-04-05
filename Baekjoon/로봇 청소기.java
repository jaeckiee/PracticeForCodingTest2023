import java.util.*;

class Main {
    public static int n;
    public static int m;
    public static int rowIndex;
    public static int colIndex;
    public static int type;
    public static int result;
    public static int[][] map;
    public static boolean[][] visit;
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};
    public static void main(String args[]) throws Exception {
        result = 0;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        rowIndex = sc.nextInt();
        colIndex = sc.nextInt();
        type = sc.nextInt();
        map = new int[n][m];
        visit = new boolean[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                map[i][j] = sc.nextInt();
            }
        }

        clean();

        System.out.println(result);
    }

    public static void clean(){
        if(map[rowIndex][colIndex] == 0 && !visit[rowIndex][colIndex]){
            visit[rowIndex][colIndex] = true;
            result++;
        }
        boolean flag = false;
        for(int i = 0; i < 4; i++){
            if(map[rowIndex + dx[i]][colIndex + dy[i]] == 0 && !visit[rowIndex + dx[i]][colIndex + dy[i]]){
                flag = true;
            }
        }
        if(flag){
            type = (type + 3) % 4;
            if(map[rowIndex + dx[type]][colIndex + dy[type]] == 0 && !visit[rowIndex + dx[type]][colIndex + dy[type]]){
                rowIndex = rowIndex + dx[type];
                colIndex = colIndex + dy[type];
            }
            clean();
        }
        else{
            if(map[rowIndex + dx[(type + 2) % 4]][colIndex + dy[(type + 2) % 4]] == 1){
                return;
            }
            rowIndex = rowIndex + dx[(type + 2) % 4];
            colIndex = colIndex + dy[(type + 2) % 4];
            clean();
        }
    }
}
