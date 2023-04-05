import java.util.*;

class Main {
    public static int result;
    public static int[][] cogs;
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        result = 0;
        cogs = new int[4][8];
        for(int i = 0; i < 4; i++){
            String line = sc.next();
            for(int j = 0; j < 8; j++){
                cogs[i][j] = (int) (line.charAt(j) - '0');
            }
        }
        int time = sc.nextInt();
        for(int i = 0; i < time; i++){
            int currCogNum = sc.nextInt();
            int currCogIndex = currCogNum - 1;
            int type = sc.nextInt();
            int[] types = new int[4];
            setTypes(currCogIndex, type, types);
            for(int cogIndex = 0; cogIndex < 4; cogIndex++){
                rotate(cogIndex, types[cogIndex]);
            }
        }
        if(cogs[0][0] == 1){
            result += 1;
        }
        if(cogs[1][0] == 1){
            result += 2;
        }
        if(cogs[2][0] == 1){
            result += 4;
        }
        if(cogs[3][0] == 1){
            result += 8;
        }
        System.out.println(result);
    }
    public static void setTypes(int cogIndex, int type, int[] types){
        boolean[] visit = new boolean[4];
        visit[cogIndex] = true;
        types[cogIndex] = type;
        Queue<Integer> currQ = new LinkedList<>();
        Queue<Integer> prevQ = new LinkedList<>();
        if(cogIndex - 1 >= 0){
            visit[cogIndex - 1] = true;
            currQ.add(cogIndex - 1);
            prevQ.add(cogIndex);
        }
        if(cogIndex + 1 < 4) {
            visit[cogIndex + 1] = true;
            currQ.add(cogIndex + 1);
            prevQ.add(cogIndex);
        }
        while(!currQ.isEmpty()){
            int currCogIndex = currQ.poll();
            int prevCogIndex = prevQ.poll();
            if(currCogIndex == prevCogIndex + 1){
                if(cogs[currCogIndex][6] == cogs[prevCogIndex][2]){
                    continue;
                }
            }
            else{
                if(cogs[currCogIndex][2] == cogs[prevCogIndex][6]){
                    continue;
                }
            }
            types[currCogIndex] = -types[prevCogIndex];
            if(currCogIndex + 1 < 4 && !visit[currCogIndex + 1]){
                visit[currCogIndex + 1] = true;
                currQ.add(currCogIndex + 1);
                prevQ.add(currCogIndex);
            }
            if(currCogIndex - 1 >= 0 && !visit[currCogIndex - 1]){
                visit[currCogIndex - 1] = true;
                currQ.add(currCogIndex - 1);
                prevQ.add(currCogIndex);
            }
        }
    }
    public static void rotate(int cogIndex, int type){
        if(type == 0){
            return;
        }
        if(type == 1){
            rightRotate(cogIndex);
        }
        else{
            leftRotate(cogIndex);
        }
    }
    public static void rightRotate(int cogIndex){
        int tmp = cogs[cogIndex][7];
        for(int i = 7; i > 0; i--){
            cogs[cogIndex][i] = cogs[cogIndex][i - 1];
        }
        cogs[cogIndex][0] = tmp;
    }
    public static void leftRotate(int cogIndex){
        int tmp = cogs[cogIndex][0];
        for(int i = 0; i < 7; i++){
            cogs[cogIndex][i] = cogs[cogIndex][i + 1];
        }
        cogs[cogIndex][7] = tmp;
    }
}
