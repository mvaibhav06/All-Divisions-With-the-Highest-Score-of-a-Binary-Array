import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DivisonScore {
    public static List<Integer> maxScoreIndices(int[] nums) {
        List<Integer> out = new ArrayList<>();
        HashMap<Integer,List<Integer>> temp = new HashMap<>();

        int zeroes = 0;
        int ones = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]==0){
                zeroes++;
            }else{
                ones++;
            }
        }

        int scoreA = 0;
        int scoreB = ones;
        int score = scoreA+scoreB;
        List<Integer> weds = new ArrayList<>();
        weds.add(0);
        temp.put(score, weds);
        for(int i=1; i<nums.length; i++){
            if(nums[i-1] == 0){
                scoreA++;
            }else{
                scoreB--;
            }
            score = scoreA+scoreB;
            List<Integer> jay = new ArrayList<>();
            if(temp.containsKey(score)){
                jay = temp.get(score);
            }
            jay.add(i);
            temp.put(score,jay);
        }
        score = zeroes;
        List<Integer> hey = new ArrayList<>();
        if(temp.containsKey(score)){
            hey = temp.get(score);
        }
        hey.add(nums.length);
        temp.put(score,hey);

        int max = Integer.MIN_VALUE;

        for(int key: temp.keySet()){
            if(key > max){
                max = key;
            }
        }

        out = temp.get(max);
        return out;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,0};
        System.out.println(maxScoreIndices(nums));
    }
}
