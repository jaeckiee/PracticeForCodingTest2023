import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int zeroCount = 0;
        int sizeOfWantArr = want.length;
        int sizeOfDiscountArr = discount.length;
        HashMap<String, Integer> wantNameAndNum = new HashMap<>();
        for (int i = 0; i < sizeOfWantArr; i++){
            wantNameAndNum.put(want[i], number[i]);
        }
        for (int i = 0; i < sizeOfDiscountArr - 9; i++){
            if (i == 0){
                for (int discountIdx = 0; discountIdx < 10; discountIdx++){
                    String discountItem = discount[discountIdx];
                    if (wantNameAndNum.containsKey(discountItem)){
                        int dicountItemNum = wantNameAndNum.get(discountItem);
                        wantNameAndNum.replace(discountItem, dicountItemNum - 1);
                        if (dicountItemNum == 1){
                            zeroCount++;
                        }
                        if (dicountItemNum == 0){
                            zeroCount--;
                        }
                    }
                }
                
            }
            else{
                String addDiscount = discount[i + 9];
                String removeDiscount = discount[i - 1];
                if (wantNameAndNum.containsKey(addDiscount)){
                    int addDicountItemNum = wantNameAndNum.get(addDiscount);
                    wantNameAndNum.replace(addDiscount, addDicountItemNum - 1);
                    if (addDicountItemNum == 1){
                        zeroCount++;
                    }
                    if (addDicountItemNum == 0){
                        zeroCount--;
                    }
                }
                if (wantNameAndNum.containsKey(removeDiscount)){
                    int removeDicountItemNum = wantNameAndNum.get(removeDiscount);
                    wantNameAndNum.replace(removeDiscount, removeDicountItemNum + 1);
                    if (removeDicountItemNum == -1){
                        zeroCount++;
                    }
                    if (removeDicountItemNum == 0){
                        zeroCount--;
                    }
                }
            }
            if (zeroCount == sizeOfWantArr){
                answer = answer + 1;
            }
        }
        
        
        return answer;
    }
}