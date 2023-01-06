class Solution {
    public int getGCD(int input1, int input2){
        if (input1 < input2){
            int tmp = input1;
            input1 = input2;
            input2 = tmp;
        }
        while (input2 > 0){
            int r = input1 % input2;
            input1 = input2;
            input2 = r;
        }
        return input1;
    }
    
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        int GCD1 = arrayA[0];
        for (int numA : arrayA){
            GCD1 = getGCD(GCD1, numA);
            if (GCD1 == 1){
                GCD1 = -1;
                break;
            }
        }
        if (GCD1 != -1){
            for (int numB : arrayB){
                if (numB % GCD1 == 0){
                    GCD1 = -1;
                    break;
                }
            }
        }
        
        int GCD2 = arrayB[0];
        for (int numB : arrayB){
            GCD2 = getGCD(GCD2, numB);
            if (GCD2 == 1){
                GCD2 = -1;
                break;
            }
        }
        if (GCD2 != -1){
            for (int numA : arrayA){
                if (numA % GCD2 == 0){
                    GCD2 = -1;
                    break;
                }
            }
        }
        
        if (GCD1 == -1 && GCD2 == -1){
            return 0;
        }
        answer = Math.max(GCD1, GCD2);
            
        return answer;
    }
}