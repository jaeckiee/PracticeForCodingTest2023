import java.util.*;

class Node{
    public int x;
    public int y;
    public int type;
    public Node(int x, int y, int type){
        this.x = x;
        this.y = y;
        this.type = type;
    }
}
class Main {
    public static int result;
    public static int n;
    public static int m;
    public static List<Node> nodes;
    public static boolean[][] visit;
    public static boolean[][] wall;
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        nodes = new ArrayList<>();
        n = sc.nextInt();
        m = sc.nextInt();
        result = n * m;
        visit = new boolean[n][m];
        wall = new boolean[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                int tmp = sc.nextInt();
                if(tmp != 0){
                    visit[i][j] = true;
                    if(tmp != 6){
                        nodes.add(new Node(i, j, tmp));
                    }
                    else{
                        wall[i][j] = true;
                    }
                }
            }
        }
        int[] types = new int[nodes.size()];
        setTypesAndCal(0, types);
        System.out.println(result);
    }

    public static void setTypesAndCal(int index, int[] types){
        if(index == nodes.size()){
            boolean[][] tmpVisit = new boolean[n][m];
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    tmpVisit[i][j] = visit[i][j];
                }
            }
            for(int i = 0; i < nodes.size(); i++){
                int currType = types[i];
                Node currNode = nodes.get(i);
                int nodeX = currNode.x;
                int nodeY = currNode.y;
                int nodeType = currNode.type;
                boolean[] flags = new boolean[4];
                if(nodeType == 1){
                    flags[currType] = true;
                }
                else if(nodeType == 2){
                    flags[currType] = true;
                    flags[(currType + 2) % 4] = true;
                }
                else if(nodeType == 3){
                    flags[currType] = true;
                    flags[(currType + 1) % 4] = true;
                }
                else if(nodeType == 4){
                    flags[currType] = true;
                    flags[(currType + 1) % 4] = true;
                    flags[(currType + 2) % 4] = true;
                }
                else if(nodeType == 5){
                    flags[currType] = true;
                    flags[(currType + 1) % 4] = true;
                    flags[(currType + 2) % 4] = true;
                    flags[(currType + 3) % 4] = true;
                }
                if(flags[0]){
                    for(int rowIndex = nodeX; rowIndex >= 0; rowIndex--){
                        if(wall[rowIndex][nodeY]){
                            break;
                        }
                        tmpVisit[rowIndex][nodeY] = true;
                    }
                }
                if(flags[1]){
                    for(int colIndex = nodeY; colIndex < m; colIndex++){
                        if(wall[nodeX][colIndex]){
                            break;
                        }
                        tmpVisit[nodeX][colIndex] = true;
                    }
                }
                if(flags[2]){
                    for(int rowIndex = nodeX; rowIndex < n; rowIndex++){
                        if(wall[rowIndex][nodeY]){
                            break;
                        }
                        tmpVisit[rowIndex][nodeY] = true;
                    }
                }
                if(flags[3]){
                    for(int colIndex = nodeY; colIndex >= 0; colIndex--){
                        if(wall[nodeX][colIndex]){
                            break;
                        }
                        tmpVisit[nodeX][colIndex] = true;
                    }
                }
            }

            int tmpResult = 0;
            for(int row = 0; row < n; row++){
                for(int col = 0; col < m; col++){
                    if(!tmpVisit[row][col]){
                        tmpResult++;
                    }
                }
            }
            result = Math.min(result, tmpResult);
            return;
        }
        for(int i = 0; i < 4; i++){
            int[] tmpTypes = new int[nodes.size()];
            for(int j = 0; j < nodes.size(); j++){
                tmpTypes[j] = types[j];
            }
            tmpTypes[index] = i;
            setTypesAndCal(index + 1, tmpTypes);
        }
    }
}
