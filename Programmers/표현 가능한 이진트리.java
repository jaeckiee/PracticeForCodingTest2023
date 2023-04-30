import java.util.*;

class Solution {
    public boolean resultFlag;
    public String checkString;
    public int[] solution(long[] numbers) {
        int numOfNumbers = numbers.length;
        int[] answer = new int[numOfNumbers];
        int index = 0;
        for(long number : numbers){
            answer[index++] = getResult(number);
        }
        return answer;
    }
    public int getResult(long number){
        checkString = long2Str(number);
        resultFlag = true;
        check(0, checkString.length() - 1, false);
        return resultFlag ? 1 : 0;
    }
    public void check(int start, int end, boolean isBeforeZero){
        if(start > end){
            return;
        }
        int mid = (start + end) / 2;
        if(isBeforeZero){
            if(checkString.charAt(mid) == '1'){
                resultFlag = false;
                return;
            }
            check(start, mid - 1, true);
            check(mid + 1, end, true);
        }
        else{
            if(checkString.charAt(mid) == '1'){
                check(start, mid - 1, false);
                check(mid + 1, end, false);
            }
            else{
                check(start, mid - 1, true);
                check(mid + 1, end, true);
            }
        }
    }
    public String long2Str(long number){
        StringBuffer sb = new StringBuffer();
        while(number > 0){
            if(number % 2 == 1){
                sb.append('1');
            }
            else{
                sb.append('0');
            }
            number = number / 2;
        }
        int checkSize = 1;
        int nextPlus = 2;
        int sbSize = sb.length();
        while(sbSize > checkSize){
            checkSize = checkSize + nextPlus;
            nextPlus = nextPlus * 2;
        }
        for(int i = 0; i < checkSize - sbSize; i++){
            sb.append('0');
        }
        sb = sb.reverse();
        return sb.toString();
    }
}