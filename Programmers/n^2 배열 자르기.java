class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)(right - left + 1)];
        int index = 0;
        int leftX = (int) (left / n);
        int leftY = (int) (left % n);
        int rightX = (int) (right / n);
        int rightY = (int) (right % n);
        int indexX = leftX;
        int indexY = leftY;
        while(indexX != rightX || indexY != rightY){
            if(indexX  < indexY){
                answer[index++] = indexY + 1;
            }
            else{
                answer[index++] = indexX + 1;
            }
            indexY = (indexY + 1) % n;
            if(indexY == 0){
                indexX++;
            }
        }
        
        //final
        if(indexX  < indexY){
            answer[index++] = indexY + 1;
        }
        else{
            answer[index++] = indexX + 1;
        }
        return answer;
    }
}