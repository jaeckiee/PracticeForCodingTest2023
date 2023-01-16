import java.util.*;
import java.io.*;


public class Main
{
    public static void main(String args[])
    {   
        int answer = 0;
        Scanner sc = new Scanner(System.in);
        String boundAndKind = sc.nextLine();
        String[] boundAndKindArr = boundAndKind.split(" ");
        TreeMap<Integer, Integer> treeMap = new TreeMap<>(Collections.reverseOrder());
        int weightBound = Integer.parseInt(boundAndKindArr[0]);
        int numOfKind = Integer.parseInt(boundAndKindArr[1]);
        for (int i = 0; i < numOfKind; i++){
            String currLine = sc.nextLine();
            String[] weightAndPrice = currLine.split(" ");
            int weight = Integer.parseInt(weightAndPrice[0]);
            int price = Integer.parseInt(weightAndPrice[1]);
            if (treeMap.containsKey(price)){
                treeMap.put(price, treeMap.get(price) + weight);
            }
            else{
                treeMap.put(price, weight);
            }
        }
        while (weightBound > 0 && !treeMap.isEmpty()){
            int maxKey = treeMap.firstKey();
            int weight = treeMap.get(maxKey);
            if (weightBound < weight){
                answer = answer + maxKey * weightBound;
                break;
            }
            else{
                answer = answer + maxKey * weight;
                treeMap.remove(maxKey);
                weightBound = weightBound - weight;
            }
        }
        System.out.println(answer);
    }
}