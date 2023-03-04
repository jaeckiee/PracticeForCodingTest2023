import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String resultStr = "";
        while(n > 0){
            resultStr = String.valueOf(n % k) + resultStr;
            n = n / k;
        }
        String[] splitedStr = resultStr.split("0");
        for(String str : splitedStr){
            if(str.equals("")){
                continue;
            }
            long num = Long.parseLong(str);
            if(num == 1){
                continue;
            }
            long longSqrtNum = (long)Math.sqrt(num);
            boolean flag = true;
            for(int i = 2; i <= longSqrtNum; i++){
                if(num % i == 0){
                    flag = false;
                    break;
                }
            }
            if(flag){
                answer++;
            }
        }
        return answer;
    }
}