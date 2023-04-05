import java.util.*;

class Main {
    public static int n;
    public static int m;
    public static int[][] map;
    public static int result;
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        List<Integer> zeroIndex = new ArrayList<>();
        n = sc.nextInt();
        m = sc.nextInt();
        result = 0;
        map = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                int tmp = sc.nextInt();;
                map[i][j] = tmp;
                if(tmp == 0){
                    zeroIndex.add(i * m + j);
                }
            }
        }
        int listSize = zeroIndex.size();
        for(int i = 0; i < listSize - 2; i++){
            for(int j = i + 1; j < listSize - 1; j++){
                for(int l = j + 1; l < listSize; l++){
                    setResult(zeroIndex.get(i), zeroIndex.get(j), zeroIndex.get(l));
                }
            }
        }
        System.out.println(result);
    }

    public static void setResult(int firstIndex, int secondIndex, int thirdIndex){
        int tmpReusult = 0;
        int[][] tmpMap = new int[n][m];
        boolean[][] visit = new boolean[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                tmpMap[i][j] = map[i][j];
            }
        }
        int firstRow = firstIndex / m;
        int firstCol = firstIndex % m;
        int secondRow = secondIndex / m;
        int secondCol = secondIndex % m;
        int thirdRow = thirdIndex / m;
        int thirdCol = thirdIndex % m;
        tmpMap[firstRow][firstCol] = 1;
        tmpMap[secondRow][secondCol] = 1;
        tmpMap[thirdRow][thirdCol] = 1;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(tmpMap[i][j] == 2 && !visit[i][j]){
                    propagateVirus(i, j,tmpMap, visit);
                }
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(tmpMap[i][j] == 0){
                    tmpReusult++;
                }
            }
        }
        result = Math.max(result, tmpReusult);
    }
    public static void propagateVirus(int row, int col, int[][] map, boolean[][] visit){
        map[row][col] = 2;
        visit[row][col] = true;
        if(row - 1 >= 0 && !visit[row - 1][col] && map[row - 1][col] == 0){
            propagateVirus(row - 1, col, map, visit);
        }
        if(col - 1 >= 0 && !visit[row][col - 1] && map[row][col - 1] == 0){
            propagateVirus(row, col - 1, map, visit);
        }
        if(row + 1 < n && !visit[row + 1][col] && map[row + 1][col] == 0){
            propagateVirus(row + 1, col, map, visit);
        }
        if(col + 1 < m && !visit[row][col + 1] && map[row][col + 1] == 0){
            propagateVirus(row, col + 1, map, visit);
        }
    }
}
