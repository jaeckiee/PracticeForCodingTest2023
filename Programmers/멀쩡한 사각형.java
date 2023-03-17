class Solution {
    public long solution(int w, int h) {
        long sum = (long) w * h;
        long answer = 1;
        int gcdNum = gcd(w, h);
        int dividedW = w / gcdNum;
        int dividedH = h / gcdNum;
        answer = answer * gcdNum;
        if(dividedW > dividedH){
            int tmp = dividedW;
            dividedW = dividedH;
            dividedH = tmp;
        }
        answer = sum - (answer * (dividedH + dividedW - 1));
        return answer;
    }
    public int gcd(int a, int b){
        if(a > b){
            int tmp = a;
            a = b;
            b = tmp;
        }
        while(a != 0){
            int mod = b % a;
            b = a;
            a = mod;
        }
        return b;
    }
}