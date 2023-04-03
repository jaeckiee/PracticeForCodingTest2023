import java.util.*;

class Solution {
    public List<Integer> numList;
    public int count;
    public Set<Integer> set;
    public int numbersLength;
    public int solution(String numbers) {
        int answer = 0;
        numList = new ArrayList<>();
        count = 0;
        set = new HashSet<>();
        numbersLength = numbers.length();
        for(int i = 0; i < numbers.length(); i++){
            char c = numbers.charAt(i);
            int num = (int) (c - '0');
            if((count / (int)Math.pow(10, num)) % 10 == 0){
                numList.add(num);
            }    
            count = count + (int)Math.pow(10, num);
        }
        setCheckNums();
        for(int checkNum : set){
            if(isPrime(checkNum)){
                answer++;
            }
        }
        return answer;
    }
    public void setCheckNums(){
        for(int i = 0; i < numList.size(); i++){
            setCheckNum(0, 0, i);
        }
    }
    public void setCheckNum(int tmp, int visit, int visitIndex){
        int num = numList.get(visitIndex);
        visit = visit + (int)Math.pow(10, num);
        if((count / (int)Math.pow(10, num)) % 10 < (visit / (int)Math.pow(10, num)) % 10){
            return;
        }
        tmp = tmp * 10 + num;
        set.add(tmp);
        for(int i = 0; i < numList.size(); i++){
            setCheckNum(tmp, visit, i);
        }
    }
    public boolean isPrime(int num){
        if(num == 0){
            return false;
        }
        if(num == 1){
            return false;
        }
        double sqrtNum = Math.sqrt((double)num);
        int sqrt = (int) sqrtNum;
        for(int i = 2;  i <= sqrt; i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }
}