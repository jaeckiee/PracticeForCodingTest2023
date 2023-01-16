import java.util.*;
import java.io.*;


public class Main
{
    public static final int MAX_MEM_SIZE = 900;

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < testCase; i++){
            int numOfService = sc.nextInt();
            int answer = 0;
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
            TreeMap<Integer, Integer> minMap = new TreeMap<>();
            sc.nextLine();
            String currLine = sc.nextLine();
            String[] memStrArr = currLine.split(" ");
            for (int serviceIdx = 0; serviceIdx < numOfService; serviceIdx++){
                maxHeap.add(Integer.parseInt(memStrArr[serviceIdx]));
            }
            while (!maxHeap.isEmpty()){
                int currMaxMem = maxHeap.poll();
                Integer minMem = minMap.ceilingKey(currMaxMem);
                if (minMem == null){
                    answer++;
                    int res = MAX_MEM_SIZE - currMaxMem;
                    if (res > 0){
                        if (minMap.containsKey(res)){
                            minMap.put(res, minMap.get(res) + 1);
                        }
                        else{
                            minMap.put(res, 1);
                        }
                    }
                }
                else{
                    int res = minMem - currMaxMem;
                    if (minMap.get(minMem) > 1){
                        minMap.put(minMem, minMap.get(minMem) - 1);
                    }
                    else{
                        minMap.remove(minMem);
                    }
                    if (res > 0){
                        if (minMap.containsKey(res)){
                            minMap.put(res, minMap.get(res) + 1);
                        }
                        else{
                            minMap.put(res, 1);
                        }
                    }
                }
            }
            System.out.println(answer);
        }
    }
}