import java.util.*;

class Solution {
    public Comparator<String> comparator;
    PriorityQueue<String> pq;
    public String solution(int[] numbers) {
        String answer;
        StringBuffer sb = new StringBuffer();
        comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                StringBuffer sb1 = new StringBuffer();
                StringBuffer sb2 = new StringBuffer();
                sb1.append(o1);
                sb1.append(o2);
                sb2.append(o2);
                sb2.append(o1);
                int lenO1 = sb1.length();
                int lenO2 = sb2.length();
                for(int i = 0; i < lenO1; i++){
                    if(sb1.charAt(i) != sb2.charAt(i)){
                        return (int)(sb2.charAt(i) - sb1.charAt(i));
                    }
                }
                return 0;
            }
        };
        pq = new PriorityQueue<>(comparator);
        for(int number : numbers){
            String tmp = String.valueOf(number);
            pq.add(tmp);
        }
        while(!pq.isEmpty()){
            String top = pq.poll();
            sb.append(top);
        }
        while(sb.length() > 0 && sb.charAt(0) == '0'){
            sb.deleteCharAt(0);
        }
        if(sb.length() == 0){
            sb.append('0');
        }
        answer = sb.toString();
        return answer;
    }
}