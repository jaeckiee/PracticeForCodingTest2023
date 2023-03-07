import java.util.*;
class Cor implements Comparable<Cor>{
    long x;
    long y;
    Cor(long x, long y){
        this.x = x;
        this.y = y;
    }
    @Override
    public int compareTo(Cor o){
        if(this.y == o.y){
            if(this.x < o.x){
                return -1;
            }
            else if(this.x > o.x){
                return 1;
            }
            else{
                return 0;
            }
        }
        else{
            if(this.y < o.y){
                return 1;
            }
            return -1;
        }
    }
}
class Solution {
    public String[] solution(int[][] line) {
        int numOfLines = line.length;
        TreeSet<Cor> treeSet = new TreeSet<>();
        long minX = Long.MAX_VALUE;
        long minY = Long.MAX_VALUE;
        long maxX = Long.MIN_VALUE;
        long maxY = Long.MIN_VALUE;
        for(int i = 0; i < numOfLines - 1; i++){
            for(int j = i + 1 ; j < numOfLines; j++){
                long A = line[i][0];
                long B = line[i][1];
                long E = line[i][2];
                long C = line[j][0];
                long D = line[j][1];
                long F = line[j][2];
                if(A * D - B * C == 0){
                    continue;
                }
                if((B * F - E * D) % (A * D - B * C) != 0){
                    continue;
                }
                if((E * C - A * F) % (A * D - B * C) != 0){
                    continue;
                }
                long X = (B * F - E * D) / (A * D - B * C);
                long Y = (E * C - A * F) / (A * D - B * C);
                treeSet.add(new Cor(X, Y));
                minX = Math.min(minX, X);
                minY = Math.min(minY, Y);
                maxX = Math.max(maxX, X);
                maxY = Math.max(maxY, Y);
            }
        }
        long moveX = -minX;
        long moveY = -minY;
        maxX = maxX + moveX;
        maxY = maxY + moveY;
        String[] answer = new String[(int)maxY + 1];
        for(int i = (int)maxY; i >= 0; i--){
            StringBuffer sb = new StringBuffer();
            for(int j = 0; j <= (int)maxX; j++){
                if(treeSet.isEmpty()){
                    sb.append(".");
                    continue;
                }
                Cor cor = treeSet.first();
                if((cor.x + moveX) == j && (cor.y + moveY) == i){
                    sb.append("*");
                    treeSet.pollFirst();
                }
                else{
                    sb.append(".");
                }
            }
            String string = sb.toString();
            answer[(int)maxY - i] = string;
        }
        return answer;
    }
}