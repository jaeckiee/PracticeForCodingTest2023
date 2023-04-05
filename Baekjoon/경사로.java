import java.util.*;

class Main {
    public static int result;
    public static int n;
    public static int l;
    public static int[][] map;
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        result = 0;
        n = sc.nextInt();
        l = sc.nextInt();
        map = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                map[i][j] = sc.nextInt();
            }
        }
        for(int i = 0; i < n; i++){
            rowCheck(i);
            colCheck(i);
        }

        System.out.println(result);
    }
    public static void rowCheck(int rowIndex){
        boolean flag = true;

        int currHeight = map[rowIndex][0];
        int count = 1;
        int colIndex = 1;
        while(colIndex < n){
            if(map[rowIndex][colIndex] == currHeight){
                count++;
                colIndex++;
            }
            else{
                if(count < 0){
                    flag = false;
                    break;
                }
                if(Math.abs(map[rowIndex][colIndex] - currHeight) > 1){
                    flag = false;
                    break;
                }
                if(map[rowIndex][colIndex] > currHeight){
                    if(count < l){
                        flag = false;
                        break;
                    }
                    count = 1;
                }
                else{
                    count = -(l - 1);
                }
                currHeight = map[rowIndex][colIndex];
                colIndex++;
            }
        }
        if(count < 0){
            flag = false;
        }

        if(flag){
            result++;
        }
    }
    public static void colCheck(int colIndex){
        boolean flag = true;

        int currHeight = map[0][colIndex];
        int count = 1;
        int rowIndex = 1;
        while(rowIndex < n){
            if(map[rowIndex][colIndex] == currHeight){
                count++;
                rowIndex++;
            }
            else{
                if(count < 0){
                    flag = false;
                    break;
                }
                if(Math.abs(map[rowIndex][colIndex] - currHeight) > 1){
                    flag = false;
                    break;
                }
                if(map[rowIndex][colIndex] > currHeight){
                    if(count < l){
                        flag = false;
                        break;
                    }
                    count = 1;
                }
                else{
                    count = -(l - 1);
                }
                currHeight = map[rowIndex][colIndex];
                rowIndex++;
            }
        }

        if(count < 0){
            flag = false;
        }

        if(flag){
            result++;
        }
    }
}
