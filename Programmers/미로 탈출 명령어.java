import java.util.*;

class Solution {
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        int diffRow = Math.abs(x - r);
        int diffCol = Math.abs(y - c);
        int remainMove = k - (diffRow + diffCol);
        if(remainMove < 0){
            return "impossible"; 
        }
        if(remainMove % 2 == 1){
            return "impossible";
        }
        int boundLeft = y - 1;
        int boundDown = n - x;
        int numL = 0;
        int numRL = 0;
        int numR = 0;
        int numD = 0;
        int numU = 0;
        if(x > r){
            numU = diffRow;
        }
        else if(r > x){
            numD = diffRow;
            boundDown -= numD;
        }
        
        if(y > c){
            numL = diffCol;
            boundLeft -= numL;
        }
        else if(c > y){
            numR = diffCol;
        }
        if(remainMove > 0 && boundDown > 0){
            if(remainMove <= boundDown * 2){
                numD += remainMove / 2;
                numU += remainMove / 2;
                remainMove = 0;
            }
            else{
                numD += boundDown;
                numU += boundDown;
                remainMove -= boundDown * 2;
            }
        }
        if(remainMove > 0 && boundLeft > 0){
            if(remainMove <= boundLeft * 2){
                numL += remainMove / 2;
                numR += remainMove / 2;
                remainMove = 0;
            }
            else{
                numL += boundLeft;
                numR += boundLeft;
                remainMove -= boundLeft * 2;
            }
        }
        numRL = remainMove / 2;
        
        StringBuffer sb = new StringBuffer();
        for(int i = 0 ; i < numD; i++){
            sb.append('d');
        }
        for(int i = 0 ; i < numL; i++){
            sb.append('l');
        }
        for(int i = 0 ; i < numRL; i++){
            sb.append('r');
            sb.append('l');
        }
        for(int i = 0 ; i < numR; i++){
            sb.append('r');
        }
        for(int i = 0 ; i < numU; i++){
            sb.append('u');
        }
        
        String answer = sb.toString();
       
        return answer;
    }
}